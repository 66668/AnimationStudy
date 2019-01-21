# android动画学习

## 动画分类简介：

Android平台提供了强大的动画框架，使我们在完成复杂的特效时不用自己改变空间的位置或者设置属性通过简单的动画代码就可以实现。

android3.0之前，主要包括两种动画方式：**补间动画**（Tween Animation）和**帧动画**（Frame Animation 或者 Drawable Animation），这两种动画统称为view 动画。

针对视图动画存在的不足，3.0之后google增加了**属性动画**（Property Animation）。之后动画就被分成了**View Animation** 和**Property Animation**。

紧接着，5.0之后，为用户与app交互反馈他们的动作行为和提供了视觉上的连贯性，Material Design又补充了许多过渡动画：
1. **Ripple Effect 触摸反馈(Touch feedback)**
2. **Circular Reveal  圆形展示**
3. **Curved motion       曲线运动**
4. **View state changes  视图状态变化**
5. **Vector Drawables 矢量图动画**
6. **Activity transitions  活动转场**

所以分类时,以最小的功能块划分为：

### Tween Animation（补间动画--属于View Animation）
在一个视图容器内，执行一系列简单变化，可包括平移，旋转，缩放，透明（AlphaAnimation，RotateAnimation，ScaleAnimation，TranslateAnimation，AnimationSet）。
可用xml或android代码定义，通常使用xml设置

### Drawable Animation / Frame Animation(帧动画--属于View Animation)
将res下的drawable/mipmap图，一个一个的播放
帧动画也是view动画的一种，帧动画是通过读取xml文件中设置的一系列Drawable，以类似幻听片的方式展示这些drawable,就形成了动画效果，当然也可以利用代码实现帧动画。
可能大家觉着帧动画不太常用，其实类似的原理可以借鉴，类似android手机开机的很多动画效果就是类似帧动画，加载一系列图片，实现开机的动画效果。

### Property Animation 属性动画
如果用xml样式，则在res/animator下创建xml。但是属性动画推荐使用code方式，效果方便控制。


**如上只是简介，具体讲解及示例请跳转：**

1. [Tween Animation 补间动画 详解跳转](https://github.com/66668/AnimationStudy/blob/master/lib_anim_base/lib_tween_anim/README_tweenAnim.md);

2. [Frame Animation 帧动画 详解跳转](https://github.com/66668/AnimationStudy/blob/master/lib_anim_base/lib_frame_anim/README_frameAnim.md);

3. [Property Animation 属性动画 详解跳转](https://github.com/66668/AnimationStudy/blob/master/lib_anim_base/lib_property_anim/README_propertyAnim.md);

高级动画：

4. [Ripple Effect 触摸反馈动画 详解跳转](https://github.com/66668/AnimationStudy/blob/master/lib_anim_more/lib_ripple_effect/README_Ripple_Effect.md);

5. [Circular Reveal 循环揭露动画 详解跳转](https://github.com/66668/AnimationStudy/blob/master/lib_anim_more/lib_circular_reveal/README_Circular_Reveal.md);

6. [View State Changes 视图状态动画 详解跳转](https://github.com/66668/AnimationStudy/blob/master/lib_anim_more/lib_view_state_changes/README_ViewStateChanges.md);


属性动画 翻译官方文档：https://www.jianshu.com/p/51f6576cf20e


开源动画：
https://github.com/ybq/Android-SpinKit

参考：
https://www.jianshu.com/p/0eb89d43eea4

https://github.com/lgvalle/Material-Animations

