package com.sjy.tweenanim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Tween Animation 插值器三详解之二：code
 * 本例 interpolator的code方式和自定义interpolator的code方式相似
 */
public class TAInterpolatorCodeAct extends AppCompatActivity implements View.OnClickListener {

    ImageView img;

    //1
    Button btn_translate_interpolator_a_d;
    Button btn_rotate_interpolator_a_d;
    Button btn_scale_interpolator_a_d;
    Button btn_alpha_interpolator_a_d;
    Button btn_interpolator_a_d;

    //2
    Button btn_translate_interpolator_a;
    Button btn_rotate_interpolator_a;
    Button btn_scale_interpolator_a;
    Button btn_alpha_interpolator_a;
    Button btn_interpolator_a;

    //3
    Button btn_translate_interpolator_ant;
    Button btn_rotate_interpolator_ant;
    Button btn_scale_interpolator_ant;
    Button btn_alpha_interpolator_ant;
    Button btn_interpolator_ant;

    //4
    Button btn_translate_interpolator_ant_o;
    Button btn_rotate_interpolator_ant_o;
    Button btn_scale_interpolator_ant_o;
    Button btn_alpha_interpolator_ant_o;
    Button btn_interpolator_ant_o;

    //5
    Button btn_translate_interpolator_c;
    Button btn_rotate_interpolator_c;
    Button btn_scale_interpolator_c;
    Button btn_alpha_interpolator_c;
    Button btn_interpolator_c;

    //6
    Button btn_translate_interpolator_b;
    Button btn_rotate_interpolator_b;
    Button btn_scale_interpolator_b;
    Button btn_alpha_interpolator_b;
    Button btn_interpolator_b;

    //7
    Button btn_translate_interpolator_d;
    Button btn_rotate_interpolator_d;
    Button btn_scale_interpolator_d;
    Button btn_alpha_interpolator_d;
    Button btn_interpolator_d;

    //8
    Button btn_translate_interpolator_l;
    Button btn_rotate_interpolator_l;
    Button btn_scale_interpolator_l;
    Button btn_alpha_interpolator_l;
    Button btn_interpolator_l;

