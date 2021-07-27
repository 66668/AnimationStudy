package com.sjy.tweenanim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Tween Animation 代码样式
 */
public class TAcodeAct extends AppCompatActivity implements View.OnClickListener {

    ImageView img;
    Button btn_translate;
    Button btn_translate_lr;
    Button btn_rotate_r;

    Button btn_rotate_l;

    Button btn_scale_big;

    Button btn_scale_small;

    Button btn_alpha_1;

    Button btn_alpha_0;

    Button btn_demo1;

    Button btn_demo2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_codedemo);
        initMyView();
    }

    private void initMyView() {
        img = findViewById(R.id.img);
        btn_translate = findViewById(R.id.btn_translate_ud);
        btn_translate_lr = findViewById(R.id.btn_translate_lr);
        btn_rotate_r = findViewById(R.id.btn_rotate_r);
        btn_rotate_l = findViewById(R.id.btn_rotate_l);
        btn_scale_big = findViewById(R.id.btn_scale_big);
        btn_scale_small = findViewById(R.id.btn_scale_small);
        btn_alpha_1 = findViewById(R.id.btn_alpha_1);
        btn_alpha_0 = findViewById(R.id.btn_alpha_0);
        btn_demo1 = findViewById(R.id.btn_demo1);
        btn_demo2 = findViewById(R.id.btn_demo2);

        btn_translate.setOnClickListener(this);
        btn_translate_lr.setOnClickListener(this);
        btn_rotate_r.setOnClickListener(this);
        btn_rotate_l.setOnClickListener(this);
        btn_scale_big.setOnClickListener(this);
        btn_scale_small.setOnClickListener(this);
        btn_alpha_1.setOnClickListener(this);
        btn_alpha_0.setOnClickListener(this);
        btn_demo1.setOnClickListener(this);
        btn_demo2.setOnClickListener(this);

    }

    public void onClick(View view) {
        if (view == btn_translate) {
            translateUpDown();
        } else if (view == btn_translate_lr) {
            translateLeftRight();
        } else if (view == btn_rotate_r) {
            rightRotate();
        } else if (view == btn_rotate_l) {
            leftRotate();
        } else if (view == btn_scale_big) {
            scaleBig();
        } else if (view == btn_scale_small) {
            scaleSmall();
        } else if (view == btn_alpha_1) {
            alphaTo1();
        } else if (view == btn_alpha_0) {
            alphaTo0();
        } else if (view == btn_demo1) {
            demo1();
        } else if (view == btn_demo2) {
            demo2();
        }
    }

    /**
     * code 上下平移
     */
    private void translateUpDown() {
        //向上
        TranslateAnimation up = new TranslateAnimation(0, 0, 0, 100);
        up.setDuration(2000);
        up.setFillAfter(true);
        up.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        up.setZAdjustment(Animation.ZORDER_TOP);
        up.setRepeatCount(1);
        up.setRepeatMode(Animation.REVERSE);
        up.setStartOffset(500);
        //向下
        final TranslateAnimation down = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -150);
        down.setDuration(2000);
        down.setFillAfter(true);
        down.setFillBefore(true);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        down.setZAdjustment(Animation.ZORDER_TOP);
        down.setRepeatCount(1);
        down.setRepeatMode(Animation.RESTART);
        down.setStartOffset(500);
        //
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(up);
        //
        up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
                img.startAnimation(down);
            }


            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");

            }
        });
    }

    /**
     * code 左右平移
     */
    private void translateLeftRight() {
        //向左
        TranslateAnimation left = new TranslateAnimation(0, -120, 0, 0);
        left.setDuration(2000);
        left.setFillAfter(true);
        left.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        left.setZAdjustment(Animation.ZORDER_TOP);
        left.setRepeatCount(1);
        left.setRepeatMode(Animation.REVERSE);
        left.setStartOffset(500);
        //向右
        final TranslateAnimation right = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 200,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
        right.setDuration(2000);
        right.setFillAfter(true);
        right.setFillBefore(true);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.RESTART);
        right.setStartOffset(500);
        //
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
        //
        left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
                img.startAnimation(right);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");

            }
        });
    }

    /**
     * 顺时针旋转
     */
    private void rightRotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 180.0f, 0.5f, 0.5f);
        right.setDuration(2000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(500);
        //
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);

        //
        right.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");
            }
        });

    }

    /**
     * 逆时针旋转
     */
    private void leftRotate() {
        RotateAnimation left = new RotateAnimation(0.0f, -720.0f, 0.5f, 0.5f);
        left.setDuration(2000);
        left.setFillAfter(true);
        left.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        left.setZAdjustment(Animation.ZORDER_TOP);
        left.setRepeatCount(1);
        left.setRepeatMode(Animation.REVERSE);
        left.setStartOffset(500);

        //
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);

        //
        left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");
            }
        });

    }

    /**
     * 变大
     */
    private void scaleBig() {
        ScaleAnimation big = new ScaleAnimation(1.0f, 2.0f, 1.0f, 3.0f);
        big.setDuration(2000);
        big.setFillAfter(true);
        big.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        big.setZAdjustment(Animation.ZORDER_TOP);
        big.setRepeatCount(1);
        big.setRepeatMode(Animation.REVERSE);
        big.setStartOffset(500);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(big);

        big.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");
            }
        });
    }

    /**
     * 变小
     */
    private void scaleSmall() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
        small.setDuration(2000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(500);

        //
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);

        small.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");
            }
        });
    }

    /**
     * 变透明
     */
    private void alphaTo1() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(2000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(500);

        //
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");
            }
        });
    }

    /**
     * 透明变实体
     */
    private void alphaTo0() {
        AlphaAnimation alpha = new AlphaAnimation(0f, 1.0f);
        alpha.setDuration(2000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(1);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(500);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");
            }
        });
    }

    /**
     * 示例1
     */
    private void demo1() {
        /*
         *  创建一个AnimationSet，它能够同时执行多个动画效果
         *  构造方法的入参如果是“true”，则代表使用默认的interpolator，如果是“false”则代表使用自定义interpolator
         */
        AnimationSet set = new AnimationSet(true);

        /**
         *  TranslateAnimation
         */
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 200, 100);
        translateAnimation.setDuration(2000);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        translateAnimation.setZAdjustment(Animation.ZORDER_TOP);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setStartOffset(500);

        /**
         *  RotateAnimation
         */
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 540.0f, 0.5f, 0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        rotateAnimation.setZAdjustment(Animation.ZORDER_TOP);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setStartOffset(500);

        /**
         *  ScaleAnimation
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 3.0f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        scaleAnimation.setZAdjustment(Animation.ZORDER_TOP);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setStartOffset(500);


        /**
         *  AlphaAnimation
         */
        AlphaAnimation alpha = new AlphaAnimation(0.2f, 0.9f);
        alpha.setDuration(2000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(1);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(500);

        //四个动作装入容器中
        set.addAnimation(translateAnimation);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alpha);

        //
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(set);
        //移动监听
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("SJY", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("SJY", "onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("SJY", "onAnimationRepeat");

            }
        });
    }

    /**
     * 示例2
     */
    private void demo2() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set2 = new AnimationSet(true);
        set2.addAnimation(getAlphaAnimation());
        set2.addAnimation(getRotateAnimation());
        set2.addAnimation(getScaleAnimation());
        set2.addAnimation(getTranslateAnimation());
        img.startAnimation(set2);

    }

    private Animation getAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillBefore(false);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        return alphaAnimation;
    }

    private Animation getRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f,
                getWidth() / 2, getHeight() / 2);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setFillBefore(false);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        return rotateAnimation;
    }

    private Animation getScaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 2f,
                1f, 2f,
                getWidth() / 2, getHeight() / 2);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setRepeatCount(2);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillBefore(false);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        return scaleAnimation;
    }

    private Animation getTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, getWidth() * 2,
                0, getHeight() * 2);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatCount(2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillBefore(false);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        return translateAnimation;
    }

    private int getWidth() {
        return img.getWidth();
    }

    private int getHeight() {
        return img.getHeight();
    }


}
