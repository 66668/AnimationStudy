# Property Animation 属性动画详解

说明：针对阅读本篇文章，初级中级推荐demo+API结合的方式，先看demo，再看api会有比较好的学习效果。最全 最基础的学习资料。
不要被文章篇幅吓到，内容不多，关键点就在Animator.

简介：
针对视图动画的不足，android3.0之后新添加的属性动画，属性动画的实现原理就是不断对值进行操作，将值不断赋值到对象上，来修改对象的属性来是实现的。
这里用对象而不是View,就是说明属性动画不仅可以改变view，也可以改变非view。
属性动画的优势，那就是不仅视图动画的所有功能都能用属性动画来实现，复杂的更能很简单的实现，而且还扩展了多种动画效果。

除了阅读本篇关于属性动画的文章，还有扩展类也能实现动画，**ViewPropertyAnimator***，**LayoutAnimator 容器布局动画**，

新添加的属性动画，在android.animation包下。所以本例将详解该包所有内容，并用示例详解如何使用。

## android.animation包详解

| interface 类名 |介绍| 
| :-----: | :------- |
|Animator.AnimatorListener|监听动画信息|
|Animator.AnimatorPauseListener|当动画暂停或恢复时，暂停侦听器接收来自动画的通知。|
|LayoutTransition.TransitionListener|此接口用于侦听Transition的开始和结束事件。|
|TimeAnimator.TimeListener|TimeAnimator实例的侦听器，用以接收对每个动画帧的回调，或用以接收动画器启动以来的总时间和自最后一帧以来的增量时间。|
|TimeInterpolator|时间插值器定义动画的变化率。|
|**TypeEvaluator**| 用于ValueAnimator.setEvaluator()的接口，从初始值过渡到结束值 的变化具体数值|
|ValueAnimator.AnimatorUpdateListener|该接口的实现者可以将自己作为更新侦听器添加到ValueAnimator实例中，以便在为该ValueAnimator计算当前帧的值之后接收对每个动画帧的回调。|


class类按照功能分，可以分为：
1. Animator及其子类的操作类，核心的类是ValueAnimator
2. TypeEvaluator为interface而实现的估值类
3. TypeConverter及实现类的类型转换
4. 其他

按照如上划分，见如下列表讲解：

|分类| class 类名 |extends或interface|介绍| 
| :-----: | :------- |:------- |:------- |
|1|**Animator**|无|该类提供如下动画的基类，可以启动、结束动画，并将animatorlistener添加到这些类中|
|1|**AnimatorSet**|extends Animator|动画集合|
|1|AnimatorSet.Builder||Builder对象是一个实用程序类，用于向AnimatorSet添加动画以及各种动画之间的关系。|
|1|**ValueAnimator**|extends Animator|这个类为运行动画提供了一个简单的计时引擎，用于计算动画值并在目标对象上设置它们。|
|1|**ObjectAnimator**|extends ValueAnimator|ValueAnimator子类,提供了对Object上的动画属性的支持。|
|1|TimeAnimator|extends ValueAnimator|ValueAnimator子类,该类为侦听器提供了一个简单的回调机制，该机制与系统中所有其他动画器同步。|
|2|ArgbEvaluator|implements TypeEvaluator|颜色估值器|
|2|FloatArrayEvaluator||float[]值的估值器|
|2|FloatEvaluator||float值的估值器|
|2|IntArrayEvaluator||int[]值的估值器|
|2|IntEvaluator||int值的估值器|
|2|PointFEvaluator||PointF值的估值器|
|2|RectEvaluator||Rect值的估值器|
|3|TypeConverter||当动画中的值类型与属性类型不同时，这是必要的。|
|3|BidirectionalTypeConverter|extends TypeConverter|当动画中的值类型与属性类型不同时，这是必要的。当只有动画的最终值提供给动画时，需要BidirectionalTypeConverter。|
|4|AnimatorInflater|无|该类用于将animator XML文件实例化为animator对象。|
|4|AnimatorListenerAdapter|implements Animator.AnimatorListener|Animator.AnimatorListener的实现类，方便具体类中添加监听时，避免重写所有方法|
|4|Keyframe|无|该类保存动画的time/value的键值对|
|4|LayoutTransition|无|该类在ViewGroup对象中启用布局更改的自动动画。|
|4|**PropertyValuesHolder**|无|该类保存有关属性的信息，以及该属性在动画期间应该具有的值。PropertyValuesHolder对象可用于使用ValueAnimator或ObjectAnimator创建动画，这些动画可以并行地操作几个不同的属性。|
|4|StateListAnimator|无|根据视图的可绘制状态,定义在可以运行在附加视图上的多个Animators|

