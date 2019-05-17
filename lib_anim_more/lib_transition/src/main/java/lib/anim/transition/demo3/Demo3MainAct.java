package lib.anim.transition.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import lib.anim.transition.R;
import lib.anim.transition.TransMainAct;
import lib.anim.transition.demo2.DemoAlphaAct;
import lib.anim.transition.demo2.DemoBottomAct;
import lib.anim.transition.demo4.SEDemo4Act1;
import lib.base.sjy.adpater.MainAdapter;

/**
 * 转场动画 主界面
 */
public class Demo3MainAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------


    RecyclerView recyclerView;

    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;
    private int type = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo3);
        recyclerView = findViewById(R.id.recyclerView);
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("Explode--code方式");
        data.add("Explode--xml方式");
        data.add("Slide--code方式");
        data.add("Slide--xml方式");
        data.add("sytle方式--windowContentTransitions");
        data.add("xml方式(2)");
        data.add("code方式(2)");
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
                        Intent expoldeCodeIntent = new Intent(Demo3MainAct.this, ExplodeDemoAct.class);
                        //设置code
                        expoldeCodeIntent.putExtra("type", "code");
                        startActivity(expoldeCodeIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(Demo3MainAct.this).toBundle());
                        break;
                    case 1:
                        Intent expoldexmlIntent = new Intent(Demo3MainAct.this, ExplodeDemoAct.class);
                        //设置xml
                        expoldexmlIntent.putExtra("type", "xml");
                        startActivity(expoldexmlIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(Demo3MainAct.this).toBundle());
                        break;
                    case 2:
                        Intent slideCodeIntent = new Intent(Demo3MainAct.this, SlideDemoAct.class);
                        //设置code
                        slideCodeIntent.putExtra("type", "code");
                        startActivity(slideCodeIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(Demo3MainAct.this).toBundle());
                        break;
                    case 3:
                        Intent slidexmlIntent = new Intent(Demo3MainAct.this, SlideDemoAct.class);
                        //设置xml
                        slidexmlIntent.putExtra("type", "xml");
                        startActivity(slidexmlIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(Demo3MainAct.this).toBundle());
                        break;
                    case 4:
                        startToTrans_style();
                        break;
                    case 5:
                        startToTrans_xml();
                        break;
                    case 6:
                        startToTrans_code();
                        break;
                    case 7:
                        break;
                }
            }
        });
    }

    /**
     * style方式
     */
    private void startToTrans_style() {
        Intent intent = new Intent(Demo3MainAct.this, Demo3StyleAct.class);
        startActivity(intent);
    }

    /**
     * xml方式
     */
    private void startToTrans_xml() {
        Intent intent = new Intent(Demo3MainAct.this, Demo3xmlAct.class);
        startActivity(intent);
    }

    /**
     * code方式
     */
    private void startToTrans_code() {
        Intent intent = new Intent(Demo3MainAct.this, Demo3codeAct.class);
        startActivity(intent);
    }
}
