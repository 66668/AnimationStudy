package lib.ripple.effect;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 触摸反馈 系统样式展示
 */
public class RESystemDemoAct extends AppCompatActivity implements View.OnClickListener {

    TextView tv_01;

    TextView tv_02;

    TextView tv_03;

    TextView tv_04;

    Button btn_01;

    Button btn_02;

    Button btn_03;

    Button btn_04;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_system);
        initMyView();


    }

    private void initMyView() {
        tv_01 = findViewById(R.id.tv_01);
        tv_02 = findViewById(R.id.tv_02);
        tv_03 = findViewById(R.id.tv_03);
        tv_04 = findViewById(R.id.tv_04);
        //
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);
        btn_03 = findViewById(R.id.btn_03);
        btn_04 = findViewById(R.id.btn_04);

        tv_01.setOnClickListener(this);
        tv_02.setOnClickListener(this);
        tv_03.setOnClickListener(this);
        tv_04.setOnClickListener(this);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
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
