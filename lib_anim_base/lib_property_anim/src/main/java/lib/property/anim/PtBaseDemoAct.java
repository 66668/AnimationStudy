package lib.property.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 属性动画 演示补间动画的所有操作
 */
public class PtBaseDemoAct extends AppCompatActivity {
    public static final String TAG = "SJY";

    //-----------------------------控件--------------------------------
    @BindView(R2.id.img)
    ImageView img;

    //ValueAnimator xml示例
    @BindView(R2.id.btn_valueAnim_trans)
    Button btn_valueAnim_trans;

    @BindView(R2.id.btn_valueAnim_rotate)
    Button btn_valueAnim_rotate;

    @BindView(R2.id.btn_valueAnim_scale)
    Button btn_valueAnim_scale;

    @BindView(R2.id.btn_valueAnim_alpha)
    Button btn_valueAnim_alpha;

    @BindView(R2.id.btn_valueAnim_all)
    Button btn_valueAnim_all;


    @BindView(R2.id.btn_valueAnim_trans_1)
    Button btn_valueAnim_trans_1;

    @BindView(R2.id.btn_valueAnim_rotate_1)
    Button btn_valueAnim_rotate_1;

    @BindView(R2.id.btn_valueAnim_scale_1)
    Button btn_valueAnim_scale_1;

    @BindView(R2.id.btn_valueAnim_alpha_1)
    Button btn_valueAnim_alpha_1;

    @BindView(R2.id.btn_valueAnim_all_1)
    Button btn_valueAnim_all_1;


    //ValueAnimator code示例

    @BindView(R2.id.btn_valueAnim_trans_2)
    Button btn_valueAnim_trans_2;

    @BindView(R2.id.btn_valueAnim_rotate_2)
    Button btn_valueAnim_rotate_2;

    @BindView(R2.id.btn_valueAnim_scale_2)
    Button btn_valueAnim_scale_2;

    @BindView(R2.id.btn_valueAnim_alpha_2)
    Button btn_valueAnim_alpha_2;

    @BindView(R2.id.btn_valueAnim_all_2)
    Button btn_valueAnim_all_2;


    @BindView(R2.id.btn_valueAnim_trans_3)
    Button btn_valueAnim_trans_3;

    @BindView(R2.id.btn_valueAnim_rotate_3)
    Button btn_valueAnim_rotate_3;

    @BindView(R2.id.btn_valueAnim_scale_3)
    Button btn_valueAnim_scale_3;

    @BindView(R2.id.btn_valueAnim_all_3)
    Button btn_valueAnim_all_3;


    @BindView(R2.id.btn_valueAnim_trans_4)
    Button btn_valueAnim_trans_4;

    @BindView(R2.id.btn_valueAnim_rotate_4)
    Button btn_valueAnim_rotate_4;

    @BindView(R2.id.btn_valueAnim_scale_4)
    Button btn_valueAnim_scale_4;

    @BindView(R2.id.btn_valueAnim_alpha_4)
    Button btn_valueAnim_alpha_4;

    @BindView(R2.id.btn_valueAnim_all_4)
    Button btn_valueAnim_all_4;


