package lib.anim.transition;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lib.anim.transition.demo1.Trans1Act;
import lib.anim.transition.demo2.Demo2MainAct;
import lib.anim.transition.demo3.Demo3MainAct;
import lib.anim.transition.demo4.SEDemo4Act1;
import lib.anim.transition.demo5.SEFragMainAct;
import lib.anim.transition.demo6.BaseFragMainAct;
import lib.base.sjy.adpater.MainAdapter;

/**
 * 转场动画
 */
public class TransMainAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    RecyclerView recyclerView;
    TextView tv_title;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        recyclerView = findViewById(R.id.recyclerView);
        tv_title = findViewById(R.id.tv_titile);
        tv_title.setText("转场动画 演示demo");
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("Act切换动画-方式1：overridePendingTransition");
        data.add("Act切换动画-方式2：sytle-windowAnimationStyle");
        data.add("Act切换动画-方式3:android.transition包支持");
        data.add("共享元素（sharedElement）--Act示例");
        data.add("共享元素（sharedElement）--Fragment示例");
        data.add("基础Fragment示例");
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
                        startToTrans1();
                        break;
                    case 1:
                        startToStyle2();
                        break;
                    case 2:
                        startToTrans_demo3();
                        break;
                    case 3:
                        actSharedElement();
                        break;
                    case 4:
                        frgSharedElement();
                        break;
                    case 5:
                        baseFragment();
                        break;
                    case 6:
                    case 7:
                    case 8:
                        Toast.makeText(TransMainAct.this, str + pos, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void startToTrans1() {
        Intent intent = new Intent(TransMainAct.this, Trans1Act.class);
        startActivity(intent);
    }

    /**
     *
     */
    private void startToStyle2() {
        Intent intent = new Intent(TransMainAct.this, Demo2MainAct.class);
        startActivity(intent);
    }

    private void startToTrans_demo3() {
        Intent intent = new Intent(TransMainAct.this, Demo3MainAct.class);
        startActivity(intent);
    }


    /**
     * Act间共享元素
     */
    private void actSharedElement() {
        Intent intent = new Intent(TransMainAct.this, SEDemo4Act1.class);
        startActivity(intent);
    }

    /**
     * Act-Frag间共享元素
     */
    private void frgSharedElement() {
//        Toast.makeText(TransMainAct.this, "未做", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TransMainAct.this, SEFragMainAct.class);
        startActivity(intent);
    }
    /**
     * Act-Frag间共享元素
     */
    private void baseFragment() {
//        Toast.makeText(TransMainAct.this, "未做", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TransMainAct.this, BaseFragMainAct.class);
        startActivity(intent);
    }
}
