package lib.anim.transition.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

import lib.anim.transition.R;

/**
 * xml样式
 */
public class Demo3xmlAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    Button btn_trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo31);

        findViewById(R.id.btn_trans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Demo3xmlAct.this, Demo3xmlAct2.class));
                Demo3xmlAct.this.finish();
            }
        });
        setupWindowAnimations();
    }


    private void setupWindowAnimations() {
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.demo3_fade_01);
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.demo3_slide_01);
        getWindow().setEnterTransition(fade);
        getWindow().setReenterTransition(slide);
    }
}
