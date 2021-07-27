package lib.property.anim;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lib.base.sjy.adpater.MainAdapter;

/**
 * TODO  未做
 * 属性动画 特有动画效果
 */
public class PtSpecialMainAct extends AppCompatActivity {
    public static final String TAG = "SJY";

    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    RecyclerView recyclerView;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        recyclerView = findViewById(R.id.recyclerView);
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("特殊propertyName 简单示例");

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
                        startToDemo1();
                        break;
                    case 1:
                        startToDemo2();
                        break;
                    case 2:
                        startToDemo3();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        Toast.makeText(PtSpecialMainAct.this, str + pos, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    //
    private void startToDemo1() {
//        Intent intent = new Intent(this, PtBaseDemoAct.class);
//        startActivity(intent);
    }

    private void startToDemo2() {
        Intent intent = new Intent(this, Demo3Act.class);
        startActivity(intent);
    }

    private void startToDemo3() {
        Intent intent = new Intent(this, Demo3Act.class);
        startActivity(intent);
    }
}
