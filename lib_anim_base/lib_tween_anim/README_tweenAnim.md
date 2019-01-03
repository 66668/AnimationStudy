# Tween Animation (补间动画) 很全的讲解和示例
本例将详解android.view.animation包下的所有内容。
# 一 介绍
Tween Animation对应的五个操作类是AlphaAnimation，RotateAnimation，ScaleAnimation，TranslateAnimation，AnimationSet，
他们都继承了：extends android.view.animation.Animation extends Animation。


| java 类名 |基类| xml 关键字 | 描述信息 |
| :-----: | :------- | :----- |:----- |
| AlphaAnimation |Animation| 标签`<alpha>` 放置在 res/anim/ 目录下 | 渐变透明度 |
| RotateAnimation |Animation| 标签`<rotate>` 放置在 res/anim/ 目录下 | 旋转 | 
| ScaleAnimation |Animation| 标签`<scale>` 放置在 res/anim/ 目录下 | 缩放 | 
| TranslateAnimation |Animation| 标签`<translate>` 放置在 res/anim/ 目录下 | 平移移动 | 
| AnimationSet |Animation| 标签`<set>` 放置在 res/anim/ 目录下 | 包含 alpha、scale、translate、rotate 或者其它 set 元素的容器 | 

## 实现原理

每次绘制视图时，View所在的ViewGroup中的drawChild函数会获取该view的Animation的Transformation值，
然后调用canvas.concat(transformToApply.getMatrix())函数，通过内部的矩阵运算完成动画帧。
如果动画没有完成，就继续调用invalidate()函数，启动下次绘制来驱动动画，从而完成整个动画的绘制。
由此可见，View动画其实是一个矩阵运算的过程。

## 优缺点

**优势**：使用简单，兼容性好

**缺陷**：不具备交互性，View动画作用的实际上是View的影像，而非真正改变了View的属性状态。

也就是说，View动画结束后，即便使用setFillAfter（true）使得view保持在动画结束时的位置，view的真实位置依旧未发生变化，仍然处于最开始定义时的位置。
因此，当view动画结束后，其响应位置仍然位于动画开始前的原始位置，这就使得其不具备交互性；
View动画只能作用于View对象，且提供的动画种类有限；


# 二 Animation及子类 属性详解

## 1基类 Animation 属性详解

| xml 属性 | java 方法 | 解释 |
| :----- | :------- | :----- |
| android:detachWallpaper | setDetachWallpaper(boolean) | 是否在壁纸上运行 | 
| android:duration | setDuration(long) | 动画持续时间，毫秒为单位 | 
| android:fillAfter | setFillAfter(boolean) | 控件动画结束时是否保持动画最后的状态 | 
| android:fillBefore | setFillBefore(boolean) | 控件动画结束时是否还原到开始动画前的状态 | 
| android:fillEnabled | setFillEnabled(boolean) | 与android:fillBefore效果相同 | 
| android:interpolator | setInterpolator(Interpolator) | 设定插值器（指定的动画效果，譬如回弹等） | 
| android:repeatCount | setRepeatCount(int) | 重复次数 | 
| android:repeatMode | setRepeatMode(int) | 重复类型有两个值，reverse表示倒序回放，restart表示从头播放 | 
| android:startOffset | setStartOffset(long) | 调用start函数之后等待开始运行的时间，单位为毫秒 | 
| android:zAdjustment | setZAdjustment(int) | 表示被设置动画的内容运行时在Z轴上的位置（ZORDER_NORMAL/ZORDER_TOP/ZORDER_BOTTOM），默认为normal | 


## 2.AlphaAnimation 透明 属性详解
java方法：AlphaAnimation(float fromAlpha, float toAlpha)

| xml 属性 | java方法 | 解释 |
| :----- | :------- | :----- |
| android:fromAlpha | AlphaAnimation(float fromAlpha, float toAlpha) | 动画开始的透明度（0.0到1.0，0.0是全透明，1.0是不透明） | 
| android:toAlpha | AlphaAnimation(float fromAlpha, float toAlpha)  | 动画结束的透明度，同上 | 

## 3.RotateAnimation 旋转 属性详解

java方法：

    (1)RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
    (2)RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,int pivotYType, float pivotYValue)
    
