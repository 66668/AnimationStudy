package com.sjy.tweenanim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Tween Animation 插值器三详解之一：xml
 */
public class TAInterpolatorxmlAct extends AppCompatActivity implements View.OnClickListener {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_interpolator_xml);
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
//------------------------------AccelerateDecelerateInterpolator----------------------------------------
//------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AccelerateDecelerateInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_a_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void AccelerateDecelerateInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_a_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void AccelerateDecelerateInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_a_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void AccelerateDecelerateInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_a_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void AccelerateDecelerateInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_a_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------AccelerateInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AccelerateInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_a);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void AccelerateInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_a);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void AccelerateInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_a);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void AccelerateInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_a);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void AccelerateInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_a);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------AnticipateInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AnticipateInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void AnticipateInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void AnticipateInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void AnticipateInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void AnticipateInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    //------------------------------------------------------------------------------------------------------
    //------------------------------AnticipateOvershootInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void AnticipateOvershootInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void AnticipateOvershootInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void AnticipateOvershootInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void AnticipateOvershootInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void AnticipateOvershootInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_ant);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    //------------------------------------------------------------------------------------------------------
    //------------------------------CycleInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void CycleInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_c);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void CycleInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_c);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void CycleInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_c);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void CycleInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_c);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void CycleInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_c);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------BounceInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void BounceInterpolator_translate() {
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
    }

    /**
     * 旋转
     */
    private void BounceInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_b);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void BounceInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_b);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void BounceInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_b);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void BounceInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_b);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------DecelerateInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void DecelerateInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void DecelerateInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void DecelerateInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void DecelerateInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void DecelerateInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }
    //------------------------------------------------------------------------------------------------------
    //------------------------------LinearInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void LinearInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_l);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void LinearInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_l);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void LinearInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_l);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void LinearInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_l);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void LinearInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_l);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }
//------------------------------------------------------------------------------------------------------
    //------------------------------OvershootInterpolator----------------------------------------
    //------------------------------------------------------------------------------------------------------

    /**
     * 平移
     */
    private void OvershootInterpolator_translate() {
        Animation trans = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_translate_o);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(trans);
    }

    /**
     * 旋转
     */
    private void OvershootInterpolator_rotate() {
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_rotate_o);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(rotate);
    }

    /**
     * 缩放
     */
    private void OvershootInterpolator_scale() {
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_scale_o);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(scale);
    }

    /**
     * 透明
     */
    private void OvershootInterpolator_alpha() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_alpha_o);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
    }

    /**
     * 综合
     */
    private void OvershootInterpolator_all() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_interpolator_all_o);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
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
