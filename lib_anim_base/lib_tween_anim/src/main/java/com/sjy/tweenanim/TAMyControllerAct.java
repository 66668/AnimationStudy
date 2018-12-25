package com.sjy.tweenanim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * LayoutController
 */
public class TAMyControllerAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------

    @BindView(R2.id.floatingActionButton)
    FloatingActionButton floatingActionButton;


    @BindView(R2.id.linear_container)
    LinearLayout linearLayout;

    @BindView(R2.id.img1)
    ImageView img1;


    //-------------------------------------------------------------

    /**
     * 判断处理view的展开还是关闭
     */
    private boolean tripFlag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_controller2);
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.floatingActionButton, R2.id.img1, R2.id.linear_container})
    public void onClicks(View view) {
        if (view == floatingActionButton) {
            if (tripFlag) {
                //创建一个LayoutAnimationController对象
                LayoutAnimationController controller =
                        new LayoutAnimationController(AnimationUtils.loadAnimation(getApplication(), R.anim.bottom_out));
                //设置Order顺序
                controller.setOrder(LayoutAnimationController.ORDER_REVERSE);
                //将controller赋值给view group
                linearLayout.setLayoutAnimation(controller);
                //开启动画
                linearLayout.startLayoutAnimation();
                tripFlag = false;
            } else {
                linearLayout.setVisibility(View.VISIBLE);
                LayoutAnimationController controller =
                        new LayoutAnimationController(AnimationUtils.loadAnimation(getApplication(), R.anim.bottom_in));
                linearLayout.setLayoutAnimation(controller);
                linearLayout.startLayoutAnimation();
                tripFlag = true;
            }
        } else if (img1 == view || linearLayout == view) {
            Toast.makeText(TAMyControllerAct.this, "动画隐藏，但是仍可以点击", Toast.LENGTH_SHORT).show();

        }
    }


}