| xml 属性 | java方法 | 解释 |
| :----- | :------- | :----- |
| android:fromDegrees | RotateAnimation(float fromDegrees, …) | 旋转开始角度，正代表顺时针度数，负代表逆时针度数 | 
| android:toDegrees | RotateAnimation(…, float toDegrees, …) | 旋转结束角度，正代表顺时针度数，负代表逆时针度数 | 
| android:pivotX | RotateAnimation(…, float pivotX, …) | 缩放起点X坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点） | 
| android:pivotY | RotateAnimation(…, float pivotY) | 缩放起点Y坐标，同上规律 | 
|xml没有该属性|RotateAnimation（,int pivotXType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT,x的类型|
|xml没有该属性|RotateAnimation(,int pivotYType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT,y的类型|

说明：
1. Animation.ABSOLUTE，表示控件从xml设置的位置开始变化。比如，控件开始居中，则从居中变化。
2. Animation.RELATIVE_TO_SELF
3. Animation.RELATIVE_TO_PARENT

## 4.ScaleAnimation 缩放 属性详解
java方法：

    （1）ScaleAnimation(float fromX, float toX, float fromY, float toY)
    （2）ScaleAnimation(float fromX, float toX, float fromY, float toY,float pivotX, float pivotY)
    （3）ScaleAnimation(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
    
| xml 属性 | java方法 | 解释 |
| :----- | :------- | :----- |
| android:fromXScale | ScaleAnimation(float fromX, …) | 初始X轴缩放比例，1.0表示无变化 | 
| android:toXScale | ScaleAnimation(…, float toX, …) | 结束X轴缩放比例 | 
| android:fromYScale | ScaleAnimation(…, float fromY, …) | 初始Y轴缩放比例 | 
| android:toYScale | ScaleAnimation(…, float toY, …) | 结束Y轴缩放比例 | 
| android:pivotX | ScaleAnimation(…, float pivotX, …) | 缩放起点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点） | 
| android:pivotY | ScaleAnimation(…, float pivotY) | 缩放起点Y轴坐标，同上规律 | 
|xml没有该属性|ScaleAnimation（,int pivotXType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT,x的类型|
|xml没有该属性|ScaleAnimation(,int pivotYType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT,y的类型|

## 5.TranslateAnimation 平移 属性详解
java方法：

    (1)TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
    (2)TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue,int fromYType, float fromYValue, int toYType, float toYValue)
    
| xml 属性 | java方法 | 解释 |
| :----- | :------- | :----- |
| android:fromXDelta | TranslateAnimation(float fromXDelta, …) | 起始点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点） | 
| android:fromYDelta | TranslateAnimation(…, float fromYDelta, …) | 起始点Y轴从标，同上规律 | 
| android:toXDelta | TranslateAnimation(…, float toXDelta, …) | 结束点X轴坐标，同上规律 | 
| android:toYDelta | TranslateAnimation(…, float toYDelta) | 结束点Y轴坐标，同上规律 | 
|xml没有该属性|TranslateAnimation（int fromXType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT|
|xml没有该属性|TranslateAnimation(,int toXType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT|
|xml没有该属性|TranslateAnimation(,int fromYType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT|
|xml没有该属性|TranslateAnimation(,int toYType,)|Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT|


## 6.AnimationSet详解
AnimationSet继承自Animation,，是上面四种的组合容器管理类，没有自己特有的属性，他的属性继承自Animation.
所以特别注意，当我们对set标签使用Animation的属性时会对该标签下的所有子控件都产生影响。代码请参考：VAcodeAct

**说明：** 
1. xml关于50%的设置，表示以控件中心进行操作，但是，代码中想要这么实现，需要用：obj.getWidth() / 2来表示控件obj的中心。
2. **android:shareInterpolator**表示集合中的动画是否和集合共享同一个插值器，如果集合不指定插值器，那么子动画就需要单独指定所需的插值器或默认值.

# 三 扩展：android.view.animation包下的类及功能划分
该包下，根据功能可以划分三个类
1. 以Animation为基类的操作类，
2. 以BaseInterpolator为基类的各种插值器类
3. 工具类/控制类等

具体如下：

| 操作类 | 基类| 功能用途 |
| :-----: | :------- | :----- |
|Animation|无|View Animation所有的基类|
| AlphaAnimation |Animation | 渐变透明度 |
| AnimationSet |Animation| 包含 alpha、scale、translate、rotate 或者其它 set 元素的容器 | 
| RotateAnimation |Animation|  旋转 | 
| ScaleAnimation |Animation| 缩放 | 
| TranslateAnimation |Animation|  平移移动 | 

| 插值器类 | 基类| 功能用途 |
| :-----: | :------- | :----- |
|Interpolator|无|所有插值器的interface|
|BaseInterpolator|无|所有插值器的基类|
|AccelerateDecelerateInterpolator|BaseInterpolator|见下|
|AccelerateInterpolator|BaseInterpolator|见下|
|AnticipateInterpolator|BaseInterpolator|见下|
|AnticipateOvershootInterpolator|BaseInterpolator|见下|
|AnticipateOvershootInterpolator|BaseInterpolator|见下|
|BounceInterpolator|BaseInterpolator|见下|
|CycleInterpolator|BaseInterpolator|见下|
|DecelerateInterpolator|BaseInterpolator|见下|
|LinearInterpolator|BaseInterpolator|见下|
|OvershootInterpolator|BaseInterpolator|见下|
|PathInterpolator|BaseInterpolator|见下|

 **补充说明：** 如上是android.view.animation包下的插值器，其实，v4包中还扩展了一些插值器，[api跳转](https://developer.android.google.cn/reference/android/support/v4/view/animation/package-summary),如下：

| 插值器类 | 基类| 功能用途 |
| :-----: | :------- | :----- |
|FastOutLinearInInterpolator|implements Interpolator|对应于fast_out_linear_in的插值器。对(0,0)到(1,1)的Bezier曲线使用查找表，控制点为:P0 (0,0) P1 (0.4, 0) P2 (1.0, 1.0) P3 (1.0, 1.0)|
|FastOutSlowInInterpolator|implements Interpolator|对应于fast_out_slow_in的插值器。对(0,0)到(1,1)的Bezier曲线使用查找表，控制点为:P0 (0,0) P1 (0.4, 0) P2 (0.2, 1.0) P3 (1.0, 1.0)|
|LinearOutSlowInInterpolator|implements Interpolator|与linear_out_slow_in对应的插值器。对(0,0)到(1,1)的Bezier曲线使用查找表，控制点为:P0 (0,0) P1 (0,0) P2 (0.2, 1.0) P3 (1.0, 1.0)|
|PathInterpolatorCompat|无|用于创建基于路径的插值器实例的助手。在API 21或更新版本中，将使用平台实现，在较旧的平台上将使用兼容的替代实现。|

| 其他类  | 功能用途 |
| :-----: | :----- |
|AnimationUtils|工具类|
|LayoutAnimationController|基类|
|GridLayoutAnimationController||
|Transformation||


# 四 插值器详解及其自定义
插值器是一种定义在XML中的动画修饰符,它影响动画的变化率。插值器有加速、减速、反复、反弹等等动画效果
插值器在xml中，在标签<set>或其他四个,通过android:interpolator属性被应用到动画中，在代码中，通过setInterpolator(ind resID)赋值。

不熟悉英语的先温习下如下单词的意思：
accelerated(加速)，decelerated(减速),repeated(重复),bounced(弹跳)等。 

下表指定了Android提供的每个插值器和其资源文件引用的对应关系：

 |插值器类| 对应ID资源值 | 功能 |
 | :-----:  | :-----: | :----- |
 |AccelerateDecelerateInterpolator|@android:anim/accelerate_decelerate_interpolator|在动画开始与结束的地方速率改变比较慢，在中间的时候加速|
 |AccelerateInterpolator|@android:anim/accelerate_interpolator|加速|
 |AnticipateInterpolator|@android:anim/anticipate_interpolator|开始的时候向后然后向前甩|
 |AnticipateOvershootInterpolator|@android:anim/anticipate_overshoot_interpolator|开始的时候向后然后向前甩一定值后返回最后的值|
 |BounceInterpolator|@android:anim/bounce_interpolator|动画结束的时候弹起|
 |CycleInterpolator|@android:anim/cycle_interpolator|动画循环播放特定的次数，速率改变沿着正弦曲线|
 |DecelerateInterpolator|@android:anim/decelerate_interpolator|减速|
 |LinearInterpolator|@android:anim/linear_interpolator|以常量速率改变|
 |OvershootInterpolator|@android:anim/overshoot_interpolator|向前甩一定值后再回到原来位置|
 
 下图摘自https://blog.csdn.net/xiaochuanding/article/details/73200149
 
1. AccelerateInterpolator的效果图:
   
 ![AccelerateInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/accelerate.png)
 ![AccelerateInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/accelerate.gif)
 
 <img src="./interpolator_pic/accelerate.png"  width="400px" alt="AccelerateInterpolator曲线图"/> 
 <img src="./interpolator_pic/accelerate.gif" width="400px" alt="AccelerateInterpolator动画"/>  
 
2. AccelerateDecelerateInterpolator的效果图：

 ![AccelerateDecelerateInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/accelerateDecelerate.png)
 ![AccelerateDecelerateInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/accelerateDecelerate.gif)

 <img src="./interpolator_pic/accelerateDecelerate.png" width="400px" alt="AccelerateDecelerateInterpolator曲线图"/>  
 <img src="./interpolator_pic/accelerateDecelerate.gif" width="400px" alt="AccelerateDecelerateInterpolator动画"/>  
 
3. AnticipateInterpolator的效果图：

 ![AnticipateInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/anticipate.png)
 ![AnticipateInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/anticipate.gif)

 <img src="./interpolator_pic/anticipate.png"  width="400px" alt="AnticipateInterpolator曲线图"/>  
 <img src="./interpolator_pic/anticipate.gif"  width="400px" alt="AnticipateInterpolator动画"/>  

4. AnticipateOvershootInterpolator的效果图：

 ![AnticipateOvershootInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/anticipateOvershoot.png)
 ![AnticipateOvershootInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/anticipateOvershoot.gif)

  <img src="./interpolator_pic/anticipateOvershoot.png"  width="400px" alt="AnticipateOvershootInterpolator曲线图"/> 
  
  <img src="./interpolator_pic/anticipateOvershoot.gif" width="400px" alt="AnticipateOvershootInterpolator动画"/> 
  
5. BounceInterpolator的效果图：

 ![BounceInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/bounce.png)
 ![BounceInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/bounce.gif)

 <img src="./interpolator_pic/bounce.png" width="400px" alt="BounceInterpolator曲线图"/> 
 
 <img src="./interpolator_pic/bounce.gif" width="400px" alt="BounceInterpolator动画"/> 

6. CycleInterpolator的效果图：

 ![CycleInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/cycle.png)
 ![CycleInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/cycle.gif)

 <img src="./interpolator_pic/cycle.png" width="400px" alt="CycleInterpolator曲线图"/> 
 <img src="./interpolator_pic/cycle.gif" width="400px" alt="CycleInterpolator动画"/> 
 
7. DecelerateInterpolator的效果图：

 ![DecelerateInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/decelerate.png)
 ![DecelerateInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/decelerate.gif)

 <img src="./interpolator_pic/decelerate.png" width="400px" alt="DecelerateInterpolator曲线图"/> 
 <img src="./interpolator_pic/decelerate.gif" width="400px" alt="DecelerateInterpolator动画"/> 
 
8. LinearInterpolator的效果图：

 ![LinearInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/linear.png)
 ![LinearInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/linear.gif)

 <img src="./interpolator_pic/linear.png" width="400px" alt="LinearInterpolator曲线图"/> 
 <img src="./interpolator_pic/linear.gif" width="400px" alt="LinearInterpolator动画"/> 
 
9. OvershootInterpolator的效果图：
 ![OvershootInterpolator曲线图](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/overshoot.png)
 ![OvershootInterpolator动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/overshoot.gif)

 <img src="./interpolator_pic/overshoot.png" width="400px" alt="OvershootInterpolator曲线图"/> 
 <img src="./interpolator_pic/overshoot.gif" width="400px" alt="OvershootInterpolator动画"/> 
 
 
 其他：
 
| ID资源值  | 功能用途 |
| :-----: | :----- |
|@android:anim/fade_in|工具类|
|@android:anim/fade_out|基类|
|@android:anim/slide_in_left||
|@android:anim/slide_out_right||
 

参考： https://blog.csdn.net/xiaochuanding/article/details/73200149

## 插值器 自定义详解
如上的9个常用的插值器，他们的曲线图是由函数表示的，所以可以更改函数的默认参数，达到更夸张的曲线图效果

 |xml标签|code方法| 修改属性  |属性默认值 |解释|
 | :-----:  | :-----: | :----- |:----- |:----- |
 |`<accelerateInterpolator>`|AccelerateInterpolator(float factor)|android:factor="1.0"|1.0(Float类型)|加速率|
 |无(不推荐自定义)|AccelerateDecelerateInterpolator()|android:factor="1.0"|1.0(Float类型)|加速率|
 |`<anticipateInterpolator>`|AnticipateInterpolator(float tension)|android:factor="2.0"|2.0(Float类型)|施加张力的量|
 |`<anticipateOvershootInterpolator>`|AnticipateOvershootInterpolator(float tension)|android:tension="2.0"|2.0(Float类型)|施加张力的量|
 ||AnticipateOvershootInterpolator(float tension, float extraTension)|android:extraTension="1.5"|1.5(Float类型)|施加的张力的倍数|
 |无|BounceInterpolator()|无|无|无|
 |`<anticipateOvershootInterpolator>`|CycleInterpolator(float cycles)|android:cycles="1"|1 float|循环数 |
 |无(不推荐自定义)| DecelerateInterpolator() |android:factor="1.0" |Float|减速率|
 |无|LinearInterpolator()|无|无|无|
 |`<overshootInterpolator>`|OvershootInterpolator(float tension)|android:tension="2.0"|2.0(Float类型)|施加张力的量|
 |`<pathInterpolator>`|PathInterpolator(Path path)/PathInterpolator(float controlX, float controlY)/PathInterpolator(float controlX1, float controlY1, float controlX2, float controlY2) {
                                                                                                            initCubic(controlX1, controlY1, controlX2, controlY2)|不熟悉|不熟悉|Path对象|
 
 如上是自定义的xml属性和自定义code的java方法，可推荐自定义的（除PathInterpolator）只有6个，可以参考如下示例。

参考：http://blog.51cto.com/androidigging/1427128

# 五 LayoutAnimationController 详解及其自定义
LayoutAnimationController是一个view布局或者extends ViewGroup的动画控制器。
ViewGroup通过LayoutAnimationController计算每个子view的动画开始的时间间隔，让每个子View在不同的时间点分别执行相同的动画。

## LayoutAnimationController详解
LayoutAnimationController的源码并不多，都是围绕几个属性参数而展开的，这里着重讨论xml的属性值（对应的code的方法都在LayoutAnimationController源码中，就不展示了）

 |xml属性|属性值 |解释|
 | :-----:  | :-----: | :----- |
 |android:animation|@anim/自定义|使用自定义animation动画效果|
 |android:animationOrder|normal/reverse/random|展示顺心：item一层层顺序显示/item倒叙显示/item随机显示|
 |android:delay|float|item较上一个item延迟比例|
 |android:interpolator|@anim/自定义，或@android:anim/系统|使用系统或者自定义的interpolator|
 
## 子类GridLayoutAnimationController详解
GridLayoutAnimationController是针对 GridView布局而设置的，最新的RecyclerView可以替代当作GridView使用，不过仍需要了解如何使用。
 
  |xml属性|属性值 |解释|
  | :-----:  | :-----: | :----- |
  |android:columnDelay|float eg:70%|每一行动画开始的延迟|
  |android:columnDelay|float eg:70%|每一列动画开始的延迟|
  |android:direction|left_to_right/right_to_left/top_to_bottom/bottom_to_top:|动画方向,多个效果可以用竖线|
  |android:directionPriority|row/collumn/none|方向优先级|
  |android:animation|@anim/自定义|使用自定义animation动画效果|
  
## 自定义
针对源码分析，如果我们自定义一个LayoutAnimationController，需要控制顺序，就要重写getTransformedIndex()方法
，通过AnimationParameters类中的属性进行index的计算。然后由getDelayForView()方法计算每个view的延迟时间，如此简单。



#六 补间动画的应用场景示例详解：

1. 各种控件的加载动画：AnimationUtils.loadAnimation(context, resID)或setAnimation(),启动动画startAnimation()。以控件平移为例，这里有三个示例，每个示例又分为xml样式和code样式
2. 特殊控件加载动画style,eg：PopupWindow的进场离场动画
3. recycleView的布局显示动画

## 1.无插值器+平移示例

### (1)xml样式
va_translate_u.xml布局：

        <translate
            android:duration="1000"
            android:duration="1000"
            android:fillAfter="true"
            android:fillBefore="false"
            android:fromXDelta="0"
            android:fromYDelta="0"
            android:repeatCount="1"
            android:repeatMode="reverse"
            android:startOffset="200"
            android:toXDelta="0"
            android:toYDelta="-800"
            android:zAdjustment="top" />

代码调用：

    Animation up = AnimationUtils.loadAnimation(this, R.anim.va_translate_u);
    img.startAnimation(up);
    
有监听的代码调用：

        Animation up = AnimationUtils.loadAnimation(this, R.anim.va_translate_u);
        final Animation down = AnimationUtils.loadAnimation(this, R.anim.va_translate_d);
        img.clearAnimation();
        img.startAnimation(up);
        //移动监听
        up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                img.startAnimation(down);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


###（2）代码样式

    TranslateAnimation up = new TranslateAnimation(0, 0, 0, 100);
        up.setDuration(2000);
        up.setFillAfter(true);
        up.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        up.setZAdjustment(Animation.ZORDER_TOP);
        up.setRepeatCount(1);
        up.setRepeatMode(Animation.REVERSE);
        up.setStartOffset(500);
        
代码调用：

        img.startAnimation(up);
或：

    img.clearAnimation();
    img.startAnimation(up);
这么调用是有问题的，如果有多个动画在执行，突然再执行本动画，那么动画会基于刚才没结束的位置继续执行，而不是原点执行，所以需要添加清除代码，完善代码步骤。
   
            //清除之前动画没执行完的影响
            Animation oldAnimation = img.getAnimation();
            if (oldAnimation != null) {
                if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                    oldAnimation.cancel();
                    img.clearAnimation();
                }
            }
            img.startAnimation(up);
    
## 2.有插值器+平移示例        
### （1）xml样式
总结说明：插值器是和上边的代码一起使用的，不过这里单独摘出来演示，看看效果。

**重要细节-android:shareInterpolator属性设置**:
只要有'set'标签，必须添加属性android:shareInterpolator="true/false"(true为默认)，然后再添加interpolator，否则interpolator没有效果。
直接使用'translate'，'alpha'，'scale'，'rotate'这四个标签，可以直接使用interpolator。

关于'set'标签android:shareInterpolator属性对子标签的影响：

如果为true,表示容器使用统一的interpolator，则子标签设置的interpolator无任何效果，'set'标签默认android:shareInterpolator属性为true

如果为false，表示容器使用子标签的interpolator，则子标签设置interpolator只对该子标签有作用,即使'se>'标签上仍有interpolator,不对任何子标签产生效果。

如上不注意，或者初学者，经常会遇到插值器已经添加但是没有显示效果的情况。理解上述几行话，就不用自己再写所有情况去测试了（9+种，测去吧）

xml的写法的3种方式如下：

方式1：ta_interpolator_translate_b.xml:

    <?xml version="1.0" encoding="utf-8"?><!--平移-->
    <set xmlns:android="http://schemas.android.com/apk/res/android"
        android:shareInterpolator="false">
        <translate
            android:interpolator="@android:anim/bounce_interpolator"
            android:duration="1000"
            android:fromXDelta="0"
            android:fromYDelta="0"
            android:toXDelta="600"
            android:toYDelta="0" />
    </set>
方式2： ta_interpolator_translate_b.xml:

    <?xml version="1.0" encoding="utf-8"?><!--平移-->
    <set xmlns:android="http://schemas.android.com/apk/res/android"
        android:interpolator="@android:anim/bounce_interpolator"
        android:shareInterpolator="true">
        <translate
            android:duration="1000"
            android:fromXDelta="0"
            android:fromYDelta="0"
            android:toXDelta="600"
            android:toYDelta="0" />
    </set>
方式3：android studio默认创建res/anim/xml是以'set'标签开始的，所以这种情况需要手动修改,ta_interpolator_translate_b.xml:

    <?xml version="1.0" encoding="utf-8"?><!--平移-->
    <translate xmlns:android="http://schemas.android.com/apk/res/android"
        android:duration="1000"
        android:fromXDelta="0"
        android:fromYDelta="0"
        android:interpolator="@android:anim/bounce_interpolator"
        android:toXDelta="600"
        android:toYDelta="0" />
    
最后代码调用都相同的：

         Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_b);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    

code方式和自定义方式相同，只是传默认 new的对象：

     TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                        Animation.RELATIVE_TO_PARENT, 200, Animation.RELATIVE_TO_PARENT, 0);
                animation.setDuration(1000);
                animation.setFillAfter(true);
                animation.setFillBefore(true);
                //trans.setFillEnabled(false);//同setFillBefore(false)
                animation.setZAdjustment(Animation.ZORDER_TOP);
                animation.setRepeatCount(1);
                animation.setRepeatMode(Animation.REVERSE);
                animation.setStartOffset(10);
                
                //代码方式，AnticipateInterpolator，如果传值就是自定义方式
                animation.setInterpolator(new AnticipateInterpolator());
        
                Animation oldAnimation = img.getAnimation();
                if (oldAnimation != null) {
                    if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                        oldAnimation.cancel();
                        img.clearAnimation();
                    }
                }
                img.startAnimation(animation);  

 ## 3.自定义插值器+平移示例   
 使用xml自定义的方式，比如，自定义AccelerateInterpolator,res/anim/下创建accelerateInterpolator标签
 方式1：xml自定义。
 my_accelerate_interpolator.xml：
 
    <?xml version="1.0" encoding="utf-8"?>
    <accelerateInterpolator xmlns:android="http://schemas.android.com/apk/res/android"
        android:factor="3">
    
    </accelerateInterpolator>
    
 xml中调用：
    my_trans.xml
    
    <?xml version="1.0" encoding="utf-8"?><!--平移-->
    <set xmlns:android="http://schemas.android.com/apk/res/android"
        android:shareInterpolator="false">
        <translate
            android:duration="1000"
            android:fromXDelta="0"
            android:fromYDelta="0"
            android:interpolator="@anim/my_accelerate_interpolator"
            android:toXDelta="600"
            android:toYDelta="0" />
    </set>
 
 代码调用：
    
           Animation up = AnimationUtils.loadAnimation(this, R.anim.my_trans);
           //清除之前动画没执行完的影响
           Animation oldAnimation = img.getAnimation();
           if (oldAnimation != null) {
               if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                   oldAnimation.cancel();
                   img.clearAnimation();
               }
           }
           img.startAnimation(up);

    
 方式2：code自定义
 
             TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                    Animation.RELATIVE_TO_PARENT, 200, Animation.RELATIVE_TO_PARENT, 0);
            animation.setDuration(1000);
            animation.setFillAfter(true);
            animation.setFillBefore(true);
            //trans.setFillEnabled(false);//同setFillBefore(false)
            animation.setZAdjustment(Animation.ZORDER_TOP);
            animation.setRepeatCount(1);
            animation.setRepeatMode(Animation.REVERSE);
            animation.setStartOffset(10);
            
            //自定义AnticipateInterpolator
            animation.setInterpolator(new AnticipateInterpolator(3));
    
            Animation oldAnimation = img.getAnimation();
            if (oldAnimation != null) {
                if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                    oldAnimation.cancel();
                    img.clearAnimation();
                }
            }
            img.startAnimation(animation); 
            
