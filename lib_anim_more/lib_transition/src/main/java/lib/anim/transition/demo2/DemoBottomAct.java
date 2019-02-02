package lib.anim.transition.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lib.anim.transition.R;
import lib.anim.transition.R2;
import lib.anim.transition.Demo2MainAct;

/**
 * style样式
 */
public class DemoBottomAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    @BindView(R2.id.btn_trans)
    Button btn_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btn_trans)
    public void onCLick(View view) {
        startActivity(new Intent(DemoBottomAct.this, Demo2MainAct.class));
        this.finish();
        overridePendingTransition(0,0);
    }

}