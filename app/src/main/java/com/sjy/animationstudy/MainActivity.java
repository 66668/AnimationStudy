package com.sjy.animationstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.base.sjy.adpater.MainAdapter;
import lib.property.anim.MainAct;
import lib.ripple.effect.REMainActivity;
import lib.sjy.frame.FrameAnimActivity;

import com.sjy.tweenanim.TAMainAct;

public class MainActivity extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("01-Tween Animation(补间动画)");
        data.add("02-Frame/Drawable Animation（帧动画）");
        data.add("03-Propety(属性动画)");
        data.add("04-触摸反馈动画（Ripple Effect）");
//        data.add("05-揭露动画（Reveal Effect）");
//        data.add("06-转场动画 & 共享元素（Activity 切换动画）");
//        data.add("07-视图状态动画（Animate View State Changes）");
//        data.add("08-矢量图动画（Vector 动画）");
//        data.add("09-约束布局实现的关键帧动画（ConstraintSet 动画）");
        //
        adapter = new MainAdapter(this);
        adapter.setDatas(data);
        //
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        //
        recyclerView.setAdapter(adapter);
        //

        adapter.setListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String str, int pos) {

                switch (pos) {
                    case 0:
                        startToVA();
                        break;
                    case 1:
                        startToFrame();
                        break;
                    case 2:
                        startToProperty();
                        break;
                    case 3:
                        startToRippleEffect();
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        Toast.makeText(MainActivity.this, str + pos, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void startToVA() {
        Intent intent = new Intent(MainActivity.this, TAMainAct.class);
        startActivity(intent);
    }

    private void startToFrame() {
        Intent intent = new Intent(MainActivity.this, FrameAnimActivity.class);
        startActivity(intent);
    }

    private void startToProperty() {
        Intent intent = new Intent(MainActivity.this, MainAct.class);
        startActivity(intent);
    }
    private void startToRippleEffect() {
        Intent intent = new Intent(MainActivity.this, REMainActivity.class);
        startActivity(intent);
    }
}
