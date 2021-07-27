package lib.anim.transition.demo3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;

import lib.anim.transition.R;

/**
 * code样式
 */
public class Demo3codeAct2 extends AppCompatActivity {
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
                startActivity(new Intent(Demo3codeAct2.this, Demo3codeAct.class));
                Demo3codeAct2.this.finish();
            }
        });
        setupWindowAnimations();
    }


    private void setupWindowAnimations() {
        Slide fade = new Slide();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
        getWindow().setReenterTransition(fade);
    }
}
