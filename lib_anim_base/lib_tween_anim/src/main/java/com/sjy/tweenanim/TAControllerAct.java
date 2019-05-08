package com.sjy.tweenanim;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.sjy.tweenanim.adpater.GridAdapter;

import java.util.ArrayList;
import java.util.List;

import lib.base.sjy.adpater.MainAdapter;

/**
 * LayoutController
 */
public class TAControllerAct extends AppCompatActivity implements View.OnClickListener{

    //-----------------------------控件--------------------------------

    Button btn_recylcerView;

    Button btn_recylcerView2;

    RecyclerView recyclerView;

    GridView gridView;


    //-------------------------------------------------------------
    private PopupWindow mImgPopupWindow;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_controller);
        btn_recylcerView = findViewById(R.id.btn_recylcerView);
        btn_recylcerView2 = findViewById(R.id.btn_recylcerView2);
        recyclerView = findViewById(R.id.recyclerView);
        gridView = findViewById(R.id.gridView);

        btn_recylcerView.setOnClickListener(this);
        btn_recylcerView2.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == btn_recylcerView) {
            recyclerView.setVisibility(View.VISIBLE);
            gridView.setVisibility(View.GONE);
            if (count == 0) {
                Toast.makeText(TAControllerAct.this,"样式1",Toast.LENGTH_SHORT).show();
                myLayoutAnimationController1();
                count++;
            } else if (count == 1) {
                Toast.makeText(TAControllerAct.this,"样式2",Toast.LENGTH_SHORT).show();
                myLayoutAnimationController2();
                count++;
            } else {
                Toast.makeText(TAControllerAct.this,"样式3",Toast.LENGTH_SHORT).show();
                myLayoutAnimationController3();
                count = 0;
            }
        } else if (view == btn_recylcerView2) {
            recyclerView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
            if (count == 0) {
                myGridLayoutAnimationController1();
                count++;
            } else if (count == 1) {
                myGridLayoutAnimationController2();
                count++;
            } else {
                myGridLayoutAnimationController3();
                count = 0;
            }
        }
    }

    /**
     * xml方式
     */
    private void myLayoutAnimationController1() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = recyclerView.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                recyclerView.clearAnimation();
            }
        }
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            data.add("xxx" + i);
        }
        MainAdapter adapter = new MainAdapter(this);
        adapter.setDatas(data);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    /**
     * xml+code方式
     */
    private void myLayoutAnimationController2() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = recyclerView.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                recyclerView.clearAnimation();
            }
        }
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            data.add("zzzz" + i);
        }
        MainAdapter adapter = new MainAdapter(this);
        adapter.setDatas(data);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);

        //code引用自定义LayoutAnimationController
        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.controller_layout_anim);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.startLayoutAnimation();
        recyclerView.setAdapter(adapter);

    }

    /**
     * code方式
     */
    @SuppressLint("ResourceType")
    private void myLayoutAnimationController3() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = recyclerView.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                recyclerView.clearAnimation();
            }
        }
        List<String> data = new ArrayList<>();

        data = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            data.add("ccc" + i);
        }
        MainAdapter adapter = new MainAdapter(this);
        adapter.setDatas(data);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);

        //
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.right_in);//right_in /style_popwindow_enter
        //绑定动画
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.2f);
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
//        controller.setInterpolator(this, R.anim.my_accelerate_interpolator);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.startLayoutAnimation();
        recyclerView.setAdapter(adapter);
    }

    /**
     * xml调用
     */
    private void myGridLayoutAnimationController1() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = gridView.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                gridView.clearAnimation();
            }
        }

        List<String> data = new ArrayList<>();
        data = new ArrayList<>();
        for (int i = 0; i < 38; i++) {
            data.add("ccc" + i);
        }
        GridAdapter adapter = new GridAdapter(this, data);
        gridView.setAdapter(adapter);
    }

    /**
     * xml+code
     */
    private void myGridLayoutAnimationController2() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = gridView.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                gridView.clearAnimation();
            }
        }
        //code引用自定义GridLayoutAnimationController
        GridLayoutAnimationController controller = (GridLayoutAnimationController) AnimationUtils.loadLayoutAnimation(this, R.anim.controller_grid_layout_anim);
        gridView.setLayoutAnimation(controller);
        gridView.startLayoutAnimation();
        List<String> data = new ArrayList<>();
        data = new ArrayList<>();
        for (int i = 0; i < 38; i++) {
            data.add("aaa" + i);
        }
        GridAdapter adapter = new GridAdapter(this, data);
        gridView.setAdapter(adapter);

    }

    /**
     * code调用
     */
    private void myGridLayoutAnimationController3() {
        //清除之前动画没执行完的影响
        Animation oldAnimation = gridView.getAnimation();
        if (oldAnimation != null) {
            if (oldAnimation.hasStarted() || (!oldAnimation.hasEnded())) {
                oldAnimation.cancel();
                gridView.clearAnimation();
            }
        }
        //
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.style_popwindow_enter);
        //绑定动画
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation);
        controller.setDelay(0.2f);
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        controller.setColumnDelay(0.1f);
        controller.setRowDelay(0.2f);
        controller.setDirection(GridLayoutAnimationController.DIRECTION_LEFT_TO_RIGHT |
                GridLayoutAnimationController.DIRECTION_TOP_TO_BOTTOM);
        controller.setDirectionPriority(GridLayoutAnimationController.PRIORITY_COLUMN);
        gridView.setLayoutAnimation(controller);
        gridView.startLayoutAnimation();

        List<String> data = new ArrayList<>();
        data = new ArrayList<>();
        for (int i = 0; i < 58; i++) {
            data.add("aaa" + i);
        }
        GridAdapter adapter = new GridAdapter(this, data);
        gridView.setAdapter(adapter);

    }


}