    //-------------------------------------------------------------
    private int type = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_base);
        ButterKnife.bind(this);
        Log.d(TAG, "Demo1Act img.getLayoutParams().width=" + img.getLayoutParams().width);
    }

    /**
     * 点击监听
     *
     * @param view
     */
    @OnClick({
            R2.id.btn_valueAnim_trans, R2.id.btn_valueAnim_rotate, R2.id.btn_valueAnim_scale, R2.id.btn_valueAnim_alpha, R2.id.btn_valueAnim_all,
            R2.id.btn_valueAnim_trans_1, R2.id.btn_valueAnim_rotate_1, R2.id.btn_valueAnim_scale_1, R2.id.btn_valueAnim_alpha_1, R2.id.btn_valueAnim_all_1,
            R2.id.btn_valueAnim_trans_2, R2.id.btn_valueAnim_rotate_2, R2.id.btn_valueAnim_scale_2, R2.id.btn_valueAnim_alpha_2, R2.id.btn_valueAnim_all_2,
            R2.id.btn_valueAnim_trans_3, R2.id.btn_valueAnim_rotate_3, R2.id.btn_valueAnim_scale_3, R2.id.btn_valueAnim_all_3,
            R2.id.btn_valueAnim_trans_4, R2.id.btn_valueAnim_rotate_4, R2.id.btn_valueAnim_scale_4, R2.id.btn_valueAnim_alpha_4, R2.id.btn_valueAnim_all_4,
    })
    public void OnClicks(View view) {
        if (view == btn_valueAnim_trans) {
            ValueAnimator_xml_trans_1();
        } else if (view == btn_valueAnim_rotate) {
            ValueAnimator_xml_rotate_1();
        } else if (view == btn_valueAnim_scale) {
            ValueAnimator_xml_scale_1();
        } else if (view == btn_valueAnim_alpha) {
            ValueAnimator_xml_alpha_1();
        } else if (view == btn_valueAnim_all) {
            ValueAnimator_xml_all_1();
        }
        //
        else if (view == btn_valueAnim_trans_1) {
            ValueAnimator_xml_trans();
        } else if (view == btn_valueAnim_rotate_1) {
            ValueAnimator_xml_rotate();
        } else if (view == btn_valueAnim_scale_1) {
            ValueAnimator_xml_scale();
        } else if (view == btn_valueAnim_alpha_1) {
            ValueAnimator_xml_alpha();
        } else if (view == btn_valueAnim_all_1) {
            ValueAnimator_xml_all();
        }
        //
        else if (view == btn_valueAnim_trans_2) {
            ValueAnimator_code_trans_2();
        } else if (view == btn_valueAnim_rotate_2) {
            ValueAnimator_code_rotate_2();
        } else if (view == btn_valueAnim_scale_2) {
            ValueAnimator_code_scale_2();
        } else if (view == btn_valueAnim_alpha_2) {
            ValueAnimator_code_alpha_2();
        } else if (view == btn_valueAnim_all_2) {
            ValueAnimator_code_all_2();
        }
        //
        if (view == btn_valueAnim_trans_3) {
            ValueAnimator_code_trans_3();
        } else if (view == btn_valueAnim_rotate_3) {
            ValueAnimator_code_rotate_3();
        } else if (view == btn_valueAnim_scale_3) {
            ValueAnimator_code_scale_3();
        } else if (view == btn_valueAnim_all_3) {
            ValueAnimator_code_all_3();
        }
        //
        else if (view == btn_valueAnim_trans_4) {
            ValueAnimator_code_trans_4();
        } else if (view == btn_valueAnim_rotate_4) {
            ValueAnimator_code_rotate_4();
        } else if (view == btn_valueAnim_scale_4) {
            ValueAnimator_code_scale_4();
        } else if (view == btn_valueAnim_alpha_4) {
            ValueAnimator_code_alpha_4();
        } else if (view == btn_valueAnim_all_4) {
            ValueAnimator_code_all_4();
        }

    }

    //===============================================================
    //==================ValueAnimator xml方式示例========================
    //===============================================================

    /**
     * 左右平移+监听
     */
    private void ValueAnimator_xml_trans() {
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_trans_r);
        animator.setTarget(img);//不设置该方法，动画不执行
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if ((Float) animation.getAnimatedValue() == 250f) {//pt_objanimator_trans_r.xml的最终位置值
                    Toast.makeText(PtBaseDemoAct.this, "这是实时监听最后结果的打印", Toast.LENGTH_SHORT).show();
                    ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(PtBaseDemoAct.this, R.animator.pt_objanimator_trans_l);
                    animator.setTarget(img);//不设置该方法，动画不执行
                    animator.start();
                }
            }
        });

    }

    /**
     * 顺时针旋转
     */
    private void ValueAnimator_xml_rotate() {
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_rotation_r);
        animator.setTarget(img);//不设置该方法，动画不执行
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                if ((Float) animation.getAnimatedValue() == 360f) {//pt_objanimator_trans_r.xml的最终位置值
                    Toast.makeText(PtBaseDemoAct.this, "这是实时监听最后结果的打印", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 放大
     */
    private void ValueAnimator_xml_scale() {
        if (type == 0) {
            type++;
            ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_scale_big_x);
            animator.setTarget(img);//不设置该方法，动画不执行
            animator.start();
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {

                    if ((Float) animation.getAnimatedValue() == 2f) {//pt_objanimator_trans_r.xml的最终位置值
                        Toast.makeText(PtBaseDemoAct.this, "放大方式1", Toast.LENGTH_SHORT).show();
                        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(PtBaseDemoAct.this, R.animator.pt_objanimator_scale_big_y);
                        animator.setTarget(img);//不设置该方法，动画不执行
                        animator.start();
                    }
                }
            });
        } else if (type == 1) {
            type++;
            AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_scale_big_xy);
            animator.setTarget(img);//不设置该方法，动画不执行
            animator.start();
        } else {
            type = 0;
        }


    }

    private void ValueAnimator_xml_alpha() {
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_alpha_10);
        animator.setTarget(img);//不设置该方法，动画不执行
        animator.start();

    }

    /**
     *
     */
    private void ValueAnimator_xml_all() {
        AnimatorSet objectAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.pt_set_demo1);//将xml中的动画加载
        objectAnimator.setTarget(img);
        objectAnimator.start();
    }

    //==========================================================

    /**
     * 上下移动+监听
     */
    private void ValueAnimator_xml_trans_1() {
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_trans_up);
        animator.setTarget(img);//不设置该方法，动画不执行
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if ((Float) animation.getAnimatedValue() == -250f) {//pt_objanimator_trans_r.xml的最终位置值
                    Toast.makeText(PtBaseDemoAct.this, "这是实时监听最后结果的打印", Toast.LENGTH_SHORT).show();
                    ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(PtBaseDemoAct.this, R.animator.pt_objanimator_trans_down);
                    animator.setTarget(img);//不设置该方法，动画不执行
                    animator.start();
                }
            }
        });
    }

    private void ValueAnimator_xml_rotate_1() {
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(PtBaseDemoAct.this, R.animator.pt_objanimator_rotation_l);
        animator.setTarget(img);//不设置该方法，动画不执行
        animator.start();
    }

    private void ValueAnimator_xml_scale_1() {
        if (type == 0) {
            type++;
            ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_scale_small_x);
            animator.setTarget(img);//不设置该方法，动画不执行
            animator.start();
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {

                    if ((Float) animation.getAnimatedValue() == 1f) {//pt_objanimator_trans_r.xml的最终位置值
                        Toast.makeText(PtBaseDemoAct.this, "缩小方式1", Toast.LENGTH_SHORT).show();
                        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(PtBaseDemoAct.this, R.animator.pt_objanimator_scale_small_y);
                        animator.setTarget(img);//不设置该方法，动画不执行
                        animator.start();
                    }
                }
            });
        } else if (type == 1) {
            type++;
            AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_scale_small_xy);
            animator.setTarget(img);//不设置该方法，动画不执行
            animator.start();
        } else {
            type = 0;
        }
    }

    private void ValueAnimator_xml_alpha_1() {
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.pt_objanimator_alpha_01);
        animator.setTarget(img);//不设置该方法，动画不执行
        animator.start();
    }

    private void ValueAnimator_xml_all_1() {

    }

    //========================================================================================
    //==================ValueAnimator/ObjectAnimator code方式示例========================
    //========================================================================================


    /**
     * 左右移动 ObjectAnimator.ofFloat
     * <p>
     * <p>
     * imageView中凡是有get，set方法的属性，都可以通过属性动画操作
     * 创建属性动画对象，并设置移动的方向和偏移量
     * translationX是imageview的平移属性
     */
    private void ValueAnimator_code_trans_2() {
        //获取对象方式不是new,而是ofFloat
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "translationX", 0, 250f);
//      设置移动时间
        animator.setDuration(1000);
