package lib.anim.transition.styledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.anim.transition.R;
import lib.anim.transition.R2;
import lib.base.sjy.adpater.MainAdapter;

/**
 * style样式
 */
public class StyleMainAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------


    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;
    private int type = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_style1);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("style样式-left-in-out");
        data.add("style样式-right-in-out");
        data.add("style样式-top-in-out");
        data.add("style样式-down-in-out");
        data.add("style样式-alpha-in-out");
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
                        startActivity(new Intent(StyleMainAct.this, DemoLeftAct.class));
                        overridePendingTransition(0,0);
                        break;
                    case 1:
                        startActivity(new Intent(StyleMainAct.this, DemoRightAct.class));
                        break;
                    case 2:
                        startActivity(new Intent(StyleMainAct.this, DemoTopAct.class));
                        break;
                    case 3:
                        startActivity(new Intent(StyleMainAct.this, DemoBottomAct.class));
                        break;
                    case 4:
                        startActivity(new Intent(StyleMainAct.this, DemoAlphaAct.class));
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                    case 8:
                        break;
                }
            }
        });
    }
}
