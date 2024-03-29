package lib.circular.reveal.demo1;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import lib.circular.reveal.R;

/**
 * demo1: appbarlayout使用reveal
 */
public class Demo1_AppbarRevealAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    FloatingActionButton btn;
    //
    ImageView img;
    //
    Toolbar toolbar;
    //
    CollapsingToolbarLayout toolbar_layout;

    //-------------------------------------------------------------
    boolean isImagVisible;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_appbar_demo1);
        btn = findViewById(R.id.fab);
        img = findViewById(R.id.view_puppet);
        toolbar = findViewById(R.id.toolbar);
        toolbar_layout = findViewById(R.id.toolbar_layout);
        initView();
    }

    private void initView() {
        //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        isImagVisible = img.getVisibility() == View.VISIBLE;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRevealAnim();
            }
        });
    }


    //toobar的menu设置
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo1_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home) {
            finish();
        } else if (i == R.id.demo_item1) {

            startActivity(new Intent(Demo1_AppbarRevealAct.this, Demo1_LayoutRevealAct.class));
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 揭露动画核心
     */

    private void launchRevealAnim() {
        Animation imgAnim = img.getAnimation();
        if (imgAnim != null) {
            imgAnim.cancel();
        }

        int[] vLocation = new int[2];
        btn.getLocationInWindow(vLocation);
        //参数x y位置
        int centerX = vLocation[0] + btn.getWidth() / 2;
        int centerY = vLocation[1] + btn.getHeight() / 2;
        //参数 半径
        int radius = (int) Math.hypot(toolbar_layout.getWidth(), toolbar_layout.getHeight());

        if (isImagVisible) {//如果img可见，则隐藏操作
            final Animator hideAnim = ViewAnimationUtils.createCircularReveal(img, centerX, centerY, radius, 0);
            hideAnim.setDuration(500);
            hideAnim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    img.setVisibility(View.GONE);
                    hideAnim.removeListener(this);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            hideAnim.start();
            isImagVisible = false;
        } else {
            final Animator visibleAnim = ViewAnimationUtils.createCircularReveal(img, centerX, centerY, 0, radius);
            visibleAnim.setDuration(500);
            visibleAnim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    visibleAnim.removeListener(this);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            img.setVisibility(View.VISIBLE);
            visibleAnim.start();
            isImagVisible = true;
        }
    }


}
