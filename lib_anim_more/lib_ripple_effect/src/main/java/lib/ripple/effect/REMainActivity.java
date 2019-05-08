package lib.ripple.effect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lib.base.sjy.adpater.MainAdapter;

public class REMainActivity extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    private  RecyclerView recyclerView;

    //-------------------------------------------------------------
    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        recyclerView = findViewById(R.id.recyclerView);
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("01-系统自带样式演示");
        data.add("02-自定义样式演示");
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
                        startToSystem();
                        break;
                    case 1:
                        startToMy();
                        break;
                    case 2:
                        startToProperty();
                        break;
                    case 3:
                        startToRippleEffect();
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        Toast.makeText(REMainActivity.this, str + pos, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void startToSystem() {
        Intent intent = new Intent(this, RESystemDemoAct.class);
        startActivity(intent);
    }

    private void startToMy() {
        Intent intent = new Intent(this, REMyDemoAct.class);
        startActivity(intent);
    }

    private void startToProperty() {
//        Intent intent = new Intent(MainActivity.this, MainAct.class);
//        startActivity(intent);
    }

    private void startToRippleEffect() {
//        Intent intent = new Intent(MainActivity.this, RippleMainAct.class);
//        startActivity(intent);
    }
}
