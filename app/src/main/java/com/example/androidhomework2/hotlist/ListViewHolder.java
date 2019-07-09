package com.example.androidhomework2.hotlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhomework2.R;

public class ListViewHolder extends RecyclerView.ViewHolder {

    private TextView rankTextView;
    private TextView mTextView;
    private TextView hotTextView;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        rankTextView = itemView.findViewById(R.id.tv_rk);
        mTextView = itemView.findViewById(R.id.tv_text);
        hotTextView = itemView.findViewById(R.id.tv_hot);
    }

    public static ListViewHolder create(Context context, ViewGroup root) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_data, root, false);
        return new ListViewHolder(v);
    }

    public void bind(Data data, Integer position) {
        if (null == data) return;
        mTextView.setText(data.text);
        rankTextView.setText(position.toString());
        if (position <= 3) // 热榜前三设置为黄色
            rankTextView.setTextColor(0xe6face15);
        hotTextView.setText(data.hot.toString());
    }

}
