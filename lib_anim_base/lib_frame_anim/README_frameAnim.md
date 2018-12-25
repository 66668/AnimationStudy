# Frame Animation 帧动画详解
帧动画是三种动画中最简单的，只是将一组动画逐帧播放出来即可。
其中 图片组的位置在 res/drawable下，xml的设置也是在res/drawalbe下，使用的标签是animation-list/item，
使用的java类是AnimationDrawable,这样就可以完成帧动画播放，具体使用如下：

设置run.xml：
    
    <?xml version="1.0" encoding="utf-8"?>
    <animation-list
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:oneshot="false">
        <item
            android:drawable="@drawable/run1"
            android:duration="100"/>
        <item
            android:drawable="@drawable/run2"
            android:duration="100"/>
        <item
            android:drawable="@drawable/run3"
            android:duration="100"/>
        <item
            android:drawable="@drawable/run4"
            android:duration="100"/>
        <item
            android:drawable="@drawable/run5"
            android:duration="100"/>
        <item
            android:drawable="@drawable/run6"
            android:duration="100"/>
        <item
            android:drawable="@drawable/run7"
            android:duration="100"/>
    </animation-list>

xml方式绑定：注意这两种方式的绑定，xml使用src，则代码获取AnimationDrawable对象，必须用iamgeView.getDrawable()；xml使用background，则代码获取AnimationDrawable对象，必须用iamgeView.getBackground()；这个不能混。
 
     <ImageView
         android:id="@+id/img"
         android:src="@drawable/run"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content" />
  或:
  
    <ImageView
          android:id="@+id/img"
          android:background="@drawable/run"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content" />
代码方式绑定：

        AnimationDrawable animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.run);
        img.setBackground(animationDrawable);
 或：
 
         img.setBackgroundResource(R.drawable.run);
         AnimationDrawable animationDrawable = (AnimationDrawable) img.getBackground();   
 或：
   
      private AnimationDrawable setType4() {
            AnimationDrawable animationDrawable = new AnimationDrawable();
            for (int i = 1; i < 8; i++) {
                int id = getResources().getIdentifier("run" + i, "drawable", getPackageName());
                Drawable drawable = getDrawable(id);
                if (null != drawable) {
                    animationDrawable.addFrame(drawable, 100);
                }
            }
            img.setImageDrawable(animationDrawable);
            return (AnimationDrawable) img.getDrawable();
        }

这样就可以放心使用：

    private void doAnimation(AnimationDrawable animationDrawable, boolean doIt) {
        if (doIt) {
            animationDrawable.start();
        } else {
            if (animationDrawable.isRunning()) {
                animationDrawable.stop();
            }
        }
    }