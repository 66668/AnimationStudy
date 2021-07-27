package lib.anim.transition.demo5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;

import lib.anim.transition.R;

public class SEFragMainAct extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo5);
        Sample sample = new Sample(R.color.colorAccent, "img_01");
        setupLayout(sample);
    }


    private void setupLayout(Sample sample) {
        // Transition for fragment1
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(500);
        // Create fragment and define some of it transitions
        SEFragment01 sharedElementFragment1 = SEFragment01.newInstance(sample);
        sharedElementFragment1.setReenterTransition(slideTransition);
        sharedElementFragment1.setExitTransition(slideTransition);
        sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, sharedElementFragment1)
                .commit();
    }
}
