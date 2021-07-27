package lib.anim.transition.demo3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import lib.anim.transition.R;

/**
 * style样式
 */
public class Demo3StyleAct extends AppCompatActivity {
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
                Demo3StyleAct.this.finish();
            }
        });
    }

}