//      开始动画
        animator.start();
        //监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                if ((Float) animation.getAnimatedValue() == 250f) {
                    Toast.makeText(PtBaseDemoAct.this, "这是实时监听最后结果的打印", Toast.LENGTH_SHORT).show();
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "translationX", 250f, 0f);
                    animator2.setDuration(1000);
                    animator2.setRepeatCount(4);
                    animator2.setRepeatMode(ValueAnimator.REVERSE);
                    animator2.start();
                }
            }
        });
    }

    /**
     * 顺时针旋转 +监听 ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_rotate_2() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
        animator.setDuration(1000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                if ((Float) animation.getAnimatedValue() == 360f) {//如果执行完，就执行下边动画
                    Toast.makeText(PtBaseDemoAct.this, "这是实时监听最后结果的打印", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    /**
     * 放大 ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_scale_2() {
        if (type == 0) {
            type++;
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(img, "scaleX", 0f, 1f, 0.5f, 1f);
            animatorX.setDuration(2000);
            animatorX.start();
            animatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                    if ((Float) animation.getAnimatedValue() == 1f) {//如果执行完，就执行下边动画
                        Toast.makeText(PtBaseDemoAct.this, "方式1：这是x方向放大", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else if (type == 1) {
            type++;
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(img, "scaleY", 0f, 1f);
            animatorY.setDuration(1000);
            animatorY.start();
            animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                    if ((Float) animation.getAnimatedValue() == 1f) {//如果执行完，就执行下边动画
                        Toast.makeText(PtBaseDemoAct.this, "方式2：这是y方向放大", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            type = 0;
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(img, "scaleX", 1f, 2f);
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(img, "scaleY", 1f, 2f);
//            ObjectAnimator animatorY = ObjectAnimator.ofFloat(img, "scaleY", 1f, 2f,3f,4f);
            //组合动画处理
            AnimatorSet set = new AnimatorSet();
            set.setDuration(1000);
            set.play(animatorX).with(animatorY);//同时
            set.start();
            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Toast.makeText(PtBaseDemoAct.this, "方式3：这是组合动画，xy方向同时放大", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

    }

    /**
     * 透明 +监听 ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_alpha_2() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "alpha", 1f, 0.1f, 1f, 0.5f, 1f);
        animator.setDuration(4000);// 动画持续时间
        animator.start();

    }

    /**
     * 综合： ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_all_2() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(img, "translationX", 0f, 250f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(img, "translationY", 0f, 250f);
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(img, "alpha", 1f, 0.2f, 0.4f, 1f);
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(img, "scaleX", 1f, 2f);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(img, "scaleY", 1f, 2f);
        ObjectAnimator animatorRotationS = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
        animatorRotationS.setRepeatCount(1);
        animatorRotationS.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000);
        if (type == 0) {
            type++;
            set.playTogether(animatorX, animatorY, animatorAlpha, animatorScaleX, animatorScaleY, animatorRotationS);
        } else if (type == 1) {
            type++;
            set.play(animatorX).with(animatorRotationS).after(animatorY).after(animatorScaleX).before(animatorScaleY).with(animatorAlpha);
        } else {
            type = 0;
            set.setDuration(4000);
            set.play(animatorRotationS).after(animatorY).after(animatorAlpha).after(animatorScaleX).after(animatorScaleY).after(animatorX);
        }
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (type == 0) {
                    Toast.makeText(PtBaseDemoAct.this, "方式1：综合样式", Toast.LENGTH_SHORT).show();
                } else if (type == 1) {
                    Toast.makeText(PtBaseDemoAct.this, "方式2：综合样式", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PtBaseDemoAct.this, "方式3：综合样式", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }


    //==========================================================

    /**
     * 上下移动+监听 ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_trans_3() {
        //获取对象方式不是new,而是ofFloat
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "translationY", 0, 250f);
//      设置移动时间
        animator.setDuration(1000);
//      开始动画
        animator.start();
        //监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                if ((Float) animation.getAnimatedValue() == 250f) {
                    Toast.makeText(PtBaseDemoAct.this, "这是实时监听最后结果的打印", Toast.LENGTH_SHORT).show();
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "translationY", 250f, 0f);
                    animator2.setDuration(1000);
                    animator2.setRepeatCount(4);
                    animator2.setRepeatMode(ValueAnimator.REVERSE);
                    animator2.start();
                }
            }
        });
    }


    /**
     * 逆时针+监听 ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_rotate_3() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "rotation", 0f, -360f);
        animator.setDuration(300);
        animator.setRepeatCount(5);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                if ((Float) animation.getAnimatedValue() == -360f) {//如果执行完，就执行下边动画
                    Toast.makeText(PtBaseDemoAct.this, "这是实时监听最后结果的打印", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    /**
     * 缩小+监听 ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_scale_3() {
        if (type == 0) {
            type++;
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(img, "scaleX", 3f, 2f);
            animatorX.setDuration(1000);
            animatorX.start();
            animatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                    if ((Float) animation.getAnimatedValue() == 1f) {//如果执行完，就执行下边动画
                        Toast.makeText(PtBaseDemoAct.this, "方式1：这是x方向缩小", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else if (type == 1) {
            type++;
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(img, "scaleY", 3f, 2f);
            animatorY.setDuration(1000);
            animatorY.start();
            animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                    if ((Float) animation.getAnimatedValue() == 1f) {//如果执行完，就执行下边动画
                        Toast.makeText(PtBaseDemoAct.this, "方式2：这是y方向缩小", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            type = 0;
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(img, "scaleX", 2f, 1f);
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(img, "scaleY", 2f, 1f);
            //组合动画处理
            AnimatorSet set = new AnimatorSet();
            set.setDuration(1000);
            set.play(animatorX).with(animatorY);//同时
            set.start();
            animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                    if ((Float) animation.getAnimatedValue() == 1f) {//如果执行完，就执行下边动画
                        Toast.makeText(PtBaseDemoAct.this, "方式3：这是xy方向同时缩小", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    /**
     * 综合样式 ObjectAnimator.ofFloat
     */
    private void ValueAnimator_code_all_3() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(img, "translationX", 250f, 0f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(img, "translationY", 250f, 0f);
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(img, "alpha", 1f, 0.8f, 0.2f, 1f);
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(img, "scaleX", 2f, 1f);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(img, "scaleY", 2f, 1f);
        ObjectAnimator animatorRotationS = ObjectAnimator.ofFloat(img, "rotation", 0f, -360f);
        animatorRotationS.setRepeatCount(1);
        animatorRotationS.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(2200);
        if (type == 0) {
            type++;
            set.playTogether(animatorX, animatorY, animatorAlpha, animatorScaleX, animatorScaleY, animatorRotationS);
        } else if (type == 1) {
            type++;
            set.play(animatorX).with(animatorAlpha).after(animatorY).after(animatorScaleX).before(animatorScaleY).with(animatorRotationS);
        } else {
            type = 0;
            set.setDuration(4000);
            set.play(animatorX).after(animatorY).after(animatorAlpha).after(animatorScaleX).after(animatorScaleY).after(animatorRotationS);
        }
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (type == 0) {
                    Toast.makeText(PtBaseDemoAct.this, "方式1：综合样式", Toast.LENGTH_SHORT).show();
                } else if (type == 1) {
                    Toast.makeText(PtBaseDemoAct.this, "方式2：综合样式", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PtBaseDemoAct.this, "方式3：综合样式", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //==========================================================================================
    //============================PropertyValuesHolder+ObjectAnimator实现================================
    //==========================================================================================

    /**
     * 移动 PropertyValuesHolder+ObjectAnimator
     */
    private void ValueAnimator_code_trans_4() {
        if (type == 0) {
            PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("translationX", 0, 250f);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holder);
            animator.setDuration(1000);
            animator.start();
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                    if ((Float) animation.getAnimatedValue() == 250f) {
                        Toast.makeText(PtBaseDemoAct.this, "方式1：单独播放PropertyValuesHolder动画", Toast.LENGTH_SHORT).show();
                        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("translationX", 250f, 0f);
                        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(img, holder2);
                        animator2.setDuration(500);
                        animator2.start();
                    }
                }
            });
            type++;
        } else if (type == 1) {
            type = 0;
            PropertyValuesHolder holderX = PropertyValuesHolder.ofFloat("translationX", 0, 250f, 0);
            PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat("translationY", 0, -250f, 0);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holderX, holderY);
            animator.setDuration(500);
            animator.start();
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Toast.makeText(PtBaseDemoAct.this, "方式2：PropertyValuesHolder动画并行播放", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }


    }

    /**
     * 旋转 PropertyValuesHolder+ObjectAnimator
     */
    private void ValueAnimator_code_rotate_4() {
        if (type == 0) {
            PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("rotation", 0, 360f);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holder);
            animator.setDuration(1000);
            animator.start();
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                    if ((Float) animation.getAnimatedValue() == 360f) {
                        Toast.makeText(PtBaseDemoAct.this, "方式1：单独播放PropertyValuesHolder动画", Toast.LENGTH_SHORT).show();
                        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("rotation", 0f, -360f);
                        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(img, holder2);
                        animator2.setDuration(500);
                        animator2.start();
                    }
                }
            });
            type++;
        } else if (type == 1) {
            type = 0;
            /**
             * 执行PropertyName相同时，以最后位置的动画执行
             */
            PropertyValuesHolder holderX = PropertyValuesHolder.ofFloat("rotation", 0, 480f, 0);
            PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat("rotation", 0, -480f, 0);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holderX, holderY);
            animator.setDuration(1000);
            animator.start();
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Toast.makeText(PtBaseDemoAct.this, "方式2：PropertyValuesHolder动画并行播放", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

    }

    /**
     * 缩放 PropertyValuesHolder+ObjectAnimator
     */

    private void ValueAnimator_code_scale_4() {

        PropertyValuesHolder holderX = PropertyValuesHolder.ofFloat("scaleX", 1f, 3f);
        PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat("scaleY", 1f, 3f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holderX, holderY);
        animator.setDuration(1000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //animation.getAnimatedValue()的值是动态变化的，所以只监听结果
                if ((Float) animation.getAnimatedValue() == 3f) {
                    Toast.makeText(PtBaseDemoAct.this, "方式1：单独播放PropertyValuesHolder动画", Toast.LENGTH_SHORT).show();
                    PropertyValuesHolder holderX = PropertyValuesHolder.ofFloat("scaleX", 3f, 1f);
                    PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat("scaleY", 3f, 1f);
                    ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(img, holderX, holderY);
                    ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holderX, holderY);
                    animator2.setDuration(500);
                    animator2.start();
                }
            }
        });
    }

    /**
     * 透明 +监听  PropertyValuesHolder+ObjectAnimator
     */
    private void ValueAnimator_code_alpha_4() {
        PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 0.2f, 0.8f, 0f, 1f);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(img, holder, holder);
        animator.setDuration(4000);// 动画持续时间
        animator.start();

    }

    /**
     * 综合：PropertyValuesHolder+ObjectAnimator
     */
    private void ValueAnimator_code_all_4() {
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
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(PtBaseDemoAct.this, "PropertyValuesHolder+ObjectAnimator综合样式", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


}
