# Transition Animation /转场动画

## 1. 什么是 Transition?

安卓 5.0 中 Activity 和 Fragment 变换是建立在名叫 Transitions 的安卓新特性之上的。这个诞生于 4.4 的 transition 框架
为在不同的 UI 状态之间产生动画效果提供了非常方便的 API。  

该框架主要基于两个概念：场景（scenes）和变换（transitions）。  
* 场景（scenes）定义了当前的 UI 状态
* 变换（transitions）则定义了在不同场景之间动画变化的过程。

虽然 transition 翻译为变换似乎很确切，但是总觉得还是没有直接使用 transition 直观，为了更好的理解下面个别地方直接用 transition 
代表变换。

当一个场景改变的时候，transition 主要负责：

（1）捕捉在开始场景和结束场景中每个 View 的状态。
（2）根据视图一个场景移动到另一个场景的差异创建一个 Animator。

在 Android 5.0 中 Transition 可以被用来实现 Activity 或者 Fragment 切换时的异常复杂的动画效果。虽然在以前的版本中，
已经可以使用 Activity 的 overridePendingTransition() 和 FragmentTransaction 的 setCustomAnimation() 来实现 
Activity 或者 Fragment 的动画切换，但是他们仅仅局限与将整个视图一起动画变换。新的 Lollipop API更进了一步，让单独的 view 
也可以在进入或者退出其布局容器中时发生动画效果，甚至还可以在不同的 activity/Fragment 中共享一个 view。

**Transitions Framework 主要作用或者应用场景**  
* 可以在activity之间跳转的时候添加动画
* 动画共享元素之间的转换活动
* activity中布局元素的过渡动画。
英语原文：
1. Animate activity layout content when transitioning from one activity to another.
2. Animate shared elements (Hero views) in transitions between activities.
3. Animate view changes within same activity.

## 实现 Activity 的切换动画-方法1--overridePendingTransition

**简介**：Activity 跳转动画是分为两个部分的：一个 Activity 的销毁动画与一个 Activity 的显示动画,其中一种实现方式是overridePendingTransition，实现方式如下：

### 1.Activity 跳转动画： overridePendingTransition 的代码样式 
这个方法很简单，只需要在跳转代码后边加上overridePendingTransition()方法即可。如下：
(1)调用：

            //在调用了 startActivity 方法之后立即调用 overridePendingTransition 方法
            Intent intent = new Intent(Trans1Act.this, Trans2Act.class);
            startActivity(intent);
            //该方法紧跟startActivity，不要作延迟处理。
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            
(2)动画：slide_in_left.xml:
    
     <?xml version="1.0" encoding="utf-8"?>
      <set xmlns:android="http://schemas.android.com/apk/res/android"
           android:shareInterpolator="false"
           android:zAdjustment="top">
           <translate
                android:duration="200"
                android:fromXDelta="-100.0%p"
                android:toXDelta="0.0" />
      </set>
slide_out_left.xml:

    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android"
        android:shareInterpolator="false"
        android:zAdjustment="top">
        <translate
            android:duration="200"
            android:fromXDelta="-100.0%p"
            android:toXDelta="0.0" />
    </set>
    
### 2.Activity 跳转动画： overridePendingTransition 的style样式 
style的item标签中使用属性 **android:windowAnimationStyle**,使用windowEnterAnimation和windowExitAnimation,其他尽量不要用
#### style的错误方式：
示例如下：
（1）自定义样式：

     <style name="Left_style" parent="Theme.AppCompat.Light.NoActionBar">
          <item name="android:windowAnimationStyle">@style/leftDemo_anim</item>
      </style>
  
      <style name="leftDemo_anim" >
          <item name="android:windowEnterAnimation">@anim/slide_in_left</item>
          <item name="android:windowExitAnimation">@anim/slide_out_left</item>
      </style>

（2）slide_out_left.xml和slide_in_left.xml都是：
    
    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android"
        android:shareInterpolator="false"
        android:zAdjustment="top">
        <translate
            android:duration="200"
            android:fromXDelta="-100.0%p"
            android:toXDelta="0.0" />
    </set>
    
（3）AndroidManifest.xml中绑定到act中：
    
      <activity
          android:name=".styledemo.DemoLeftAct"
          android:theme="@style/Left_style" />
         
>说明：按照如上步骤执行后，有些手机动画效果无效,而且点击back键后会和系统动画冲突。所以如上代码的完整步骤如下：

#### 完整style样式的act动画步骤:
（1）Left_style中添加    **<item name="windowNoTitle">true</item>**
leftDemo_anim添加**parent="@android:style/Animation.Translucent"**（使用parent="@android:style/Animation.Activity"无效），

    
     <style name="Left_style" parent="Theme.AppCompat.Light.NoActionBar">
           <item name="android:windowIsTranslucent">true</item>
           <item name="android:windowAnimationStyle">@style/leftDemo_anim</item>
       </style>
   
       <style name="leftDemo_anim" parent="@android:style/Animation.Translucent">
           <item name="android:windowEnterAnimation">@anim/slide_in_left</item>
           <item name="android:windowExitAnimation">@anim/slide_out_left</item>
       </style>

(2)AndroidManifest.xml中绑定到act中：
    
      <activity
          android:name=".styledemo.DemoLeftAct"
          android:theme="@style/Left_style" />
          
(3)**重写界面退出方法（back键盘，界面按钮都写），加入overridePendingTransition(0,0)方法，排除手机厂商os系统自带的界面动画**
    
       startActivity(new Intent(DemoLeftAct.this, StyleMainAct.class));
       this.finish();
       overridePendingTransition(0, 0);
            
参考：https://blog.csdn.net/fancylovejava/article/details/39643449

而在 windowAnimationStyle 中存在多种动画，如下是**所有的动画属性**，如有需要，自行测试修改

    <style name="activityStyle" parent="@android:style/Animation.Translucent">
        <item name="android:taskOpenEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:taskOpenExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:taskToFrontEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:taskToFrontExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:activityOpenEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:activityOpenExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:activityCloseEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:activityCloseExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:taskCloseEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:taskCloseExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:taskToBackEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:taskToBackExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:wallpaperOpenEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:wallpaperOpenExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:wallpaperCloseEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:wallpaperCloseExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:wallpaperIntraOpenEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:wallpaperIntraOpenExitAnimation">@anim/activity_open_out_anim</item>
        <item name="android:wallpaperIntraCloseEnterAnimation">@anim/activity_open_in_anim</item>
        <item name="android:wallpaperIntraCloseExitAnimation">@anim/activity_open_out_anim</item>
    </style>
    
    
     <style name="windowStyle" parent="@android:style/Animation.Translucent">
            <item name="android:windowEnterAnimation">@anim/base_slide_right_in</item>
            <item name="android:windowExitAnimation">@anim/base_slide_right_out</item>
     </style>
    
 ## 实现 Activity 的切换动画-方法2--Transitions Framework
 
 **简介**,该类动画主要在android.transition包下，关于该包的API详解，请参考本人总结：
1. [API android.transition 详解跳转（位置：lib_anim_more/lib_transition/README_trans_API.md）](https://github.com/66668/AnimationStudy/blob/master/lib_anim_more/lib_transition/README_trans_API.md);
实现方式有三种：
 
 1. style方式
 2. xml方式
 3. code方式
 
 
 
    
   