# 一 Animator详解
android.animation包最重要的类就是Animator,,关于Animator源码解读就不详解了，需要自己看，一定要自己看一遍。

## xml方式 详解

具体实现类是 AnimatorSet、ObjectAnimator、TimeAnimator、ValueAnimator，如果使用xml方式，需要创建**res/animator文件夹**，现在就来具体讲xml里实现的内容

那么Animator子类与xml的对应关系:

### 1. res/animator xml标签
| java 类名 | xml 关键字/标签 | 
| :-------: | :------- |
| ValueAnimator | `<animator>`| 
| TimeAnimator | `<animator>`  | 
| ObjectAnimator | `<objectAnimator>` | 
| AnimatorSet | `<set>` | 

属性动画的标签及标签内属性，标签内的属性可以使用补间动画的一些xml属性，这一块需要测试。

如下将讲解各标签独有的属性。

### 1.1 `<set>`标签
说明：补间动画的xml属性也可以直接用到该处，不冲突。

| 属性 | 属性值 |解释| 
| :-------: | :------- | :------- |
|android:ordering|sequentially（顺讯执行）,together（一起执行）|set下所有动画执行顺序|

xml示例：

     <set
      android:ordering=["together" | "sequentially"]>
    
        <objectAnimator
            android:propertyName="string"
            android:duration="int"
            android:valueFrom="float | int | color"
            android:valueTo="float | int | color"
            android:startOffset="int"
            android:repeatCount="int"
            android:repeatMode=["repeat" | "reverse"]
            android:valueType=["intType" | "floatType"]/>
    
        <animator
            android:duration="int"
            android:valueFrom="float | int | color"
            android:valueTo="float | int | color"
            android:startOffset="int"
            android:repeatCount="int"
            android:repeatMode=["repeat" | "reverse"]
            android:valueType=["intType" | "floatType"]/>
    
        <set>
            ...
        </set>
    </set>

### 1.2`<animator>`标签

| 属性 | 属性值 |解释| 
| :-------: | :------- | :------- |
|android:interpolator|@android:anim/系统9个，@anim/自定义interpolator|插值器|
|android:duration|int|动画时长，ms单位|
|android:repeatCount|int|重复次数|
|android:repeatMode|reverse,restart|重复样式|
| android:startOffset|int多少ms后开始执行|
| **android:valueFrom**|float、int 或者 color 类型或6位十六进制颜色|必须要设置的节点属性，表明动画结束的点，如果没有指定，系统会通过属性的 get  方法获取|
|**android:valueTo**|float、int 或者 color 类型或6位十六进制颜色|同上|
| android:valueType|intType,floatType（默认）,colorType,pathType|关键参数，如果该 value 是一个颜色，那么就不需要指定，因为动画框架会自动的处理颜色值。|
|**android:propertyName**|String|必须要设置的节点属性|

xml示例：

          <animator
                android:duration="int"
                android:valueFrom="float | int | color"
                android:valueTo="float | int | color"
                android:startOffset="int"
                android:repeatCount="int"
                android:repeatMode=["repeat" | "reverse"]
                android:valueType=["intType" | "floatType"]/>

### 1.3 `<objectAnimator>`标签

| 属性 | 属性值 |解释| 
| :-------: | :------- | :------- |
|android:interpolator|@android:anim/系统9个，@anim/自定义interpolator|插值器|
|android:duration|int|动画时长，ms单位|
|android:repeatCount|int|重复次数|
|android:repeatMode|reverse,restart|重复样式|
| android:startOffset|int多少ms后开始执行|
|**android:valueFrom**|float、int 或者 color 类型或6位十六进制颜色|必须要设置的节点属性，表明动画结束的点，如果没有指定，系统会通过属性的 get  方法获取|
|**android:valueTo**|float、int 或者 color 类型或6位十六进制颜色|同上|
|android:valueType|intType,floatType（默认）,colorType,pathType|关键参数，如果该 value 是一个颜色，那么就不需要指定，因为动画框架会自动的处理颜色值。|
|**android:propertyName**|String|必须要设置的节点属性，指定动画操作的属性|
|android:pathData|||
|android:propertyXName=""||指定动画操作的属性|

