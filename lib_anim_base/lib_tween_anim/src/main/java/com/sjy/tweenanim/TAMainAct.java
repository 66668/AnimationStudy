package com.sjy.tweenanim;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lib.base.sjy.adpater.MainAdapter;


public class TAMainAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    RecyclerView recyclerView;

    TextView tv_title;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        recyclerView = findViewById(R.id.recyclerView);
        tv_title = findViewById(R.id.tv_titile);
        tv_title.setText("Tween Animation示例介绍");
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("xml方式1：正常控件");
        data.add("code方式1：正常控件");
        data.add("插值器1：xml详解");
        data.add("插值器2：code详解");
        data.add("插值器3：自定义详解");
        data.add("style动画样式");
        data.add("Grid/LayoutAnimationController详解");
        data.add("LayoutAnimationController详解2");

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
                        startToVAxmlAct();
                        break;
                    case 1:
                        startToVAcodeAct();
                        break;
                    case 2:
                        startToVAInterpolator();
                        break;
                    case 3:
                        startToTAInterpolatorCodeAct();
                        break;
                    case 4:
                        startToTAMyInterpolatorAct();
                        break;
                    case 5:
                        startToTAStyleAct();
                        break;
                    case 6:
                        startToTAControllerAct();
                        break;
                    case 7:
                        startToTAControllerAct2();
                        break;
                    case 8:
                        Toast.makeText(TAMainAct.this, str + pos, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    //
    private void startToVAxmlAct() {
        Intent intent = new Intent(TAMainAct.this, TAxmlAct.class);
        startActivity(intent);
    }

    //
    private void startToVAcodeAct() {
        Intent intent = new Intent(TAMainAct.this, TAcodeAct.class);
        startActivity(intent);
    }

    //
    private void startToVAInterpolator() {
        Intent intent = new Intent(TAMainAct.this, TAInterpolatorxmlAct.class);
        startActivity(intent);
    }

    //
    private void startToTAInterpolatorCodeAct() {
        Intent intent = new Intent(TAMainAct.this, TAInterpolatorCodeAct.class);
        startActivity(intent);
    }

    //
    private void startToTAMyInterpolatorAct() {
        Intent intent = new Intent(TAMainAct.this, TAMyInterpolatorAct.class);
        startActivity(intent);
    }

    //
    private void startToTAStyleAct() {
        Intent intent = new Intent(TAMainAct.this, TAStyleAct.class);
        startActivity(intent);
    } //

    private void startToTAControllerAct() {
        Intent intent = new Intent(TAMainAct.this, TAControllerAct.class);
        startActivity(intent);
    }

    private void startToTAControllerAct2() {
        Intent intent = new Intent(TAMainAct.this, TAMyControllerAct.class);
        startActivity(intent);
    }

}
