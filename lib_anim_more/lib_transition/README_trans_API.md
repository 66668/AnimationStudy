# android.transition包源码详解
简介:该包下有24个类，按照功能划分，可以划分为四个模块，这样比较好记忆

## 1 包功能划分

## 1.1 PathMotion类及其两个子类（ArcMotion,PatternPathMotion）

可以对这个基类进行扩展，以提供沿转换路径的移动。

| java 类名 |类关系|描述信息 |
| :-----: | :------- | :----- |
| PathMotion |public abstract class PathMotion|  可扩展基类，以提供沿转换路径的移动。转换，如ChangeBounds移动视图，通常在开始和结束位置之间的直线路径上。希望这些运动在曲线中移动的应用程序，可以通过扩展PathMotion类并实现getPath()方法来改变视图在二维中的插值方式 |
| ArcMotion |public class ArcMotion extends PathMotion|  PathMotion子类,一种路径运动，在两点之间的遐想圆上，沿着圆弧产生一条弯曲的路径，如果点之间的水平距离小于垂直距离，那么圆的中心点将与终点水平对齐。如果垂直距离小于水平距离，则圆的中心点与终点垂直对齐,当两个点接近水平或垂直时，运动曲线会很小，因为圆心会远离两个点。若要强制路径的曲率，可以使用setMinimumHorizontalAngle(float)和setMinimumVerticalAngle(float)来设置两点之间弧的最小角度。 |
| PatternPathMotion |public class PatternPathMotion extends PathMotion|  PathMotion子类，一种路径运动， 采用路径模式并将其应用于两点之间的分离。路径的起点将被移动到原点，终点将被缩放和旋转，以便与目标终点匹配|

### 1.1.1ArcMotion类详解
1. 方法名
 
| 方法名 |返回|描述信息 |
| :-----: | :------- | :----- |
|getMaximumAngle()|float|返回两点之间沿圆的最大圆弧。|
|getMinimumHorizontalAngle()|float|返回水平对齐的两个点之间的最小圆弧|
|getMinimumVerticalAngle()|float|返回近垂直对齐的两个点之间沿圆的最小圆弧。|
|getPath(float startX, float startY, float endX, float endY)|Path|返回在两个点(startX, startY)和(endX, endY)之间进行插值的Path。|
|setMaximumAngle(float angleInDegrees)|void||
|setMinimumHorizontalAngle(float angleInDegrees)|void||
|setMinimumVerticalAngle(float angleInDegrees)|void||


2. xml

| xml名 |描述信息 |
| :-----: | :------- | 
|android:maximumAngle=""|两点之间沿圆的最大圆弧|
|android:minimumVerticalAngle=""|垂直对齐的两个点之间沿圆的最小圆弧|
|android:minimumHorizontalAngle=""|水平对齐的两个点之间的最小圆弧|


xml使用示例：

    <changeBounds>
       <arcMotion android:minimumHorizontalAngle="15"
                  android:minimumVerticalAngle="0"
                  android:maximumAngle="90"/>
     </changeBounds>


### 1.1.2PatternPathMotion类详解

1. 方法名
 
| 方法名 |返回|描述信息 |
| :-----: | :------- | :----- |
|getPath(float startX, float startY, float endX, float endY)|Path|返回在两个点(startX, startY)和(endX, endY)之间进行插值的Path。|
|getPatternPath()|Path|返回定义两个坐标之间的运动模式的路径。|
|setPatternPath(Path patternPath)|void|设置路径，该路径定义两个坐标之间的运动模式。|

2. xml

| xml名 |描述信息 |
| :-----: | :------- | 
|android:patternPathData=""|PathPathMotion的模式的路径字符串|

使用：

    <changeBounds>
         <patternPathMotion android:patternPathData="M0 0 L0 100 L100 100"/>
     </changeBounds>


## 1.2 TransitionPropagation类及其子类
继承TransitionPropagation类，以定制在Transition.createAnimator(ViewGroup, TransitionValues, TransitionValues)中创建的Animators的启动延迟，
一个Transition例如Explode类默认使用CircularPropagation,靠近震中的视图比远离震中的视图更晚离开场景，更早进入场景，这就造成了惯性.
在没有TransitionPropagation的情况下,所有视图都将对转换的开始同时作出反应。方法：Transition.setPropagation(TransitionPropagation)
                                                                        

