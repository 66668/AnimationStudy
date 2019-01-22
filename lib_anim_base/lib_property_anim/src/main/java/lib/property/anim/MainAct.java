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

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.base.sjy.adpater.MainAdapter;

public class MainAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R2.id.tv_titile)
    TextView tv_title;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
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
//                        startToDemo4();
                        Toast.makeText(MainAct.this, "未做", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainAct.this, str + pos, Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, Demo3Act.class);
        startActivity(intent);
    }


}
