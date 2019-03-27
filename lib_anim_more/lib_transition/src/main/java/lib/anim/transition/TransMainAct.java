package lib.anim.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.anim.transition.demo1.Trans1Act;
import lib.anim.transition.demo3.Demo3StyleAct;
import lib.anim.transition.demo3.Demo3codeAct;
import lib.anim.transition.demo3.Demo3xmlAct;
import lib.anim.transition.demo4.SEDemo4Act1;
import lib.base.sjy.adpater.MainAdapter;

/**
 * 转场动画
 */
public class TransMainAct extends AppCompatActivity {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        tv_title.setText("转场动画 演示demo");
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("Act切换动画-方式1：overridePendingTransition");
        data.add("Act切换动画-方式2：sytle-windowAnimationStyle");
        data.add("Act切换动画-方式3-1--sytle方式--windowContentTransitions");
        data.add("Act切换动画-方式3-2--xml方式");
        data.add("Act切换动画-方式3-3--code方式");
        data.add("Act间共享元素（sharedElement）");
        data.add("Fragment间共享元素（sharedElement）");
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
                        startToTrans_style();
                        break;
                    case 3:
                        startToTrans_xml();
                        break;
                    case 4:
                        startToTrans_code();
                        break;
                    case 5:
                        actSharedElement();
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

    private void startToStyle2() {
        Intent intent = new Intent(TransMainAct.this, Demo2MainAct.class);
        startActivity(intent);
    }

    private void startToTrans_style() {
        Intent intent = new Intent(TransMainAct.this, Demo3StyleAct.class);
        startActivity(intent);
    }

    private void startToTrans_xml() {
        Intent intent = new Intent(TransMainAct.this, Demo3xmlAct.class);
        startActivity(intent);
    }

    private void startToTrans_code() {
        Intent intent = new Intent(TransMainAct.this, Demo3codeAct.class);
        startActivity(intent);
    }

    private void actSharedElement() {
        Intent intent = new Intent(TransMainAct.this, SEDemo4Act1.class);
        startActivity(intent);
    }

    private void frgSharedElement() {
        Intent intent = new Intent(TransMainAct.this, SEDemo4Act1.class);
        startActivity(intent);
    }
}
