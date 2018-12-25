package com.sjy.tweenanim.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sjy.tweenanim.R;

import java.util.List;


public class GridAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    List<String> lists;

    public GridAdapter(Context context, List<String> data) {
        lists = data;
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public String getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载布局为一个视图
        View view = inflater.inflate(R.layout.item_vaview, null);
        TextView tv = view.findViewById(R.id.tv_show);
        String str = getItem(position);
        tv.setText(str);
        return view;
    }
}
