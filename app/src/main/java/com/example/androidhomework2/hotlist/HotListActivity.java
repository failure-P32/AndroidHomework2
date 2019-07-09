package com.example.androidhomework2.hotlist;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhomework2.R;

import java.util.List;

public class HotListActivity extends AppCompatActivity {

    ListAdapter mListAdapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotlist);
        // 初始化RecyclerView
        RecyclerView mRecyclerView = findViewById(R.id.rv_hotlist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListAdapter = new ListAdapter();
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.setDataList(Data.generateData());
        mListAdapter.notifyDataSetChanged();
        // 增加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // 设置按钮回调函数，实现增加的功能
        Button btn = findViewById(R.id.b_add);
        btn.setOnClickListener((v)->{
            // 点击按钮后弹出对话框输入名称与热度
            View inputInfoView = View.inflate(this, R.layout.layout_add_dialog, null);
            AlertDialog alertDialog = new AlertDialog.Builder(this).
                    setTitle(R.string.inputinfo).
                    setView(inputInfoView).
                    setNegativeButton("取消", (d, i)->
                            Toast.makeText(HotListActivity.this, "已取消", Toast.LENGTH_SHORT).show()
                    ).setPositiveButton("确定", (d, i)->{ // 对话框确定按钮的回调函数
                        List<Data> list = mListAdapter.getDataList();
                        EditText etName = inputInfoView.findViewById(R.id.et_name),
                                etHot = inputInfoView.findViewById(R.id.et_hot);
                        // 更新Adapter中的list
                        list.add(new Data(etName.getText().toString(), Integer.parseInt(etHot.getText().toString())));
                        list.sort((Data d1, Data d2)-> d2.hot.compareTo(d1.hot)); // 按照热度重新排序
                        mListAdapter.setDataList(list);
                        mListAdapter.notifyDataSetChanged(); // 更新
                    }).create();
            alertDialog.show();
        });
    }
}
