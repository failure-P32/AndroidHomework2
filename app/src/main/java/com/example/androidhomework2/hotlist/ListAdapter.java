package com.example.androidhomework2.hotlist;

import android.app.AlertDialog;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter {

    private List<Data> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ListViewHolder.create(parent.getContext(), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bind(mDataList.get(position), position + 1);
        // 设置列表元素点击事件
        holder.itemView.setOnClickListener((v)->{ //点击事件为弹出dialog窗口
            AlertDialog dialog = new AlertDialog.Builder(v.getContext()).
                    setTitle("Rank " + (position + 1)).
                    setMessage(mDataList.get(position).text + ": " + mDataList.get(position).hot).
                    setPositiveButton("确认", (i, d)->{}).
                    create();
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(List<Data> list) {
        mDataList = list;
    }

    public List<Data> getDataList() {
        return mDataList;
    }
}