# PopupWindow的进场离场动画    
三个步骤即可实现：设置xml样式-->设置style样式-->最后在使用的时候绑定style样式即可。

## 1.进场动画离场动画的xml布局设置：

补间动画的xml样式添加即可，进场动画：demo_popwindow_enter.xml：

    <?xml version="1.0" encoding="utf-8"?><!--popwindow进场动画-->
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <translate
            android:duration="1000"
            android:fromXDelta="-100%"
            android:fromYDelta="0"
            android:toXDelta="0"
            android:toYDelta="0"/>
        <alpha
            android:duration="1000"
            android:fromAlpha="0"
            android:toAlpha="1"
            />
      </set>
      
离场动画：demo_popwindow_exit.xml：

    <?xml version="1.0" encoding="utf-8"?><!--popwindow离场动画-->
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <translate
            android:duration="2000"
            android:fromXDelta="0"
            android:fromYDelta="0"
            android:toXDelta="0"
            android:toYDelta="500%" />
    
        <alpha
            android:duration="2000"
            android:fromAlpha="1"
            android:toAlpha="0" />
    
        <rotate
            android:duration="2000"
            android:fromDegrees="0"
            android:pivotX="50%"
            android:pivotY="50%"
            android:toDegrees="720" />
    
        <scale
            android:duration="2000"
            android:fromXScale="1.0"
            android:fromYScale="1.0"
            android:pivotX="50%"
            android:pivotY="50%"
            android:repeatCount="1"
            android:repeatMode="reverse"
            android:toXScale="0.2"
            android:toYScale="0.2" />
    
    </set>
    
