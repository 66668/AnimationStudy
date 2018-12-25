package lib.ripple.effect;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 触摸反馈 系统样式展示
 */
public class RESystemDemoAct extends AppCompatActivity {

    @BindView(R2.id.tv_01)
    TextView tv_01;

    @BindView(R2.id.tv_02)
    TextView tv_02;

    @BindView(R2.id.tv_03)
    TextView tv_03;

    @BindView(R2.id.tv_04)
    TextView tv_04;

    @BindView(R2.id.btn_01)
    Button btn_01;

    @BindView(R2.id.btn_02)
    Button btn_02;

    @BindView(R2.id.btn_03)
    Button btn_03;

    @BindView(R2.id.btn_04)
    Button btn_04;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_system);
        ButterKnife.bind(this);
    }

    @OnClick({R2.id.tv_01, R2.id.tv_02, R2.id.tv_03, R2.id.tv_04,
            R2.id.btn_01, R2.id.btn_02, R2.id.btn_03, R2.id.btn_04,})
    public void onClicks(View view) {
        if (view == tv_01) {
            setSystemBoard(tv_01);

        } else if (view == tv_02) {
            setSystemBoardless(tv_02);

        } else if (view == tv_03) {
            setSystemBoard(tv_03);

        } else if (view == tv_04) {
            setSystemBoardless(tv_04);

        } else if (view == btn_01) {
            setSystemBoard(btn_01);

        } else if (view == btn_02) {
            setSystemBoardless(btn_02);

        } else if (view == btn_03) {
            setSystemBoard(btn_03);

        } else if (view == btn_04) {
            setSystemBoardless(btn_04);

        }
    }


    //========================================================================
    //===================================code方式 系统样式============================
    //========================================================================

    /**
     * （1）有边界
     */
    private void setSystemBoard(View view) {
        int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        view.setBackgroundResource(backgroundResource);
    }


    /**
     * （2）无边界
     */
    private void setSystemBoardless(View view) {
        int[] attrs = new int[]{R.attr.selectableItemBackgroundBorderless};
        TypedArray typedArray = obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        view.setBackgroundResource(backgroundResource);
    }

}
