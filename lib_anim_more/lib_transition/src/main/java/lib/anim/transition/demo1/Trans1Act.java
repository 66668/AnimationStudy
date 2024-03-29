package lib.anim.transition.demo1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lib.anim.transition.R;
import lib.base.sjy.adpater.MainAdapter;

/**
 * overridePendingTransition方式
 */
public class Trans1Act extends AppCompatActivity implements View.OnClickListener{
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    Button btn_trans;

    RecyclerView recyclerView;

    private List<String> data = new ArrayList<>();
    private MainAdapter adapter;
    private int type = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_transdemo1);
        recyclerView = findViewById(R.id.recyclerView);
        btn_trans = findViewById(R.id.btn_trans);
        btn_trans.setOnClickListener(this);
        initView();
    }

    private void initView() {
        data = new ArrayList<>();
        //
        data.add("动画样式-left-in-out");
        data.add("动画样式-right-in-out");
        data.add("动画样式-top-in-out");
        data.add("动画样式-down-in-out");
        data.add("动画样式-alpha-in-out");
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
                        type = 0;
                        Toast.makeText(Trans1Act.this, "选中", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(Trans1Act.this, "选中", Toast.LENGTH_SHORT).show();
                        type = 1;
                        break;
                    case 2:
                        Toast.makeText(Trans1Act.this, "选中", Toast.LENGTH_SHORT).show();
                        type = 2;
                        break;
                    case 3:
                        Toast.makeText(Trans1Act.this, "选中", Toast.LENGTH_SHORT).show();
                        type = 3;
                        break;
                    case 4:
                        Toast.makeText(Trans1Act.this, "选中", Toast.LENGTH_SHORT).show();
                        type = 4;
                        break;
                    case 5:
                        Toast.makeText(Trans1Act.this, "选中", Toast.LENGTH_SHORT).show();
                        type = 5;
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


    public void onClick(View view) {
        //在调用了 startActivity 方法之后立即调用 overridePendingTransition 方法
        Intent intent = new Intent(Trans1Act.this, Trans2Act.class);
        startActivity(intent);
        /**
         * 该方法紧跟startActivity，不要作延迟处理。
         */
        if (type == 0) {//left
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        } else if (type == 1) {//right
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        } else if (type == 2) {//top
            overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_top);
        } else if (type == 3) {//down
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        } else if (type == 4) {//alpha
            overridePendingTransition(R.anim.slide_in_alpha, R.anim.slide_out_alpha);
        } else {

        }

    }

}