xml示例：

     <objectAnimator
            android:propertyName="string"
            android:duration="int"
            android:valueFrom="float | int | color"
            android:valueTo="float | int | color"
            android:startOffset="int"
            android:repeatCount="int"
            android:repeatMode=["repeat" | "reverse"]
            android:valueType=["intType" | "floatType"]/>

###  xml方式使用示例


## code方式之 API详解
api用于查缺补漏，直接看api学习动画，不如用demo学习+API结合学的快。

将详解 Animator ValueAnimator ObjectAnimator AnimatorSet


### 2.1 Animator API
public abstract class Animator extends Object implements Cloneable
子类：AnimatorSet, ValueAnimator

|  方法名 |返回值|解释| 
| :-----: | :------- |:------- |
|addUpdateListener(ValueAnimator.AnimatorUpdateListener listener)|void|将侦听器添加到在动画生命周期中发送更新事件的侦听器集。|
|addPauseListener(Animator.AnimatorPauseListener listener)|void|监听act的Pause状态|
|cancel()|void||
|clone()|ValueAnimator||
|end()|void||
|getDuration()()| long||
|getInterpolator()| long||
|getListeners()|ArrayList`<Animator.AnimatorListener>`||
||getStartDelay()| long||
|getTotalDuration()| long||
|isPaused()| boolean||
|isRunning()| boolean||
|isStarted()| boolean||
|pause()| void|暂停|
|removeAllListeners()| void||
|removeListener(Animator.AnimatorListener listener)| void||
|removePauseListener(Animator.AnimatorPauseListener listener)| void||
|removePauseListener(Animator.AnimatorPauseListener listener)| void||
|resume()| void||
|setDuration(long duration)| Animator||
|setInterpolator(TimeInterpolator value)| void||
|setStartDelay(long startDelay)| void||
|setTarget(Object target)| void||
|setupEndValues()| void|告诉对象使用适当的信息来提取动画的结束值|
|setupStartValues()| void|告诉对象使用适当的信息来提取动画的起始值|
|start()| void||

### 2.2 AnimatorSet API
官方简介：
这个类按照指定的顺序播放一组Animator对象。动画可以设置为一起播放，顺序播放，或在指定的延迟后播放。

向AnimatorSet添加动画有两种不同的方法:可以调用playTogether()或playsequ()方法一次性添加一组动画，也可以调用play(Animator)方法与Builder类中的方法一起逐个添加动画。

可以在动画之间建立一个具有循环依赖关系的AnimatorSet。例如，可以在动画a2之前设置动画a1，在动画a2之前设置a2，在动画a3之前设置a3，在动画a1之前设置a3。此配置的结果是未定义的，但通常不会导致播放任何受影响的动画。

由于这一点(而且因为循环依赖无论如何都没有逻辑意义)，应该避免循环依赖，动画的依赖流应该只在一个方向上。

|  方法名 |返回值|解释| 
| :-----: | :------- |:------- |
|cancel()|void||
|clone()|AnimatorSet||
|end()|void||
|getChildAnimations()|ArrayList<Animator>||
|getCurrentPlayTime()|long||
|getDuration()|long||
|**getInterpolator()**|**TimeInterpolator**||
|getStartDelay()|long||
|getTotalDuration()|long||
|isRunning()|boolean||
|isStarted()|boolean||
|pause()|void||
|play(Animator anim)|AnimatorSet.Builder|该方法创建一个Builder对象，该对象用于设置播放约束。|
|playSequentially(List<Animator> items)|void|前一个动画结束时播放的每个动画。|
|playSequentially(Animator... items)|void|前一个动画结束时播放提供的每个动画。|
|playTogether(Collection<Animator> items)|void|同时播放动画|
|playTogether(Animator... items)|void|同时播放动画|
|resume()|void|恢复一个暂停的动画，从暂停时停止的地方重新开始。|
|reverse()|void||
|setCurrentPlayTime(long playTime)|void||
|setDuration(long duration)|AnimatorSet||
|**setInterpolator(TimeInterpolator interpolator)**|void||
|setStartDelay(long startDelay)|void||
|**setTarget(Object target)**|void|动画都将作用在所设置的target控件上|
|setupEndValues()| void|告诉对象使用适当的信息来提取动画的结束值|
|setupStartValues()| void|告诉对象使用适当的信息来提取动画的起始值|
|start()| void||
|toString()| String||


