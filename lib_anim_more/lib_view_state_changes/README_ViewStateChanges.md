# View State Changes 视图状态动画
说明：本质还是属性动画，替换传统的selector的方式，主要是作用于点击按钮等的状态的变换。

这块代码不多，可以直接看代码，然后看执行效果，不过在介绍前，先补充必要知识

## View的各种状态介绍

| State | 英文说明 |中文说明|
| :------- | ------ |  ------ | 
| **android:constantSize** | If true, the drawable's reported internal size will remain constant as the state changes; the size is the maximum of all of the states. |是否保持尺寸 |
|**android:state_activated** | State value for StateListDrawable, set when a view or its parent has been "activated" meaning the user has currently marked it as being of interest. |StateListDrawable的状态值，| 
| **android:state_active** | State value for StateListDrawable. |StateListDrawable的状态值 |
| **android:state_checkable** | State identifier indicating that the object may display a check mark. |选中标记 |
| **android:state_checked** | State identifier indicating that the object is currently checked. |当前对象是否已选中 |
| **android:state_enabled** | State value for StateListDrawable, set when a view is enabled. |StateListDrawable的状态值 ,view是否可用 |
| **android:state_first** | State value for StateListDrawable. | StateListDrawable的状态值|
| **android:state_focused** | State value for StateListDrawable, set when a view has input focus. | 输入焦点|
| **android:state_last** | State value for StateListDrawable. | StateListDrawable的状态值|
| **android:state_middle** | State value for StateListDrawable. |StateListDrawable的状态值 |
| **android:state_pressed** | State value for StateListDrawable, set when the user is pressing down in a view. | 用户是否压下view|
| **android:state_selected** | State value for StateListDrawable, set when a view (or one of its parents) is currently selected. |views中的一个是否选中| 
| **android:state_single** | State value for StateListDrawable. |StateListDrawable的状态值  |
| **android:state_window_focused** | State value for StateListDrawable, set when a view's window has input focus. | view的window有输入焦点|
| **android:variablePadding** | If true, allows the drawable's padding to change based on the current state that is selected. | true，可变padding尺寸|
| **android:visible** | Indicates whether the drawable should be initially visible.| 是否可见|

> 小提示(关于在 selector 中设置不同状态的 item 时匹配原则的一个细节):
> 如果有多个item，那么程序将自动从上到下进行匹配，最先匹配的将得到应用。
> 如果一个item没有任何的状态说明，那么它将可以被任何一个状态匹配。

## 使用步骤介绍

### 1 xml方式调用
如下两步骤即可使用xml样式：

1. 在 res/animator下，创建 根标签为`<selector>`的xml文件
2. 在布局中xml中调用该xml，调用属性为： android:stateListAnimator="@animator/xxx"

示例：

（1）res/animator下创建 view_state_change_01.xml：
    
    <?xml version="1.0" encoding="utf-8"?>
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <item android:state_pressed="true">
            <set>
                <objectAnimator
                    android:duration="@android:integer/config_shortAnimTime"
                    android:propertyName="translationZ"
                    android:valueTo="5dp"
                    android:valueType="floatType" />
            </set>
        </item>
    
        <item android:state_pressed="false">
            <set>
                <objectAnimator
                    android:duration="100"
                    android:propertyName="translationZ"
                    android:valueTo="2dp"
                    android:valueType="floatType" />
            </set>
        </item>
    </selector>
    
（2）android:stateListAnimator="@animator/xxx"赋值给view（  **android:clickable="true"不可少**）

    <TextView
                android:id="@+id/tv_01"
                android:layout_width="match_parent"
                android:layout_height="100px"
                android:layout_margin="20dp"
                android:background="@android:color/darker_gray"
                android:clickable="true"
                android:gravity="center"
                android:stateListAnimator="@animator/view_state_change_01"
                android:text="xml方式调用" />

### 2 code方式调用
code调用通过如下两步可以调用

1. 在 res/animator下，创建 根标签为`<selector>`的xml文件
2. code调用

示例：
（1）res/animator下创建 view_state_change_02.xml：（同上）
    
    <?xml version="1.0" encoding="utf-8"?>
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <item android:state_pressed="true">
            <set>
                <objectAnimator
                    android:duration="@android:integer/config_shortAnimTime"
                    android:propertyName="translationZ"
                    android:valueTo="5dp"
                    android:valueType="floatType"/>
                <objectAnimator
                    android:duration="@android:integer/config_shortAnimTime"
                    android:propertyName="rotationX"
                    android:valueTo="-10"
                    android:valueType="floatType"/>
            </set>
        </item>
    
        <item
            android:state_pressed="false">
            <set>
                <objectAnimator
                    android:duration="100"
                    android:propertyName="translationZ"
                    android:valueTo="2dp"
                    android:valueType="floatType"/>
                <objectAnimator
                    android:duration="@android:integer/config_shortAnimTime"
                    android:propertyName="rotationX"
                    android:valueTo="0"
                    android:valueType="floatType"/>
            </set>
        </item>
    </selector>
（2）code调用（ 布局中tv_02属性**android:clickable="true"不可少**）

        /**
         * code方式 引用
         */
        private void initStateListAnimator() {
            //加载动画(属性动画AnimatorInflater加载动画xml)
            StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator(this, R.animator.view_state_change_02);
            //设置动画
            tv_02.setStateListAnimator(stateListAnimator);
        }
 
 ### 3 AnimatedStateListDrawable 动画list使用
 
 当你是 pressed 状态的时候 animation-list 正着走一遍，drawable 使用最后一个。  
 当你是 default 状态时 animation-list 反着走一遍，drawable 使用第一个。
 
 使用步骤：
 1. res/drawable下创建animation-list的xml
 eg:bg_animated_statelist_drawable.xml:
    
    
    <?xml version="1.0" encoding="utf-8"?>
    <animated-selector xmlns:android="http://schemas.android.com/apk/res/android">
    
        <!-- provide a different drawable for each state -->
        <item
            android:id="@+id/pressed"
            android:drawable="@drawable/img29"
            android:state_pressed="true" />
        <!-- <item
            android:id="@+id/focused"
            android:drawable="@drawable/btn_focused"
            android:state_focused="true"/> -->
        <item
            android:id="@id/default1"
            android:drawable="@drawable/img1" />
    
        <!-- specify a transition -->
        <transition
            android:fromId="@+id/default1"
            android:toId="@+id/pressed">
            <animation-list>
                <item
                    android:drawable="@drawable/img2"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img3"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img4"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img5"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img6"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img7"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img8"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img9"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img10"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img13"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img14"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img15"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img17"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img18"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img19"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img20"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img21"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img22"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img23"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img24"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img25"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img26"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img27"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img28"
                    android:duration="100" />
                <item
                    android:drawable="@drawable/img29"
                    android:duration="100" />
            </animation-list>
        </transition>
    </animated-selector>
 2. 布局的某个view调用（  **android:clickable="true"不可少**）：
 
        
            <ImageView
                android:id="@+id/img_01"
                android:layout_width="150dp"
                android:layout_height="150dp"
                android:layout_gravity="center_horizontal"
                android:layout_margin="15dp"
                android:background="@drawable/bg_animated_statelist_drawable"
                android:clickable="true"
                android:translationZ="3dp"/>