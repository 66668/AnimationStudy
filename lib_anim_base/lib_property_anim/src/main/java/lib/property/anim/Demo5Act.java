package lib.property.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 应用中好的动画切换 实例1
 */
public class Demo5Act extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    ImageView login_bg_image1;
    ImageView login_bg_image2;

    //-------------------------------------------------------------
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo5);
        login_bg_image1 = findViewById(R.id.login_bg_image1);
        login_bg_image2 = findViewById(R.id.login_bg_image2);
        initAnimateView();
    }

    private void initAnimateView() {
        Log.d("SJY", "开始动画");
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(login_bg_image1, "alpha", 1.0f, 0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(login_bg_image2, "alpha", 0f, 1.0f);
        ObjectAnimator animatorScale1 = ObjectAnimator.ofFloat(login_bg_image1, "scaleX", 1.0f, 1.3f);
        ObjectAnimator animatorScale2 = ObjectAnimator.ofFloat(login_bg_image1, "scaleY", 1.0f, 1.3f);
        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.setDuration(5000);
        animatorSet1.play(animator1).with(animator2).with(animatorScale1).with(animatorScale2);
        animatorSet1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {


            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // 放大的View复位
                login_bg_image1.setScaleX(1.0f);
                login_bg_image1.setScaleY(1.0f);
            }


            @Override
            public void onAnimationCancel(Animator animation) {


            }


            @Override
            public void onAnimationRepeat(Animator animation) {


            }
        });
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(login_bg_image2, "alpha", 1.0f, 0f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(login_bg_image1, "alpha", 0f, 1.0f);
        ObjectAnimator animatorScale3 = ObjectAnimator.ofFloat(login_bg_image2, "scaleX", 1.0f, 1.3f);
        ObjectAnimator animatorScale4 = ObjectAnimator.ofFloat(login_bg_image2, "scaleY", 1.0f, 1.3f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(5000);
        //执行流程
        animatorSet2.play(animator3).with(animator4).with(animatorScale3).with(animatorScale4);
        animatorSet2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {


            }


            @Override
            public void onAnimationEnd(Animator animation) {
                // 放大的View复位
                login_bg_image2.setScaleX(1.0f);
                login_bg_image2.setScaleY(1.0f);
            }


            @Override
            public void onAnimationCancel(Animator animation) {


            }


            @Override
            public void onAnimationRepeat(Animator animation) {


            }
        });


        animatorSet = new AnimatorSet();
        //加入两个animatorSet
        animatorSet.playSequentially(animatorSet1, animatorSet2);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }


            @Override
            public void onAnimationEnd(Animator animation) {
                // 循环播放
                animation.start();
            }


            @Override
            public void onAnimationCancel(Animator animation) {

            }


            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        //开始执行
        animatorSet.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SJY", "onPause");
        animatorSet.cancel();
    }

}
