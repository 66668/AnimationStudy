package lib.anim.transition.demo5;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import lib.anim.transition.R;
import lib.anim.transition.demo4.SEDemo4Act2;

/**
 * 共享元素
 */
public class FragDemo5 extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    Button btn_trans;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo41);
        img = findViewById(R.id.img);
        findViewById(R.id.btn_trans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragDemo5.this, SEDemo4Act2.class);

                View sharedView = img;
                String transitionName = "sjy_01";

                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(FragDemo5.this, sharedView, transitionName);
                startActivity(intent, transitionActivityOptions.toBundle());

                FragDemo5.this.finish();
            }
        });
    }


}
