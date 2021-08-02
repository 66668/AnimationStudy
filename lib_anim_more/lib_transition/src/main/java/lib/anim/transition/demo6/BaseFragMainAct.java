package lib.anim.transition.demo6;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;

import lib.anim.transition.R;

/**
 * Fragment 转场动画
 */
public class BaseFragMainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SJY","Activity-onCreate");
        setContentView(R.layout.act_demo6_base);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SJY","Activity-onStart");
    }
}