### 2.3 ValueAnimator API

ValueAnimator子类：ObjectAnimator, TimeAnimator

官方简介：

**这个类为运行动画提供了一个简单的计时引擎，用于计算动画值并在目标对象上设置它们。**

所有动画都使用一个计时脉冲。它在自定义处理程序中运行，以确保属性更改发生在UI线程上。

默认情况下，ValueAnimator使用非线性时间插值，通过accelerate减速插值类，加速进入动画和减速离开动画。可以通过调用set插值器(时间插值器)来更改此行为。
使用示例：

    <animator xmlns:android="http://schemas.android.com/apk/res/android"
        android:duration="1000"
        android:valueFrom="1"
        android:valueTo="0"
        android:valueType="floatType"
        android:repeatCount="1"
        android:repeatMode="reverse"/>
从API 23开始，还可以使用PropertyValuesHolder和Keyframe资源标记的组合来创建多步骤动画。注意，您可以为每个关键帧指定显式的小数值(从0到1)，

以确定动画在整个持续时间内何时应该到达该值。或者，您可以不考虑分数，关键帧将在整个持续时间内平均分布:

    <animator xmlns:android="http://schemas.android.com/apk/res/android"
              android:duration="1000"
              android:repeatCount="1"
              android:repeatMode="reverse">
        <propertyValuesHolder>
            <keyframe android:fraction="0" android:value="1"/>
            <keyframe android:fraction=".2" android:value=".4"/>
            <keyframe android:fraction="1" android:value="0"/>
        </propertyValuesHolder>
    </animator>
    

|  方法名 |返回值|解释| 
| :-----: | :------- |:------- |
|addUpdateListener(ValueAnimator.AnimatorUpdateListener listener)|void|将侦听器添加到在动画生命周期中发送更新事件的侦听器集。|
|cancel()|void||
|end()|void||
|**getAnimatedFraction()**|float|返回当前进度（当前值/差值的比例，0～1的float类型），即动画上最新帧更新中使用的经过/插值的部分。|
|**getAnimatedValue()**|Object|ValueAnimator动画最新值,obj类型由ValueAnimator设置|
|getAnimatedValue(String propertyName)|Object|ValueAnimator为propertyName计算的最新值|
|getAnimatedValue(String propertyName)|Object|ValueAnimator为propertyName计算的最新值|
|getCurrentPlayTime()|Object|获取动画在时间中的当前位置，该位置等于当前时间减去动画开始的时间。|
|getDuration()()| long||
|getFrameDelay()| long||
|getInterpolator()| long||
|getRepeatCount()| int||
|getRepeatMode()| int||
|getStartDelay()| long||
|getTotalDuration()| long||
|getValues()| PropertyValuesHolder[]||
|**ofArgb(int... values)**| ValueAnimator|构造并返回在颜色值,创建的ValueAnimator对象|
|**ofFloat(float... values)**| ValueAnimator||
|**ofInt(int... values)**| ValueAnimator||
|**ofObject(TypeEvaluator evaluator, Object... values)**| ValueAnimator||
|**ofPropertyValuesHolder(PropertyValuesHolder... values)**| ValueAnimator||
|pause()| void||
|removeAllUpdateListeners()| void||
|removeUpdateListener(ValueAnimator.AnimatorUpdateListener listener)| void||
|resume()| void||
|reverse()| void||
|**setCurrentFraction(float fraction)**| void||
|**setCurrentPlayTime(long playTime)**| void||
|**setDuration(long duration)**| ValueAnimator||
|**setEvaluator(TypeEvaluator value)**| void|绑定估值器|
|**setFloatValues(float... values)**| void||
|**setFrameDelay(long frameDelay)**| void|动画每帧之间的时间量，以毫秒为单位。|
|**setIntValues(int... values)**| void||
|**setInterpolator(TimeInterpolator value)**| void||
|**setObjectValues(Object... values)**| void||
|setRepeatCount(int value)| void||
|setRepeatMode(int value)| void||
|setStartDelay(long startDelay)| void||
|setValues(PropertyValuesHolder... values)| void||
|start()| void||

