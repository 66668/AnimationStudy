package lib.anim.transition.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import lib.anim.transition.R;

/**
 * code样式
 */
public class Demo3codeAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    Button btn_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo31);
        findViewById(R.id.btn_trans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3codeAct.this, Demo3codeAct2.class));
                Demo3codeAct.this.finish();
            }
        });
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
        getWindow().setReturnTransition(fade);
    }
}
