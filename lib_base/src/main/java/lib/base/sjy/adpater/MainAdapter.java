package lib.base.sjy.adpater;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lib.base.sjy.R;


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

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final String str = datas.get(position);
        holder.tv_name.setText(str);
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(str, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_show);
        }

    }

    //添加点击事件
    public interface OnItemClickListener {
        void onItemClick(String str, int pos);
    }

}