**ValueAnimator深度解读：**

ValueAnimator 只是动画计算管理驱动，设置了作用目标，但没有设置属性，需要通过 updateListener 里设置属性才会生效

### 2.4 ObjectAnimator API
官方简介：
ValueAnimator的这个子类提供了对目标对象上的动画属性的支持。该类的构造函数使用参数来定义将被动画化的目标对象以及将被动画化的属性的名称。

然后在内部确定适当的set/get函数，动画将根据需要调用这些函数来动画属性。

可以从代码或资源文件创建动画器，如下所示:
    
    <objectAnimator xmlns:android="http://schemas.android.com/apk/res/android"
        android:duration="1000"
        android:valueTo="200"
        android:valueType="floatType"
        android:propertyName="y"
        android:repeatCount="1"
        android:repeatMode="reverse"/>
从API 23开始，可以在资源文件中使用PropertyValuesHolder和Keyframe创建更复杂的动画。使用propertyvaluesholder允许动画师并行动画多个属性，如下例所示:

    <objectAnimator xmlns:android="http://schemas.android.com/apk/res/android"
                    android:duration="1000"
                    android:repeatCount="1"
                    android:repeatMode="reverse">
        <propertyValuesHolder android:propertyName="x" android:valueTo="400"/>
        <propertyValuesHolder android:propertyName="y" android:valueTo="200"/>
    </objectAnimator>
 
使用关键帧可以让动画从开始到结束遵循更复杂的路径。注意，您可以为每个关键帧指定显式的小数值(从0到1)，以确定动画在整个持续时间内何时应该到达该值。

或者，您可以不考虑分数，关键帧将在整个持续时间内均匀分布。而且，当动画器启动时，没有值的关键帧将从目标对象派生其值，就像动画器只指定一个值一样。

此外，还可以指定一个可选的插值器。插补器将应用于插补器所设置的关键帧与上一个关键帧之间的间隔。当没有提供插值器时，将使用默认的accelerate减速插值器。

    <propertyValuesHolder android:propertyName="x" >
        <keyframe android:fraction="0" android:value="800" />
        <keyframe android:fraction=".2"
                  android:interpolator="@android:anim/accelerate_interpolator"
                  android:value="1000" />
        <keyframe android:fraction="1"
                  android:interpolator="@android:anim/accelerate_interpolator"
                  android:value="400" />
    </propertyValuesHolder>
    <propertyValuesHolder android:propertyName="y" >
        <keyframe/>
        <keyframe android:fraction=".2"
                  android:interpolator="@android:anim/accelerate_interpolator"
                  android:value="300"/>
        <keyframe android:interpolator="@android:anim/accelerate_interpolator"
                  android:value="1000" />
    </propertyValuesHolder>


