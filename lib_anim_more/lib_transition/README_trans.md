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

示例代码位置：lib_anim_more/lib_transition/lib.anim.transition.demo1/
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
    
## 2.Activity 跳转动画： overridePendingTransition 的style样式 
style的item标签中使用属性 **android:windowAnimationStyle**,使用windowEnterAnimation和windowExitAnimation,其他尽量不要用

示例代码位置：lib_anim_more/lib_transition/lib.anim.transition.demo2/
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
 
 **简介**,该类动画主要在**android.transition**包下，关于该包的API详解，请参考本人总结：
1. [API android.transition 详解跳转（位置：lib_anim_more/lib_transition/README_trans_API.md）](https://github.com/66668/AnimationStudy/blob/master/lib_anim_more/lib_transition/README_trans_API.md);

实现方式有三种：
 1. style方式
 2. xml方式
 3. code方式
 
示例代码位置：lib_anim_more/lib_transition/lib.anim.transition.demo3/
 
### (1)在 style 中设置

在 style 中添加 `android:windowContentTransitions` 属性启用窗口内容转换( Material-theme 应用默认为 true )，
指定该 Activity 的 Transition

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- enable window content transitions -->
        <item name="android:windowContentTransitions">true</item>
        
        <!-- specify enter and exit transitions -->
        <!-- options are: explode, slide, fade -->
        <item name="android:windowEnterTransition">@transition/activity_fade</item>
        <item name="android:windowExitTransition">@transition/activity_slide</item>
    </style>

### (2)xml 中创建

过渡效果定义在 xml 中，目录是 res/transition

`res/transition/activity_fade.xml`

    <?xml version="1.0" encoding="utf-8"?>
    <fade xmlns:android="http://schemas.android.com/apk/res/"
        android:duration="1000"/>
        
`res/transition/activity_slide.xml`

    <?xml version="1.0" encoding="utf-8"?>
    <slide xmlns:android="http://schemas.android.com/apk/res/"
        android:duration="1000"/>

**要使用这些 xml 中定义的过渡动画，你需要使用 TransitionInflater 来实例化它们**。

`MainActivity.java`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Slide slide = TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        getWindow().setExitTransition(slide);
    }

`TransitionActivity.java`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Fade fade = TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setEnterTransition(fade);
    }

### (3)在代码中创建

`MainActivity.java`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setExitTransition(slide);
    }

`TransitionActivity.java`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
    }
不管哪种创建方法都会产生一样的效果:


 
  
 ## 实现 Activity 的共享动画 SharedElement
 
 示例代码位置：lib_anim_more/lib_transition/lib.anim.transition.demo4/
 
 **那么这里面一步一步的到底发生了什么:**  
 
 1. Activity A 启动 Activity B
 2. Transition Framework 发现 A 中定义了Exit Transition (slide) 然后就会对它的所有可见的View使用这个过渡动画.
 3. Transition Framework 发现 B 中定义了Enter Transition (fade) 然后机会对它所有可见的Views使用这个过渡动画.
 4. On Back Pressed(按返回键) Transition Framework 会执行把 Enter and Exit 过渡动画反过来执行(但是如果定义了 
 returnTransition 和 reenterTransition，那么就会执行这些定义的动画)
 
 > 译注:
 > * Exit Transition: 可以理解为 activity 进入后台的过渡动画
 > * Enter Transition: 可以理解为创建 activity 并显示时的过渡动画
 > * Return Transition:可以理解为销毁 activity 时的过渡动画
 > * Reenter Transition: 可以理解为 activity 从后台进入前台时的过渡动画
 > * 要使这些过渡动画生效，我们需要调用 `startActivity(intent，bundle)` 方法来启动 Activity。bundle 需要通过 
 `ActivityOptionsCompat.makeSceneTransitionAnimation().toBundle()` 的方式来生成
 
 
 说明：**ActivityOptionsCompat是ActivityOptions的兼容包,如果应用要支持android5.0以下，需要使用v4包的ActivityOptionsCompat实现，5.0以上，使用哪个没区别**。
 
 ### 1 在style中添加act样式,在对应act上添加该theme
 
    <style name="sharedElement_Style_01" parent="@style/Theme.AppCompat.Light.NoActionBar">
            <!---->
            <item name="android:windowContentTransitions">true</item>
            <item name="android:fragmentSharedElementEnterTransition">@transition/demo4_sharelement
            </item>
            <item name="android:windowSharedElementExitTransition">@transition/demo4_sharelement</item>
        </style>
 
 
 demo4_sharelement.xml:
    
    <?xml version="1.0" encoding="utf-8"?>
    <transitionSet xmlns:android="http://schemas.android.com/apk/res/android">
        <explode
            android:duration="500"
            android:interpolator="@android:interpolator/bounce" />
    
    </transitionSet>
 
 act添加theme
 
    <!--共享元素 android.transition-->
           <activity
               android:name=".demo4.SEDemo4Act1"
               android:theme="@style/sharedElement_Style_01" />
   
           <activity
               android:name=".demo4.SEDemo4Act2"
               android:theme="@style/sharedElement_Style_01" />
               
