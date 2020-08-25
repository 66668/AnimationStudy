package lib.property.anim;

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

/**
 * 属性动画 主界面
 */
public class PTMainAct extends AppCompatActivity {

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
        tv_title.setText("Property Animation属性动画详解");
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("属性动画 代替补间 简单示例");
        data.add("特有效果 简单示例");
        data.add("插值器（包括自定义）示例");
        data.add("估值器TypeEvaluator 简单示例");
        data.add("应用中 好的动画切换 实例1");

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
                        Toast.makeText(PTMainAct.this, "未做", Toast.LENGTH_SHORT).show();
//                        startToDemo2();
                        break;
                    case 2:
                        Toast.makeText(PTMainAct.this, "未做", Toast.LENGTH_SHORT).show();
//                        startToDemo3();
                        break;
                    case 3:
//                        startToDemo4();
                        Toast.makeText(PTMainAct.this, "未做", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        startToDemo5();
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        Toast.makeText(PTMainAct.this, str + pos, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    //
    private void startToDemo1() {
        Intent intent = new Intent(this, PtBaseDemoAct.class);
        startActivity(intent);
    }

    private void startToDemo2() {
        Intent intent = new Intent(this, PtSpDemo1Act.class);
        startActivity(intent);
    }

    private void startToDemo3() {
        Intent intent = new Intent(this, InterpolatorAct.class);
        startActivity(intent);
    }

    private void startToDemo4() {
        Intent intent = new Intent(this, Demo5Act.class);
        startActivity(intent);
    }

    private void startToDemo5() {
        Intent intent = new Intent(this, Demo5Act.class);
        startActivity(intent);
    }


}
