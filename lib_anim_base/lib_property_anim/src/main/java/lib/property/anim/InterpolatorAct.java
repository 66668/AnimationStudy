package lib.property.anim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 插值器（包括自定义）示例
 */
public class InterpolatorAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    //RecyclerView-v7
//    @BindView(R2.id.img)
//    ImageView img;

    //-------------------------------------------------------------


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_interpolator);
        ButterKnife.bind(this);
    }


}
