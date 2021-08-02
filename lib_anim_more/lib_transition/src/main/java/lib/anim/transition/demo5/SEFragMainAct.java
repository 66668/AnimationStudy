package lib.anim.transition.demo5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.transition.ChangeBounds;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;

import lib.anim.transition.R;

/**
 * Fragment 转场动画
 */
public class SEFragMainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SJY","Activity-onCreate");
        setContentView(R.layout.act_demo5);
        Sample sample = new Sample(R.color.colorAccent, "img_01");
        setupLayout(sample);
    }


    private void setupLayout(Sample sample) {
        // Transition for fragment1
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(500);
        // Create fragment and define some of it transitions
//        BaseFrag sharedElementFragment1 = BaseFrag.newInstance();
        SEFragment01 sharedElementFragment1 = SEFragment01.newInstance(sample);
        sharedElementFragment1.setReenterTransition(slideTransition);
        sharedElementFragment1.setExitTransition(slideTransition);
        sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getFragmentManager().beginTransaction()
                .replace(R.id.layout_frag, sharedElementFragment1)//TODO SJY id报空
                .commit();
    }
}
