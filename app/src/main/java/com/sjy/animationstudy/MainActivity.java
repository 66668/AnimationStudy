package com.sjy.animationstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sjy.tweenanim.TAMainAct;

import java.util.ArrayList;
import java.util.List;

import lib.anim.transition.TransMainAct;
import lib.base.sjy.adpater.MainAdapter;
import lib.circular.reveal.CRMainAct;
import lib.property.anim.PTMainAct;
import lib.ripple.effect.REMainActivity;
import lib.sjy.frame.FrameAnimActivity;
import lib.view.state.changes.VSCMainAct;

public class MainActivity extends BaseAct {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
   private RecyclerView recyclerView;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        recyclerView = findViewById(R.id.recyclerView);
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("01-补间动画(Tween Animation)");
        data.add("02-帧动画（Frame/Drawable Animation）");
        data.add("03-属性动画(Propety Animation)");
        data.add("04-触摸反馈动画（Ripple Effect）");
        data.add("05-揭露动画（Reveal Effect）");
        data.add("06-视图状态动画（View State Changes）");
        data.add("07-转场动画 & 共享元素（Activity 切换动画）");
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
                        startToReveal();
                        break;
                    case 5:
                        startToViewStateChange();
                        break;
                    case 6:
                        startToTrans();
                        break;
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
        Intent intent = new Intent(MainActivity.this, PTMainAct.class);
        startActivity(intent);
    }

    private void startToRippleEffect() {
        Intent intent = new Intent(MainActivity.this, REMainActivity.class);
        startActivity(intent);
    }

    private void startToReveal() {
        Intent intent = new Intent(MainActivity.this, CRMainAct.class);
        startActivity(intent);
    }

    private void startToViewStateChange() {
        Intent intent = new Intent(MainActivity.this, VSCMainAct.class);
        startActivity(intent);
    }

    private void startToTrans() {
        Intent intent = new Intent(MainActivity.this, TransMainAct.class);
        startActivity(intent);
    }
}
