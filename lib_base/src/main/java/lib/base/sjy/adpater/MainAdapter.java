package lib.base.sjy.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.base.sjy.R;
import lib.base.sjy.R2;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyHolder> {
    private Context mContext;
    private List<String> datas;
    private OnItemClickListener listener;

    public MainAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view, viewGroup, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        final String str = datas.get(i);
        myHolder.tv_name.setText(str);
        myHolder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(str, i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.tv_show)
        TextView tv_name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    //添加点击事件
    public interface OnItemClickListener {
        void onItemClick(String str, int pos);
    }

}