|  方法名 |返回值|解释| 
| :-----: | :------- |:------- |
|clone()|ObjectAnimator||
|**getPropertyName()**|String||
|getTarget()|Obj||
|ofArgb(Object target, String propertyName, int... values)|ObjectAnimator|颜色动画|
|ofArgb(T target, Property`<T, Integer>` property, int... values)| `<T>` ObjectAnimator|颜色动画|
|ofFloat(Object target, String xPropertyName, String yPropertyName, Path path)|ObjectAnimator|float动画，Path设置路径|
|ofFloat(T target, Property`<T, Float>` property, float... values)| `<T>` ObjectAnimator|float动画|
|ofFloat(T target, Property`<T, Float>` xProperty, Property`<T, Float>` yProperty, Path path)| `<T>` ObjectAnimator|float动画|
|**ofFloat(Object target, String propertyName, float... values)**|  ObjectAnimator|最简单最常用float动画|
|ofInt(T target, Property`<T, Integer>` xProperty, Property`<T, Integer>` yProperty, Path path)|`<T>` ObjectAnimator|int动画，Path设置路径|
|ofInt(T target, Property`<T, Integer>` property, int... values)|`<T>` ObjectAnimator|int动画|
|**ofInt(Object target, String propertyName, int... values)**| ObjectAnimator|最简单最常用int动画|
|ofInt(Object target, String xPropertyName, String yPropertyName, Path path)| ObjectAnimator|int动画|
|ofMultiFloat(Object target, String propertyName, float[][] values)| ObjectAnimator|复杂参数设置动画|
|ofMultiFloat(Object target, String propertyName, Path path)| ObjectAnimator|复杂参数设置动画|
|ofMultiFloat(Object target, String propertyName, TypeConverter<T, float[]> converter, TypeEvaluator<T> evaluator, T... values)| `<T>`ObjectAnimator|复杂参数设置动画|
|ofMultiInt(Object target, String propertyName, int[][] values)|ObjectAnimator|复杂参数设置动画|
|ofMultiInt(Object target, String propertyName, Path path)|ObjectAnimator|复杂参数设置动画|
|ofMultiInt(Object target, String propertyName, TypeConverter`<T, int[]>` converter, TypeEvaluator`<T>` evaluator, T... values)|`<T>`ObjectAnimator|复杂参数设置动画|
|ofObject(T target, Property`<T, V>` property, TypeEvaluator`<V>` evaluator, V... values)|`<T, V>`ObjectAnimator|obj动画|
|ofObject(T target, Property`<T, V>` property, TypeConverter`<PointF, V>` converter, Path path)|`<T, V>`ObjectAnimator|obj动画，Path设置|
|ofObject(T target, Property`<T, P>` property, TypeConverter`<V, P>` converter, TypeEvaluator<V> evaluator, V... values)|`<T, V, P>`ObjectAnimator|obj动画，Path设置|
|ofObject(Object target, String propertyName, TypeConverter`<PointF, ?>` converter, Path path)|ObjectAnimator|obj动画|
|**ofObject(Object target, String propertyName, TypeEvaluator evaluator, Object... values)**|ObjectAnimator|obj动画|
|**ofPropertyValuesHolder(Object target, PropertyValuesHolder... values)**|ObjectAnimator|obj动画,values是单一动画的对象，多个values组成了动画组合|
|setAutoCancel(boolean cancel)|void||
|setDuration(long duration)|ObjectAnimator||
|setFloatValues(float... values)|void||
|setIntValues(int... values)|void||
|setObjectValues(Object... values)|void||
|setProperty(Property property)|void||
|setPropertyName(String propertyName)|void||
|setTarget(Object target)|void||
|setupEndValues()| void|告诉对象使用适当的信息来提取动画的结束值|
|setupStartValues()| void|告诉对象使用适当的信息来提取动画的起始值|
|start()| void||
|toString()| String||




# 二 TypeEvaluator及实现类的详解
该类使用最简单，官网介绍最核心的一句话就是与ValueAnimator的 setEvaluator(TypeEvaluator)方法一起使用。

如下这些实现类都是，重写了evaluate方法，实现各自数值。

|  方法名 |返回值|解释| 
| :-----: | :------- |:------- |
|ArgbEvaluator|implements TypeEvaluator|该函数返回给定颜色的整数的中间值，这些整数以32位整数的4个字节表示开始值和结束值。|
|FloatArrayEvaluator||float[]值的估值器，该求值器可用于在float[]值之间执行类型插值。数组中的每个索引都作为单独的值进行插值。例如，计算start float{100, 200}和end float{300, 400},将插值第一个索引值在100到300之间，第二个索引值在200到400之间。|
|FloatEvaluator||float值的估值器,取float中间值|
|IntArrayEvaluator||int[]值的估值器|
|IntEvaluator||int值的估值器，取int中间值|
|PointFEvaluator||PointF值的估值器,该函数返回线性插值起始值和结束值的结果，其中<code>fraction</code>表示起始值和结束值之间的比例。该计算是对PointF对象(x, y)中每个单独组件的简单参数计算。|
|RectEvaluator||Rect值的估值器,该函数返回线性插值起始值和结束值的结果，其中<code>fraction</code>表示起始值和结束值之间的比例。计算是对Rect对象(left, top, right, and bottom)中每个单独组件的简单参数计算。|

# 四 其他详解

## API详解

### 1.1 PropertyValuesHolder API 
官方解释：

该类保存有关属性的信息，以及该属性在动画期间应该具有的值。PropertyValuesHolder对象可用于使用ValueAnimator或ObjectAnimator创建动画，

**这些动画可以并行地操作几个不同的属性。**

