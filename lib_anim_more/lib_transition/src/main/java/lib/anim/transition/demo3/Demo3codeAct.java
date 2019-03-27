package lib.anim.transition.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lib.anim.transition.R;
import lib.anim.transition.R2;

/**
 * code样式
 */
public class Demo3codeAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    @BindView(R2.id.btn_trans)
    Button btn_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo31);
        ButterKnife.bind(this);
        setupWindowAnimations();
    }

    @OnClick(R2.id.btn_trans)
    public void onCLick(View view) {
        startActivity(new Intent(Demo3codeAct.this, Demo3codeAct2.class));
        this.finish();
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
        getWindow().setReturnTransition(fade);
    }
}
