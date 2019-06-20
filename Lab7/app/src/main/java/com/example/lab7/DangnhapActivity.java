package com.example.lab7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DangnhapActivity extends AppCompatActivity {
Button btnThoat;
TextView tvData;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        btnThoat=findViewById(R.id.btnThoat);
        tvData=findViewById(R.id.tvData);
        intent=getIntent();
        String username=intent.getStringExtra("Username");
        tvData.setText("Xin chao: " + username);
    }
    public void Thoat(View view){
        finish();

    }
}
