package lib.circular.reveal.demo1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import lib.circular.reveal.R;


public class Demo1_LayoutRevealAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    Toolbar toolbar;


    FloatingActionButton fab;

    View mPuppet;

    //-------------------------------------------------------------
    boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_layout_demo1);
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);
        mPuppet = findViewById(R.id.view_puppet);
        initToolbar();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRevealAnimation();
            }
        });

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void doRevealAnimation() {
        int[] vLocation = new int[2];
        fab.getLocationInWindow(vLocation);
        int centerX = vLocation[0] + fab.getMeasuredWidth() / 2;
        int centerY = vLocation[1] + fab.getMeasuredHeight() / 2;

        int height = mPuppet.getHeight();
        int width = mPuppet.getWidth();

        //类似直角三角形求斜边长度
        int maxRradius = (int) Math.hypot(height, width);
        Log.e("SJY", maxRradius + "");

        if (flag) {//隐藏
            Animator animator = ViewAnimationUtils.createCircularReveal(mPuppet, centerX, centerY, maxRradius, 0);
            animator.setDuration(500);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mPuppet.setVisibility(View.GONE);
                }
            });
            animator.start();
            flag = false;
        } else {//可见
            Animator animator = ViewAnimationUtils.createCircularReveal(mPuppet, centerX, centerY, 0, maxRradius);
            animator.setDuration(300);
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    mPuppet.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animator.start();
            flag = true;
        }
    }


}
