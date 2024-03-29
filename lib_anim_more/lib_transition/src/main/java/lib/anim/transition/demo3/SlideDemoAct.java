package lib.anim.transition.demo3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;

import lib.anim.transition.R;

/**
 * 共享元素:Slide样式：xml和code两种实现方式
 */
public class SlideDemoAct extends AppCompatActivity {
    //-----------------------------控件--------------------------------
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo3_explode);

        type = getIntent().getExtras().getString("type");
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Transition transition = null;
        switch (type) {
            case "code":
                transition = buildEnterTransitionByCode();
                break;
            case "xml":
                transition = buildEnterTransitionByXml();
                break;
            default:
                break;
        }

        getWindow().setEnterTransition(transition);
    }

    private Transition buildEnterTransitionByCode() {
        Slide enterTransition = new Slide();
        enterTransition.setDuration(500);
        enterTransition.setSlideEdge(Gravity.RIGHT);
        return enterTransition;
    }

    private Transition buildEnterTransitionByXml() {
        return TransitionInflater.from(this).inflateTransition(R.transition.demo4_slide);
    }

}