| java 类名 |类关系|描述信息 |
| :-----: | :------- | :----- |
|TransitionPropagation |public abstract class TransitionPropagation| |                                                                                                                                                                                                                                                          Transition.getEpicenter()|
|VisibilityPropagation|public abstract class VisibilityPropagation extends TransitionPropagation |用于关心视图可见性和视图中心位置的transitionpropagation的基类|
|CircularPropagation|public class CircularPropagation extends VisibilityPropagation |在没有震中的情况下，随着到过渡中心或场景中心的距离而变化的Propagation。当一个视图在转换开始时可见时，离震中较远的视图将比离震中较近的视图转换得更快。当一个视图不在转换开始时或者在转换开始时不可见时，当它离震中较近时将转换得更快，当它离震中较远时将转换得更晚。这是与Explode一起使用的默认的TransitionPropagation|
|SidePropagation|public class  SidePropagation extends VisibilityPropagation |一种TransitionPropagation（传递传播），它根据到侧边的距离和到震中的垂直距离进行传播。如果转换视图在转换开始时可见，那么当它更靠近一侧时将更快地转换，当它更靠近一侧时将更晚地转换。如果视图在转换开始时不可见，那么它将在更靠近边时转换得更晚，在远离边时转换得更快。这是与Slide一起使用的默认TransitionPropagation。|


### 1.2.1 TransitionPropagation类详解

1. 方法名
 
| 方法名 |返回|描述信息 |
| :-----: | :------- | :----- |
|captureValues(TransitionValues transitionValues)|abstract void|获取此转换传播监视的属性在开始或结束场景中的值。|
|getPropagationProperties()|abstract String[]|返回存储在传输到captureValues(TransitionValues)中的TransitionValues对象中的属性名集，此转换传播关心这些属性名，以防止重复捕获属性值。|
|getStartDelay(ViewGroup sceneRoot, Transition transition, TransitionValues startValues, TransitionValues endValues)|abstract long|由Transition调用以更改动画器启动延迟。|

### 1.2.2 VisibilityPropagation类详解

1. 方法名
 
| 方法名 |返回|描述信息 |
| :-----: | :------- | :----- |
|captureValues(TransitionValues transitionValues)|void|获取此转换传播监视的属性在开始或结束场景中的值。|
|getPropagationProperties()| String[]|返回存储在传输到captureValues(TransitionValues)中的TransitionValues对象中的属性名集，此转换传播关心这些属性名，以防止重复捕获属性值。|
|getViewVisibility(TransitionValues values)|int|返回 View.getVisibility()|
|getViewX(TransitionValues values)|int|在获取值时，返回视图相对于屏幕的中心x坐标。|
|getViewY(TransitionValues values)|int|在获取值时，返回视图相对于屏幕的中心y坐标。|


### 1.2.3 CircularPropagation类详解

1. 方法名
 
| 方法名 |返回|描述信息 |
| :-----: | :------- | :----- |
|getStartDelay(ViewGroup sceneRoot, Transition transition, TransitionValues startValues, TransitionValues endValues)|long|由Transition调用以更改动画器启动延迟。|
|setPropagationSpeed(float propagationSpeed)|void|设置相对于转换持续时间的转换传播的速度。|

### 1.2.4 SidePropagation类详解

1. 方法名
 
| 方法名 |返回|描述信息 |
| :-----: | :------- | :----- |
|getStartDelay(ViewGroup sceneRoot, Transition transition, TransitionValues startValues, TransitionValues endValues)|long|由Transition调用以更改动画器启动延迟。|
|setPropagationSpeed(float propagationSpeed)|void|设置相对于转换持续时间的转换传播的速度。|
|setSide(int side)|void|设置用于计算转换传播的边。|

## 1.3 Transition类及其子类

参考 https://blog.csdn.net/linyouhui6/article/details/80944112