|  方法名 |返回值|解释| 
| :-----: | :------- |:------- |
|clone()|PropertyValuesHolder||
|getPropertyName()|getPropertyName()||
|ofFloat(Property<?, Float> property, float... values)|PropertyValuesHolder||
|**ofFloat(String propertyName, float... values)**|PropertyValuesHolder||
|ofInt(String propertyName, int... values)|PropertyValuesHolder||
|ofInt(Property<?, Integer> property, int... values)|PropertyValuesHolder||
|ofKeyframe(String propertyName, Keyframe... values)|PropertyValuesHolder||
|ofKeyframe(Property property, Keyframe... values)|PropertyValuesHolder||
|ofMultiFloat(String propertyName, float[][] values)|PropertyValuesHolder||
|ofMultiFloat(String propertyName, TypeConverter<V, float[]> converter, TypeEvaluator<V> evaluator, V... values)|PropertyValuesHolder||
|ofMultiFloat(String propertyName, Path path)|PropertyValuesHolder||
|ofMultiFloat(String propertyName, TypeConverter<T, float[]> converter, TypeEvaluator<T> evaluator, Keyframe... values)|PropertyValuesHolder||
|ofMultiInt(String propertyName, Path path)|PropertyValuesHolder||
|ofMultiInt(String propertyName, TypeConverter<T, int[]> converter, TypeEvaluator<T> evaluator, Keyframe... values)|PropertyValuesHolder||
|ofMultiInt(String propertyName, TypeConverter<V, int[]> converter, TypeEvaluator<V> evaluator, V... values)|PropertyValuesHolder||
|ofMultiInt(String propertyName, int[][] values)|PropertyValuesHolder||
|ofObject(String propertyName, TypeConverter<PointF, ?> converter, Path path)|PropertyValuesHolder||
|ofObject(String propertyName, TypeEvaluator evaluator, Object... values)|PropertyValuesHolder||
|ofObject(Property<?, V> property, TypeConverter<T, V> converter, TypeEvaluator<T> evaluator, T... values)|PropertyValuesHolder||
|ofObject(Property property, TypeEvaluator<V> evaluator, V... values)|PropertyValuesHolder||
|ofObject(Property<?, V> property, TypeConverter<PointF, V> converter, Path path)|PropertyValuesHolder||
|setConverter(TypeConverter converter)|void||
|setEvaluator(TypeEvaluator evaluator)|void||
|setFloatValues(float... values)|void||
|setIntValues(int... values)|void||
|setKeyframes(Keyframe... values)|void||
|setObjectValues(Object... values)|void||
|setProperty(Property property)|void||
|setPropertyName(String propertyName)|void||
|toString()|String||

### 1.2 PropertyValuesHolder示例
并行执行平移 旋转 缩放 透明这四个动画：
    
     PropertyValuesHolder holdertranslationX = PropertyValuesHolder.ofFloat("translationX", 0, 250f, 0f);
            PropertyValuesHolder holdertranslationY = PropertyValuesHolder.ofFloat("translationY", 0, -250f, 0f);
            PropertyValuesHolder holderRotation = PropertyValuesHolder.ofFloat("rotation", 0, 360f);
            PropertyValuesHolder holderscaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 3f, 1f);
            PropertyValuesHolder holderscaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 2f, 1f);
            PropertyValuesHolder holderAlpha = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 0.2f, 0.8f, 0f, 1f);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holdertranslationX,
                    holdertranslationY,
                    holderRotation,
                    holderscaleX,
                    holderscaleY,
                    holderAlpha
            );
            animator.setDuration(1500);
            animator.start();


# 实际开发中遇到的问题总结

**容易混淆的视图重绘方法：requestLayout()和 invalidate()** ：

1. requestLayout() 当时视图确定自身不再适合现有区域时，调用该方法，要求父视图重新调用 onMeasure()和 onLayout()，重新设置当前视图的位置。
特别的，当视图的布局参数 LayoutParams发生改变时，而且改变的值还没有应用于视图之上，这时比较合适调用该方法重新加载布局参数。
2. invalidate() 会让视图本身重绘，不会影响当前视图与俯视图或其他视图的位置关系。

# 示例
操作值的方式 分为XML方式和code方式，但实际开发中，建议使用Java代码实现属性动画：因为很多时候属性的起始值是无法提前确定的（无法使用XML设置），这就需要在Java代码里动态获取。

## 1 ValueAnimator简单示例

步骤1：在res/animator下创建xml文件