    //9
    Button btn_translate_interpolator_o;
    Button btn_rotate_interpolator_o;
    Button btn_scale_interpolator_o;
    Button btn_alpha_interpolator_o;
    Button btn_interpolator_o;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_interpolator_code);
        initMyView();
    }

    public void onClick(View view) {

        if (view == btn_translate_interpolator_a_d) {
            AccelerateDecelerateInterpolator_translate();
        } else if (view == btn_rotate_interpolator_a_d) {
            AccelerateDecelerateInterpolator_rotate();
        } else if (view == btn_scale_interpolator_a_d) {
            AccelerateDecelerateInterpolator_scale();
        } else if (view == btn_alpha_interpolator_a_d) {
            AccelerateDecelerateInterpolator_alpha();
        } else if (view == btn_interpolator_a_d) {
            AccelerateDecelerateInterpolator_all();
        } else if (view == btn_translate_interpolator_a) {
            AccelerateInterpolator_translate();
        } else if (view == btn_rotate_interpolator_a) {
            AccelerateInterpolator_rotate();
        } else if (view == btn_scale_interpolator_a) {
            AccelerateInterpolator_scale();
        } else if (view == btn_alpha_interpolator_a) {
            AccelerateInterpolator_alpha();
        } else if (view == btn_interpolator_a) {
            AccelerateInterpolator_all();
        } else if (view == btn_translate_interpolator_ant) {
            AnticipateInterpolator_translate();
        } else if (view == btn_rotate_interpolator_ant) {
            AnticipateInterpolator_rotate();
        } else if (view == btn_scale_interpolator_ant) {
            AnticipateInterpolator_scale();
        } else if (view == btn_alpha_interpolator_ant) {
            AnticipateInterpolator_alpha();
        } else if (view == btn_interpolator_ant) {
            AnticipateInterpolator_all();
        } else if (view == btn_translate_interpolator_ant_o) {
            AnticipateOvershootInterpolator_translate();
        } else if (view == btn_rotate_interpolator_ant_o) {
            AnticipateOvershootInterpolator_rotate();
        } else if (view == btn_scale_interpolator_ant_o) {
            AnticipateOvershootInterpolator_scale();
        } else if (view == btn_alpha_interpolator_ant_o) {
            AnticipateOvershootInterpolator_alpha();
        } else if (view == btn_interpolator_ant_o) {
            AnticipateOvershootInterpolator_all();
        } else if (view == btn_translate_interpolator_c) {
            CycleInterpolator_translate();
        } else if (view == btn_rotate_interpolator_c) {
            CycleInterpolator_rotate();
        } else if (view == btn_scale_interpolator_c) {
            CycleInterpolator_scale();
        } else if (view == btn_alpha_interpolator_c) {
            CycleInterpolator_alpha();
        } else if (view == btn_interpolator_c) {
            CycleInterpolator_all();
        } else if (view == btn_translate_interpolator_b) {
            BounceInterpolator_translate();
        } else if (view == btn_rotate_interpolator_b) {
            BounceInterpolator_rotate();
        } else if (view == btn_scale_interpolator_b) {
            BounceInterpolator_scale();
        } else if (view == btn_alpha_interpolator_b) {
            BounceInterpolator_alpha();
        } else if (view == btn_interpolator_b) {
            BounceInterpolator_all();
        } else if (view == btn_translate_interpolator_d) {
            DecelerateInterpolator_translate();
        } else if (view == btn_rotate_interpolator_d) {
            DecelerateInterpolator_rotate();
        } else if (view == btn_scale_interpolator_d) {
            DecelerateInterpolator_scale();
        } else if (view == btn_alpha_interpolator_d) {
            DecelerateInterpolator_alpha();
        } else if (view == btn_interpolator_d) {
            DecelerateInterpolator_all();
        } else if (view == btn_translate_interpolator_l) {
            LinearInterpolator_translate();
        } else if (view == btn_rotate_interpolator_l) {
            LinearInterpolator_rotate();
        } else if (view == btn_scale_interpolator_l) {
            LinearInterpolator_scale();
        } else if (view == btn_alpha_interpolator_l) {
            LinearInterpolator_alpha();
        } else if (view == btn_interpolator_l) {
            LinearInterpolator_all();
        } else if (view == btn_translate_interpolator_o) {
            OvershootInterpolator_translate();
        } else if (view == btn_rotate_interpolator_o) {
            OvershootInterpolator_rotate();
        } else if (view == btn_scale_interpolator_o) {
            OvershootInterpolator_scale();
        } else if (view == btn_alpha_interpolator_o) {
            OvershootInterpolator_alpha();
        } else if (view == btn_interpolator_o) {
            OvershootInterpolator_all();
        }
    }
