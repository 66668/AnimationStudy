package lib.sjy.frame;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 帧动画
 */
public class FrameAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img;
    private Button btn_type1, btn_start, btn_end;
    //
    int type = 1;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_frame);
        img = findViewById(R.id.img);
        btn_type1 = findViewById(R.id.btn_type1);
        btn_start = findViewById(R.id.btn_start);
        btn_end = findViewById(R.id.btn_end);
        btn_type1.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_end.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_type1) {
            Toast.makeText(this, "方式" + type, Toast.LENGTH_SHORT).show();
            animationDrawable = getAnimationDrawable(type);
            if(type>=4){
                type =1;
            }else{
                type++;
            }
        } else if (v == btn_start) {
            if (animationDrawable == null) {
                animationDrawable = getAnimationDrawable(type);
                doAnimation(animationDrawable, true);
            }else{
                doAnimation(animationDrawable, true);
            }

        } else if (v == btn_end) {
            doAnimation(animationDrawable, false);
        }
    }

    private void doAnimation(AnimationDrawable animationDrawable, boolean doIt) {
        if (doIt) {
            animationDrawable.start();
        } else {
            if (animationDrawable.isRunning()) {
                animationDrawable.stop();
            }
        }
    }

    /**
     * 手动切换
     *
     * @return
     */
    private AnimationDrawable getAnimationDrawable(int type) {
        if (type == 1) {
            return setType1();
        } else if (type == 2) {
            return setType2();
        } else if (type == 3) {
            return setType3();
        } else {
            return setType4();
        }
    }

    /**
     * xml动画获取方式1
     *
     * @return
     */
    private AnimationDrawable setType1() {
        return (AnimationDrawable) img.getBackground();
    }

    /**
     * xml动画获取方式2
     *
     * @return
     */
    private AnimationDrawable setType2() {
        AnimationDrawable animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.run);
        img.setBackground(animationDrawable);
        return animationDrawable;
    }

    /**
     * xml动画获取方式3
     *
     * @return
     */
    private AnimationDrawable setType3() {
        img.setBackgroundResource(R.drawable.run);
        AnimationDrawable animationDrawable = (AnimationDrawable) img.getBackground();
        return animationDrawable;
    }

    /**
     * code 动画获取方式4
     *
     * @return
     */
    private AnimationDrawable setType4() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int i = 1; i < 8; i++) {
            int id = getResources().getIdentifier("run" + i, "drawable", getPackageName());
            Drawable drawable = getDrawable(id);
            if (null != drawable) {
                animationDrawable.addFrame(drawable, 100);
            }
        }
        img.setImageDrawable(animationDrawable);
        return (AnimationDrawable) img.getDrawable();
    }

}
