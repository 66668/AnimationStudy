package lib.anim.transition.demo3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;

import lib.anim.transition.R;

/**
 * 共享元素:Explode样式：xml和code两种实现方式
 */
public class ExplodeDemoAct extends AppCompatActivity {
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
        Explode enterTransition = new Explode();
        enterTransition.setDuration(500);
        return enterTransition;
    }

    private Transition buildEnterTransitionByXml() {
        return TransitionInflater.from(this).inflateTransition(R.transition.demo4_explode);
    }

}
