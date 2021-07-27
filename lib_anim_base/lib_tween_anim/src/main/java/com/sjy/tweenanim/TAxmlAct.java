package com.sjy.tweenanim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Tween Animation xml样式
 */
public class TAxmlAct extends AppCompatActivity implements View.OnClickListener {
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_xmldemo);
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

        btn_translate.setOnClickListener(this);
        btn_translate_lr.setOnClickListener(this);
        btn_rotate_r.setOnClickListener(this);
        btn_rotate_l.setOnClickListener(this);
        btn_scale_big.setOnClickListener(this);
        btn_scale_small.setOnClickListener(this);
        btn_alpha_1.setOnClickListener(this);
        btn_alpha_0.setOnClickListener(this);
        btn_demo1.setOnClickListener(this);

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
        }
    }

    /**
     * 示例1
     */
    private void demo1() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.ta_xml_demo);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(animation);

        //移动监听
        animation.setAnimationListener(new Animation.AnimationListener() {
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
     * xml 上下平移
     */
    private void translateUpDown() {
        Animation up = AnimationUtils.loadAnimation(this, R.anim.ta_translate_u);
        final Animation down = AnimationUtils.loadAnimation(this, R.anim.ta_translate_d);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(up);

        //移动监听
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
     * xml 左右平移
     */
    private void translateLeftRight() {
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_translate_l);
        final Animation right = AnimationUtils.loadAnimation(this, R.anim.ta_translate_r);
        //清除之前动画没执行完的影响
        Animation oldAnimation = img.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                img.clearAnimation();
            }
        }
        img.startAnimation(left);
        //移动监听
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
        Animation right = AnimationUtils.loadAnimation(this, R.anim.ta_rotate_r);
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
        Animation left = AnimationUtils.loadAnimation(this, R.anim.ta_rotate_l);
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
        Animation big = AnimationUtils.loadAnimation(this, R.anim.ta_scale_big);
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
        Animation small = AnimationUtils.loadAnimation(this, R.anim.ta_scale_small);
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
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.ta_alpha_1);
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
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.ta_alpha_0);
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


}