## 2.style样式自定义
在res/values/style.xml中添加自定义的样式,进场动画属性是android:windowEnterAnimation，离场动画属性是android:windowExitAnimation

    <!--动画-style-->
    <style name="popWindow_01">
        <item name="android:windowEnterAnimation">@anim/demo_popwindow_enter</item>
        <item name="android:windowExitAnimation">@anim/demo_popwindow_exit</item>
    </style>
    
## 3.定义最简单的popupwindow测试：
核心绑定动画的代码是：mImgPopupWindow.setAnimationStyle(R.style.popWindow_01);

    private void myPopwidow1(View anchor) {
        if (mImgPopupWindow == null) {
            //  View view = LayoutInflater.from(this).inflate(R.layout.popuplayout, null);//方式1
            ImageView view = new ImageView(this);//方式2
            view.setImageDrawable(getDrawable(R.mipmap.ic_launcher));

            mImgPopupWindow = new PopupWindow(view, anchor.getMeasuredWidth(), anchor.getMeasuredWidth());
            mImgPopupWindow.setAnimationStyle(R.style.popWindow_01);
        }
        if (mImgPopupWindow.isShowing()) {
            mImgPopupWindow.dismiss();
        } else {
            mImgPopupWindow.showAsDropDown(anchor);
        }
    }

