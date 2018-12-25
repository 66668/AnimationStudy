# Ripple Effect/触摸反馈动画

简介：android 5.0（API21+）在button上，自动添加了触摸反馈动画，效果水波纹效果，是有边界动画，当水波纹动画完成，View 恢复到初始状态。
该处没有值得详解的地方，很简单，直接上代码讲解


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
 drawable-v21的xml，则为5.0,6.0以上的适配，**推荐所有待ripple的效果都在drawable-v21包下**,
 绑定控件时，一定要添加属性**android:clickable="true"**
 以2.1讲解为例，
 ### 2.1 自定义颜色（无边界）
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

### 2.2 自定义颜色+设置边界
设置边界的做法，就是在标签`<ripple>`下，使用标签`<item>`，item可以设置任何你想要的样式，这里以边框为例：

ripple_shape01.xml：
    
    <?xml version="1.0" encoding="utf-8"?>
    <ripple xmlns:android="http://schemas.android.com/apk/res/android"
        android:color="#4af407">
        <!--添加item以后会约束水波纹的范围-->
        <item android:drawable="@android:color/white"/>
    </ripple>
    
绑定到控件上
    
      <TextView
                android:id="@+id/tv_02"
                android:layout_width="300dp"
                android:layout_height="40dp"
                android:layout_marginTop="10dp"
                android:background="@drawable/ripple_shape01"
                android:clickable="true"
                android:gravity="center"
                android:text="自定义-青色-有边界"
                android:textSize="10sp" />

**如上样式，可以使用图片代替颜色，不过图片需要放到drawable文件夹下**

### 2.3 自定义颜色+设置边界+有边框
方式1：
ripple_shape02.xml：

    <?xml version="1.0" encoding="utf-8"?>
    <ripple xmlns:android="http://schemas.android.com/apk/res/android"
        android:color="#f7e307">
        <!--添加item以后会约束水波纹的范围-->
        <item>
            <shape android:shape="rectangle">
                <corners android:radius="10dp" />
                <solid android:color="#5a949e" />
                <stroke android:color="#999999" />
            </shape>
        </item>
    </ripple>
      
绑定到控件上
    
      <TextView
                android:id="@+id/tv_03"
                android:layout_width="300dp"
                android:layout_height="40dp"
                android:layout_marginTop="10dp"
                android:background="@drawable/ripple_shape02"
                android:clickable="true"
                android:gravity="center"
                android:text="自定义-青色-有边界"
                android:textSize="10sp" />

方式2：
先定义shape03.xml:
    
    <?xml version="1.0" encoding="utf-8"?>
    <shape xmlns:android="http://schemas.android.com/apk/res/android"
        android:shape="rectangle">
        <stroke
            android:width="1dp"
            android:color="@color/colorAccent" />
        <solid android:color="#7b6060" />
    </shape>
    
再定义ripple_shape03.xml：

    <?xml version="1.0" encoding="utf-8"?>
    <ripple xmlns:android="http://schemas.android.com/apk/res/android"
        android:color="#f7e307">
        <item android:drawable="@drawable/shape03" />
    </ripple>
最后控件引用即可  

## 3 Button的Ripple

Button 在 v21 以上默认情况下是自带有 ripple 效果和点击Z轴抬高的阴影效果（会在视图状态动画中详解）的。
但是如果你给 Button 设置了背景图，上面自带的默认点击效果都会失去。这时如果想保持点击效果有下面几种方式:  

### 3.1 设置在sytle中