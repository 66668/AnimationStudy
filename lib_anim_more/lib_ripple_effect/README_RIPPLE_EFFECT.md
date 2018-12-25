# Ripple Effect/触摸反馈动画

简介：android 5.0（API21+）在button上，自动添加了触摸反馈动画，效果水波纹效果，是有边界动画，当水波纹动画完成，View 恢复到初始状态。
该处没有值得详解的地方，直接上代码讲解


## 1.使用系统样式

### 1.1 code方式实现
说明：使用测试发现，使用该方式后，xml设置的自定义background会消失，即无法添加自定义的background样式

         /**
         * （1）有边界
         */
        private void setSystemBoard(View view) {
            int[] attrs = new int[]{R.attr.selectableItemBackground};
            TypedArray typedArray = obtainStyledAttributes(attrs);
            int backgroundResource = typedArray.getResourceId(0, 0);
            view.setBackgroundResource(backgroundResource);
        }
        
    
        /**
         * （2）无边界
         */
        private void setSystemBoardless(View view) {
            int[] attrs = new int[]{R.attr.selectableItemBackgroundBorderless};
            TypedArray typedArray = obtainStyledAttributes(attrs);
            int backgroundResource = typedArray.getResourceId(0, 0);
            view.setBackgroundResource(backgroundResource);
        }
    
### 1.2 xml布局方式：

说明：可以使用 **android:background=""** 或 **android:foreground=""** （如果背景background被占用， 设置到foreground属性中）
属性值为：**?android:attr/selectableItemBackground** 或 **?android:attr/selectableItemBackgroundBorderless**，
**但是必不可少的是添加android:clickable="true"属性，否则不显示效果**
当将系统Ripple Effect样式添加在foreground中，background使用自定义样式时，效果很好。

代码演示如下，具体请参考demo

        <TextView
            android:layout_width="300dp"
            android:layout_height="40dp"
            android:layout_marginTop="10dp"
            android:clickable="true"
            android:foreground="?android:attr/selectableItemBackground"
            android:gravity="center"
            android:text="foreground:有边界TextView"
            android:textSize="10sp" />

        <TextView
            android:layout_width="300dp"
            android:layout_height="40dp"
            android:layout_marginTop="10dp"
            android:clickable="true"
            android:background="?android:attr/selectableItemBackground"
            android:gravity="center"
            android:text="background:有边界TextView"
            android:textSize="10sp" />
    
        <TextView
                android:layout_width="300dp"
                android:layout_height="40dp"
                android:layout_marginTop="10dp"
                android:clickable="true"
                android:foreground="?android:attr/selectableItemBackgroundBorderless"
                android:gravity="center"
                android:text="foreground:无边界TextView"
                android:textSize="10sp" />
    
        <TextView
                android:layout_width="300dp"
                android:layout_height="40dp"
                android:layout_marginTop="10dp"
                android:clickable="true"
                android:background="?android:attr/selectableItemBackgroundBorderless"
                android:gravity="center"
                android:text="background:无边界TextView"
                android:textSize="10sp" />

 ## 2.使用自定义样式-<ripple>标签详解
 
 如果使用自定义样式，则依赖标签`<ripple>`，该标签内，有两个属性：**android:color=""和android:radius=""**，radius属性可以不加。
 
 为了适配android5.0以下的效果，需要在res/drawable和drawable-v21两个包下，创建相同的xml,在drawable下的xml，为5.0以下的适配，
 drawable-v21的xml，则为5.0,6.0以上的适配，**推荐所有待ripple的效果都在drawable-v21包下**,以2.1讲解为例，
 ### 2.1 自定义颜色
1.在drawable-v21创建 ripple_color01.xml:
    
    <?xml version="1.0" encoding="utf-8"?>
    <!--5.0以上的代码，可以使用该代码，显示水波纹效果-->
    <ripple xmlns:android="http://schemas.android.com/apk/res/android"
        android:color="#0520ec"
        android:radius="300dp">
    </ripple>
 
2.绑定到控件上：
    
        <TextView
            android:id="@+id/tv_01"
            android:layout_width="300dp"
            android:layout_height="40dp"
            android:layout_marginTop="10dp"
            android:background="@drawable/ripple_color01"
            android:clickable="true"
            android:gravity="center"
            android:text="自定义无边界"
            android:textSize="10sp" />   

 
3.补充：适配5.0以下的样式，需要在drawable包下定义相同xml,ripple_color01.xml：

    <?xml version="1.0" encoding="utf-8"?>
    <!--5.0以下的老版本，没有ripple效果，用该代码代替-->
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@android:color/holo_green_dark" android:state_pressed="false"/>
    <item android:drawable="@android:color/holo_orange_light" android:state_pressed="true"/>
    <item android:drawable="@android:color/black"/>
    </selector>
  
这用，又可以在5.0以上实现水波纹效果，又可以在5.0以下实现点击变色的效果。