如上，参数anchor是按钮控件对象，mImgPopupWindow就是PopupWindow的对象。

# RecyclerView的LayoutAnimationController使用总结
本例讲的是 recyclerView的item显示动画效果
## 1.纯xml方式调用：

编写LayoutAnimationController的xml代码，demo_layout_anim.xml：
    
    <?xml version="1.0" encoding="utf-8"?>
    <layoutAnimation xmlns:android="http://schemas.android.com/apk/res/android"
        android:animation="@anim/demo_popwindow_enter"
        android:animationOrder="normal"
        android:delay="0.2"
        android:interpolator="@android:anim/bounce_interpolator" />

在ViewGroup的xml中绑定LayoutAnimationController:
    
        <android.support.v7.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layoutAnimation="@anim/demo_layout_anim"
            android:layout_height="wrap_content" />
            
或者在代码中，为ViewGroup对象绑定LayoutAnimationController:

            //code引用
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.demo_layout_anim);
            recyclerView.setLayoutAnimation(controller);
            recyclerView.startLayoutAnimation();
           
剩下的，recyclerView正常绑定数据展示数据即可。

## 2.code方式（自定义LayoutAnimationController）
代码设置：

        //动画由xml定义或code定义都可以。
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.demo_popwindow_enter);
        //绑定动画
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.2f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        controller.setInterpolator(this, R.anim.my_accelerate_interpolator);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.startLayoutAnimation();
        
