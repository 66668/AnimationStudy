package lib.anim.transition.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import lib.anim.transition.R;

/**
 * style样式
 */
public class DemoTopAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    Button btn_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo);
        findViewById(R.id.btn_trans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DemoTopAct.this, Demo2MainAct.class));
                DemoTopAct.this.finish();
                //排除手机厂商os系统加入的动画
                overridePendingTransition(0, 0);
            }
        });
    }

}
