package com.example.androidhomework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import com.example.androidhomework2.hotlist.HotListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener((v)->{
            EditText stuid = findViewById(R.id.stuidedit);
            String stuidText = stuid.getText().toString();
            EditText pwd = findViewById(R.id.passedit);
            String pwdText = pwd.getText().toString();
            if (stuidText.length() != 10) { // 检查学号与密码的合法性
                Toast.makeText(MainActivity.this, "Invalid Student ID!", Toast.LENGTH_SHORT).show();
            } else if (pwdText.length() < 6) {
                Toast.makeText(MainActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
            } else { // 合法，进入热榜界面
                Intent intent = new Intent(MainActivity.this, HotListActivity.class);
                startActivity(intent);
            }
        });
    }
}
