package lib.circular.reveal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewAnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.base.sjy.adpater.MainAdapter;
import lib.circular.reveal.demo1.Demo1_AppbarRevealAct;
import lib.circular.reveal.demo1.Demo1_LayoutRevealAct;


public class CRMainAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R2.id.tv_titile)
    TextView tv_titile;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        tv_titile.setText("揭露动画");
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("Layout的某一个view切换");
        data.add("Layout切换");

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
                        startToAppbar();
                        break;
                    case 1:
                        startToLayout();
                        break;
                    case 2:
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
                        Toast.makeText(CRMainAct.this, str + pos, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    //
    private void startToAppbar() {
        Intent intent = new Intent(CRMainAct.this, Demo1_AppbarRevealAct.class);
        startActivity(intent);
    }

    //
    private void startToLayout() {
        Intent intent = new Intent(CRMainAct.this, Demo1_LayoutRevealAct.class);
        startActivity(intent);
    }


}
