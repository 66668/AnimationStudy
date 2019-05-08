package lib.anim.transition.demo4;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import lib.anim.transition.R;

/**
 * 共享元素
 */
public class SEDemo4Act1 extends AppCompatActivity implements View.OnClickListener {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    Button btn_trans;

    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo41);
        btn_trans = findViewById(R.id.btn_trans);
        img = findViewById(R.id.img);
        btn_trans.setOnClickListener(this);

    }

    public void onClick(View view) {
        Intent intent = new Intent(SEDemo4Act1.this, SEDemo4Act2.class);

        View sharedView = img;
        String transitionName = "sjy_01";

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SEDemo4Act1.this, sharedView, transitionName);
        startActivity(intent, transitionActivityOptions.toBundle());

        this.finish();
    }

}
