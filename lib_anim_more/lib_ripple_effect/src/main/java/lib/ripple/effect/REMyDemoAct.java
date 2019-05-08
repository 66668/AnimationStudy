package lib.ripple.effect;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 触摸反馈 自定义样式
 */
public class REMyDemoAct extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_my_demo);
    }

//    @OnClick({R2.id.tv_01, R2.id.tv_02,})
//    public void onClicks(View view) {
//        if (view == tv_01) {
////            setSystemBoard(tv_01);
//
//        } else if (view == tv_02) {
////            setSystemBoardless(tv_02);
//        }
//    }


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

    /**
     * （2）无边界
     */
    private void setSystemBoardless02(View view) {
        int[] attrs = new int[]{R.attr.selectableItemBackgroundBorderless};
        TypedArray typedArray = obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        view.setBackgroundResource(backgroundResource);
    }

}