//------------------------------------------------------------------------------------------------------
//------------------------------1 AccelerateDecelerateInterpolator----------------------------------------
//------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AccelerateDecelerateInterpolator_translate() {
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

        //自定义AccelerateDecelerateInterpolator
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void AccelerateDecelerateInterpolator_rotate() {

        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义AccelerateDecelerateInterpolator
        right.setInterpolator(new AccelerateDecelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void AccelerateDecelerateInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义AccelerateDecelerateInterpolator
        small.setInterpolator(new AccelerateDecelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void AccelerateDecelerateInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);


        //自定义AccelerateDecelerateInterpolator
        alpha.setInterpolator(new AccelerateDecelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void AccelerateDecelerateInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义AccelerateDecelerateInterpolator
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        img.startAnimation(set);
    }

    //------------------------------------------------------------------------------------------------------
    //------------------------------2 AccelerateInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AccelerateInterpolator_translate() {
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

        //自定义AccelerateInterpolator
        animation.setInterpolator(new AccelerateInterpolator());
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void AccelerateInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义AccelerateInterpolator
        right.setInterpolator(new AccelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void AccelerateInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义AccelerateInterpolator
        small.setInterpolator(new AccelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void AccelerateInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);


        //自定义AccelerateInterpolator
        alpha.setInterpolator(new AccelerateInterpolator());


        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void AccelerateInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义AccelerateInterpolator
        set.setInterpolator(new AccelerateInterpolator());
        img.startAnimation(set);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------AnticipateInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AnticipateInterpolator_translate() {
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
        animation.setInterpolator(new AnticipateInterpolator());

        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void AnticipateInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义AnticipateInterpolator
        right.setInterpolator(new AnticipateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void AnticipateInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义AnticipateInterpolator
        small.setInterpolator(new AnticipateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void AnticipateInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);


        //自定义AnticipateInterpolator
        alpha.setInterpolator(new AnticipateInterpolator());


        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void AnticipateInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义AnticipateInterpolator
        set.setInterpolator(new AnticipateInterpolator(4));
        img.startAnimation(set);
    }

    //------------------------------------------------------------------------------------------------------
    //------------------------------AnticipateOvershootInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AnticipateOvershootInterpolator_translate() {
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


        //自定义AnticipateOvershootInterpolator
        animation.setInterpolator(new AnticipateOvershootInterpolator(4));

        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void AnticipateOvershootInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义AnticipateOvershootInterpolator
        right.setInterpolator(new AnticipateOvershootInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void AnticipateOvershootInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义AnticipateOvershootInterpolator
        small.setInterpolator(new AnticipateOvershootInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void AnticipateOvershootInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);


        //自定义AnticipateOvershootInterpolator
        alpha.setInterpolator(new AnticipateOvershootInterpolator());


        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void AnticipateOvershootInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义AnticipateOvershootInterpolator
        set.setInterpolator(new AnticipateOvershootInterpolator());
        //
        img.startAnimation(set);
    }

    //------------------------------------------------------------------------------------------------------
    //------------------------------CycleInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void CycleInterpolator_translate() {
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

        //自定义CycleInterpolator
        animation.setInterpolator(new CycleInterpolator(1));

        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void CycleInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义CycleInterpolator
        right.setInterpolator(new CycleInterpolator(1));

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void CycleInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义CycleInterpolator
        small.setInterpolator(new CycleInterpolator(1));

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void CycleInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);


        //自定义CycleInterpolator
        alpha.setInterpolator(new CycleInterpolator(1));

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void CycleInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义CycleInterpolator
        set.setInterpolator(new CycleInterpolator(1));
        img.startAnimation(set);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------BounceInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void BounceInterpolator_translate() {
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

        //自定义BounceInterpolator
        animation.setInterpolator(new BounceInterpolator());

        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void BounceInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义BounceInterpolator
        right.setInterpolator(new BounceInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void BounceInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义BounceInterpolator
        small.setInterpolator(new BounceInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void BounceInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);


        //自定义BounceInterpolator
        alpha.setInterpolator(new BounceInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void BounceInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义BounceInterpolator
        set.setInterpolator(new BounceInterpolator());
        img.startAnimation(set);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------DecelerateInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void DecelerateInterpolator_translate() {
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

        //自定义DecelerateInterpolator
        animation.setInterpolator(new DecelerateInterpolator());

        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void DecelerateInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义DecelerateInterpolator
        right.setInterpolator(new DecelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void DecelerateInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义DecelerateInterpolator
        small.setInterpolator(new DecelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void DecelerateInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);


        //自定义DecelerateInterpolator
        alpha.setInterpolator(new DecelerateInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void DecelerateInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义DecelerateInterpolator
        set.setInterpolator(new DecelerateInterpolator());
        img.startAnimation(set);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------LinearInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void LinearInterpolator_translate() {
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

        //自定义LinearInterpolator
        animation.setInterpolator(new LinearInterpolator());

        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void LinearInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义LinearInterpolator
        right.setInterpolator(new LinearInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void LinearInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义LinearInterpolator
        small.setInterpolator(new LinearInterpolator());


        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void LinearInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);

        //自定义LinearInterpolator
        alpha.setInterpolator(new LinearInterpolator());

        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void LinearInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义LinearInterpolator
        set.setInterpolator(new LinearInterpolator());
        img.startAnimation(set);
    }
//------------------------------------------------------------------------------------------------------
    //------------------------------OvershootInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void OvershootInterpolator_translate() {
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

        //自定义OvershootInterpolator
        animation.setInterpolator(new OvershootInterpolator());

        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);
    }

    /**
     * 旋转
     */
    private void OvershootInterpolator_rotate() {
        RotateAnimation right = new RotateAnimation(0.0f, 720.0f, 0.5f, 0.5f);
        right.setDuration(1000);
        right.setFillAfter(true);
        right.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        right.setZAdjustment(Animation.ZORDER_TOP);
        right.setRepeatCount(1);
        right.setRepeatMode(Animation.REVERSE);
        right.setStartOffset(100);

        //自定义OvershootInterpolator
        right.setInterpolator(new OvershootInterpolator());


        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(right);
    }

    /**
     * 缩放
     */
    private void OvershootInterpolator_scale() {
        ScaleAnimation small = new ScaleAnimation(1.0f, 1.5f, 1.0f, 2.0f);
        small.setDuration(1000);
        small.setFillAfter(true);
        small.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        small.setZAdjustment(Animation.ZORDER_TOP);
        small.setRepeatCount(1);
        small.setRepeatMode(Animation.REVERSE);
        small.setStartOffset(100);

        //自定义OvershootInterpolator
        small.setInterpolator(new OvershootInterpolator());


        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(small);
    }

    /**
     * 透明
     */
    private void OvershootInterpolator_alpha() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.2f);
        alpha.setDuration(1000);
        alpha.setFillAfter(true);
        alpha.setFillBefore(false);
        //trans.setFillEnabled(false);//同setFillBefore(false)
        alpha.setZAdjustment(Animation.ZORDER_TOP);
        alpha.setRepeatCount(2);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setStartOffset(200);

        //自定义OvershootInterpolator
        alpha.setInterpolator(new OvershootInterpolator());


        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(alpha);
    }

    /**
     * 综合
     */
    private void OvershootInterpolator_all() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        //开启新动画
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(getAlphaAnimation());
        set.addAnimation(getRotateAnimation());
        set.addAnimation(getScaleAnimation());
        set.addAnimation(getTranslateAnimation());

        //自定义OvershootInterpolator
        set.setInterpolator(new OvershootInterpolator());
        img.startAnimation(set);
    }


    private Animation getAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillBefore(false);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        return alphaAnimation;
    }

    private Animation getRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f,
                getWidth() / 2, getHeight() / 2);
        rotateAnimation.setDuration(1000);
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
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(2);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillBefore(false);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        return scaleAnimation;
    }

    private Animation getTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, -200,
                0, 0);
        translateAnimation.setDuration(1000);
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

    private void initMyView() {
        img = findViewById(R.id.img);

        //1
        btn_translate_interpolator_a_d = findViewById(R.id.btn_translate_interpolator_a_d);
        btn_rotate_interpolator_a_d = findViewById(R.id.btn_rotate_interpolator_a_d);
        btn_scale_interpolator_a_d = findViewById(R.id.btn_scale_interpolator_a_d);
        btn_alpha_interpolator_a_d = findViewById(R.id.btn_alpha_interpolator_a_d);
        btn_interpolator_a_d = findViewById(R.id.btn_interpolator_a_d);

        //2
        btn_translate_interpolator_a = findViewById(R.id.btn_translate_interpolator_a);
        btn_rotate_interpolator_a = findViewById(R.id.btn_rotate_interpolator_a);
        btn_scale_interpolator_a = findViewById(R.id.btn_scale_interpolator_a);
        btn_alpha_interpolator_a = findViewById(R.id.btn_alpha_interpolator_a);
        btn_interpolator_a = findViewById(R.id.btn_interpolator_a);

        //3
        btn_translate_interpolator_b = findViewById(R.id.btn_translate_interpolator_b);
        btn_rotate_interpolator_b = findViewById(R.id.btn_rotate_interpolator_b);
        btn_scale_interpolator_b = findViewById(R.id.btn_scale_interpolator_b);
        btn_alpha_interpolator_b = findViewById(R.id.btn_alpha_interpolator_b);
        btn_interpolator_b = findViewById(R.id.btn_interpolator_b);

        //4
        btn_translate_interpolator_c = findViewById(R.id.btn_translate_interpolator_c);
        btn_rotate_interpolator_c = findViewById(R.id.btn_rotate_interpolator_c);
        btn_scale_interpolator_c = findViewById(R.id.btn_scale_interpolator_c);
        btn_alpha_interpolator_c = findViewById(R.id.btn_alpha_interpolator_c);
        btn_interpolator_c = findViewById(R.id.btn_interpolator_c);

        //5
        btn_translate_interpolator_d = findViewById(R.id.btn_translate_interpolator_d);
        btn_rotate_interpolator_d = findViewById(R.id.btn_rotate_interpolator_d);
        btn_scale_interpolator_d = findViewById(R.id.btn_scale_interpolator_d);
        btn_alpha_interpolator_d = findViewById(R.id.btn_alpha_interpolator_d);
        btn_interpolator_d = findViewById(R.id.btn_interpolator_d);


        //6
        btn_translate_interpolator_l = findViewById(R.id.btn_translate_interpolator_l);
        btn_rotate_interpolator_l = findViewById(R.id.btn_rotate_interpolator_l);
        btn_scale_interpolator_l = findViewById(R.id.btn_scale_interpolator_l);
        btn_alpha_interpolator_l = findViewById(R.id.btn_alpha_interpolator_l);
        btn_interpolator_l = findViewById(R.id.btn_interpolator_l);

        //7
        btn_translate_interpolator_o = findViewById(R.id.btn_translate_interpolator_o);
        btn_rotate_interpolator_o = findViewById(R.id.btn_rotate_interpolator_o);
        btn_scale_interpolator_o = findViewById(R.id.btn_scale_interpolator_o);
        btn_alpha_interpolator_o = findViewById(R.id.btn_alpha_interpolator_o);
        btn_interpolator_o = findViewById(R.id.btn_interpolator_o);

        //8
        btn_translate_interpolator_ant = findViewById(R.id.btn_translate_interpolator_ant);
        btn_rotate_interpolator_ant = findViewById(R.id.btn_rotate_interpolator_ant);
        btn_scale_interpolator_ant = findViewById(R.id.btn_scale_interpolator_ant);
        btn_alpha_interpolator_ant = findViewById(R.id.btn_alpha_interpolator_ant);
        btn_interpolator_ant = findViewById(R.id.btn_interpolator_ant);

        //9
        btn_translate_interpolator_ant_o = findViewById(R.id.btn_translate_interpolator_ant_o);
        btn_rotate_interpolator_ant_o = findViewById(R.id.btn_rotate_interpolator_ant_o);
        btn_scale_interpolator_ant_o = findViewById(R.id.btn_scale_interpolator_ant_o);
        btn_alpha_interpolator_ant_o = findViewById(R.id.btn_alpha_interpolator_ant_o);
        btn_interpolator_ant_o = findViewById(R.id.btn_interpolator_ant_o);

        btn_translate_interpolator_a_d.setOnClickListener(this);
        btn_rotate_interpolator_a_d.setOnClickListener(this);
        btn_scale_interpolator_a_d.setOnClickListener(this);
        btn_alpha_interpolator_a_d.setOnClickListener(this);
        btn_interpolator_a_d.setOnClickListener(this);

        btn_translate_interpolator_a.setOnClickListener(this);
        btn_translate_interpolator_b.setOnClickListener(this);
        btn_translate_interpolator_c.setOnClickListener(this);
        btn_translate_interpolator_d.setOnClickListener(this);
        btn_translate_interpolator_l.setOnClickListener(this);
        btn_translate_interpolator_o.setOnClickListener(this);
        btn_translate_interpolator_ant.setOnClickListener(this);
        btn_translate_interpolator_ant_o.setOnClickListener(this);

        btn_rotate_interpolator_a.setOnClickListener(this);
        btn_rotate_interpolator_b.setOnClickListener(this);
        btn_rotate_interpolator_c.setOnClickListener(this);
        btn_rotate_interpolator_d.setOnClickListener(this);
        btn_rotate_interpolator_l.setOnClickListener(this);
        btn_rotate_interpolator_o.setOnClickListener(this);
        btn_rotate_interpolator_ant.setOnClickListener(this);
        btn_rotate_interpolator_ant_o.setOnClickListener(this);


        btn_scale_interpolator_a.setOnClickListener(this);
        btn_scale_interpolator_b.setOnClickListener(this);
        btn_scale_interpolator_c.setOnClickListener(this);
        btn_scale_interpolator_d.setOnClickListener(this);
        btn_scale_interpolator_l.setOnClickListener(this);
        btn_scale_interpolator_o.setOnClickListener(this);
        btn_scale_interpolator_ant.setOnClickListener(this);
        btn_scale_interpolator_ant_o.setOnClickListener(this);

        btn_alpha_interpolator_a.setOnClickListener(this);
        btn_alpha_interpolator_b.setOnClickListener(this);
        btn_alpha_interpolator_c.setOnClickListener(this);
        btn_alpha_interpolator_d.setOnClickListener(this);
        btn_alpha_interpolator_l.setOnClickListener(this);
        btn_alpha_interpolator_o.setOnClickListener(this);
        btn_alpha_interpolator_ant.setOnClickListener(this);
        btn_alpha_interpolator_ant_o.setOnClickListener(this);

        btn_interpolator_a.setOnClickListener(this);
        btn_interpolator_b.setOnClickListener(this);
        btn_interpolator_c.setOnClickListener(this);
        btn_interpolator_d.setOnClickListener(this);
        btn_interpolator_l.setOnClickListener(this);
        btn_interpolator_o.setOnClickListener(this);
        btn_interpolator_ant.setOnClickListener(this);
        btn_interpolator_ant_o.setOnClickListener(this);


    }

}