### 2 设置相同的 transition name(相当于一个标记)

为了使共享元素动画生效，你需要给共享元素的两个View设置相同的android:transitionName属性值。不过他们的id和其他属性可以不同。

 
act1.xml的ImageView添加transitionName：

      <ImageView
            android:id="@+id/img"
            style="@style/sharedElement_Style_01.Small"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="100dp"
            android:background="@mipmap/ic_launcher"
            android:transitionName="sjy_01" />

act2.xml的ImageView添加transitionName：
    
      <ImageView
           android:id="@+id/img"
           style="@style/sharedElement_Style_01.BIG"
           android:layout_alignParentBottom="true"
           android:layout_centerHorizontal="true"
           android:layout_marginBottom="100dp"
           android:background="@mipmap/ic_launcher"
           android:transitionName="sjy_01" />
           
 style样式如下：
 
     <!--共享设置1-->
     <style name="sharedElement_Style_01.Small">
         <item name="android:layout_width">50dp</item>
         <item name="android:layout_height">50dp</item>
     </style>
     <!--共享设置2-->
     <style name="sharedElement_Style_01.BIG">
         <item name="android:layout_width">100dp</item>
         <item name="android:layout_height">100dp</item>
     </style>
   
### 3 代码设置

使用 ActivityOptions.makeSceneTransitionAnimation() 方法指定要共享元素的 View 和 android:transitionName 属性的值

eg:act1：
    
     @OnClick(R2.id.btn_trans)
        public void onCLick(View view) {
            Intent intent = new Intent(SEDemo4Act1.this, SEDemo4Act2.class);
    
            View sharedView = img;
            String transitionName = "sjy_01";
    
            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SEDemo4Act1.this, sharedView, transitionName);
            startActivity(intent, transitionActivityOptions.toBundle());
    
            this.finish();
        }

act2：
    
     @OnClick(R2.id.btn_trans)
        public void onCLick(View view) {
            Intent intent = new Intent(SEDemo4Act2.this, SEDemo4Act1.class);
    
            View sharedView = img;
            String transitionName = "sjy_01";
    
            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SEDemo4Act2.this, sharedView, transitionName);
            startActivity(intent, transitionActivityOptions.toBundle());
            this.finish();
        }
        
 如此便现实了共享动画效果。
 
 
## 实现 Fragmentg间 共享动画 

   示例代码位置：lib_anim_more/lib_transition/lib.anim.transition.demo5/
   
  如上步骤1，2相同，第三步修改为：
 ### 3 代码设置
 
            SEFragment02 sharedElementFragment2 = SEFragment02.newInstance(sample);//个人定义即可
    
            Slide slideTransition = new Slide(Gravity.RIGHT);
            slideTransition.setDuration(400);
    
            ChangeBounds changeBoundsTransition = new ChangeBounds();
            changeBoundsTransition.setDuration(500);
    
            sharedElementFragment2.setEnterTransition(slideTransition);
            sharedElementFragment2.setAllowEnterTransitionOverlap(overlap);
            sharedElementFragment2.setAllowReturnTransitionOverlap(overlap);
            sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);
    
            getFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, sharedElementFragment2)
                    .addToBackStack(null)
                    .addSharedElement(img, "img_01")
                    .commit();
  
  
  
  
  **参考**：
  
  1. https://github.com/lgvalle/Material-Animations