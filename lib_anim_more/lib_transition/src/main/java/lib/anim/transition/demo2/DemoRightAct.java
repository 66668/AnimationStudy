package lib.anim.transition.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import lib.anim.transition.Demo2MainAct;
import lib.anim.transition.R;

/**
 * style样式
 */
public class DemoRightAct extends AppCompatActivity {
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
                startActivity(new Intent(DemoRightAct.this, Demo2MainAct.class));
                DemoRightAct.this.finish();
                overridePendingTransition(0, 0);
            }
        });
    }


}
