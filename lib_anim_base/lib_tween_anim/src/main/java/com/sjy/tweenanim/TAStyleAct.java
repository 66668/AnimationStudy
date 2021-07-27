package com.sjy.tweenanim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

/**
 * 动画的style调用样式
 */
public class TAStyleAct extends AppCompatActivity {

    //-----------------------------控件--------------------------------
    Button btn_popwidow;


    //-------------------------------------------------------------
    private PopupWindow mImgPopupWindow;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_style);
        btn_popwidow = findViewById(R.id.btn_popwidow);
        btn_popwidow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPopwidow1(v);
            }
        });
    }

    private void myPopwidow1(View anchor) {
        if (mImgPopupWindow == null) {
            //  View view = LayoutInflater.from(this).inflate(R.layout.popuplayout, null);//方式1
            ImageView view = new ImageView(this);//方式2
            view.setImageDrawable(getDrawable(R.mipmap.ic_launcher));

            mImgPopupWindow = new PopupWindow(view, anchor.getMeasuredWidth(), anchor.getMeasuredWidth());
            mImgPopupWindow.setAnimationStyle(R.style.popWindow_01);
        }
        if (mImgPopupWindow.isShowing()) {
            mImgPopupWindow.dismiss();
        } else {
            mImgPopupWindow.showAsDropDown(anchor);
        }
    }

}
