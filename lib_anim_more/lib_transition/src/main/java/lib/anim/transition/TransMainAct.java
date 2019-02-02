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
import lib.anim.transition.transdemo.Trans1Act;
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
                        startToStyle();
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

    private void startToStyle() {
        Intent intent = new Intent(TransMainAct.this, StyleMainAct.class);
        startActivity(intent);
    }

    private void startToProperty() {
//        Intent intent = new Intent(MainAct.this, MainAct.class);
//        startActivity(intent);
    }

    private void startToRippleEffect() {
//        Intent intent = new Intent(MainAct.this, REMainActivity.class);
//        startActivity(intent);
    }

    private void startToReveal() {
//        Intent intent = new Intent(MainAct.this, CRMainAct.class);
//        startActivity(intent);
    }

    private void startToViewStateChange() {
//        Intent intent = new Intent(MainAct.this, VSCMainAct.class);
//        startActivity(intent);
    }
}
