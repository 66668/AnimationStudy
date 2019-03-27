package lib.anim.transition.demo5;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lib.anim.transition.R;
import lib.anim.transition.R2;
import lib.anim.transition.demo4.SEDemo4Act2;

/**
 * 共享元素
 */
public class FragDemo5 extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    //RecyclerView-v7
    @BindView(R2.id.btn_trans)
    Button btn_trans;

    @BindView(R2.id.img)
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo41);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btn_trans)
    public void onCLick(View view) {
        Intent intent = new Intent(FragDemo5.this, SEDemo4Act2.class);

        View sharedView = img;
        String transitionName = "sjy_01";

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(FragDemo5.this, sharedView, transitionName);
        startActivity(intent, transitionActivityOptions.toBundle());

        this.finish();
    }

}