剩下的，recyclerView正常绑定数据展示数据即可。

# GridView的GridLayoutAnimationController使用总结
## 1.纯xml方式调用：
编写GridLayoutAnimationController的xml代码，controller_grid_layout_anim.xml：

    <?xml version="1.0" encoding="utf-8"?>
    <gridLayoutAnimation xmlns:android="http://schemas.android.com/apk/res/android"
    android:animation="@anim/my_overshoot"
    android:columnDelay="80%"
    android:direction="left_to_right|top_to_bottom"
    android:directionPriority="column"
    android:rowDelay="75%" />
 在ViewGroup的xml中绑定GridLayoutAnimationController:
 
     <GridView
         android:id="@+id/gridView"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:columnWidth="90dp"
         android:gravity="center"
         android:horizontalSpacing="10dp"
         android:layoutAnimation="@anim/controller_grid_layout_anim"
         android:numColumns="auto_fit"
         android:stretchMode="columnWidth"
         android:verticalSpacing="10dp"
         />
或者在代码中，为ViewGroup对象绑定GridLayoutAnimationController:
         
    //code引用自定义GridLayoutAnimationController
        GridLayoutAnimationController controller = (GridLayoutAnimationController) AnimationUtils.loadLayoutAnimation(this, R.anim.controller_grid_layout_anim);
        gridView.setLayoutAnimation(controller);
                   
剩下的，GridView正常绑定数据展示数据即可。

## 2.code方式