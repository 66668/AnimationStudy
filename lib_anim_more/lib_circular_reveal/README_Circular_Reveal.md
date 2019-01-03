# Circular Reveal/循环揭露动画/

简介：在android5.0(API 21)或更高版本，可以使用揭露动画，官方解释：当您显示或隐藏一组 UI 元素时，揭露动画可为用户提供视觉连续性，使用
ViewAnimationUtils.createCircularReveal(View view,int centerX,  int centerY, float startRadius, float endRadius) 方法
让您能够为裁剪区域添加动画以揭露或隐藏视图。

所以揭露动画很简单，使用如上方法就能实现，只需要理解方法参数含义即可。

## 参数详解：

 如下方法的解释：揭露动画对象只能使用一次，不能被重新使用，也就是说每次使用揭露动画都要调用 ViewAnimationUtils.createCircularReveal() 返回一个揭露动画对象使用，
 同时一旦开始了动画就不能暂停或重新开始。揭露动画是一种异步动画，可以自动运行在 UI 线程上。 当揭露动画结束后，如果设置了 Animator.AnimatorListener 监听器，
 那么监听器的 onAnimationEnd(Animator) 方法会被调用， 但可能会被延迟调用，这取决于线程的响应能力。
    
    package android.view;
    
    import android.animation.Animator;
    import android.animation.Animator.AnimatorListener;
    import android.animation.RevealAnimator;
    
    /**
     * 定义处理视图动画的常用工具。
     *
     */
    public final class ViewAnimationUtils {
        private ViewAnimationUtils() {}
        /**
         *
         * @param view The View will be clipped to the animating circle.
         * @param centerX The x coordinate of the center of the animating circle, relative to
         *                <code>view</code>.
         * @param centerY The y coordinate of the center of the animating circle, relative to
         *                <code>view</code>.
         * @param startRadius The starting radius of the animating circle.
         * @param endRadius The ending radius of the animating circle.
         */
        public static Animator createCircularReveal(View view,
                int centerX,  int centerY, float startRadius, float endRadius) {
            return new RevealAnimator(view, centerX, centerY, startRadius, endRadius);
        }
    }

1. 参数1 View view：           执行揭露动画的 View 视图
2. 参数2 int centerX：         相对于视图 View 的坐标系，动画圆的中心的x坐标
3. 参数3 int centerY：         相对于视图 View 的坐标系，动画圆的中心的y坐标
4. 参数4 float startRadius：   动画圆的起始半径
4. 参数5 float endRadius：     动画圆的结束半径

![circular reveal 动画](https://github.com/66668/AnimationStudy/blob/master/interpolator_pic/createCircularReveal.jpg)

### 简单使用示例：
