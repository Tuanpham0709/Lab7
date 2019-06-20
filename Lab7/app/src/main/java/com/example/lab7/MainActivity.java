package com.example.lab7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnBai1,btnBai2,btnBai3;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBai1=findViewById(R.id.btnBai1);
        btnBai2=findViewById(R.id.btnBai2);
        btnBai3=findViewById(R.id.btnBai3);

    }

    public void Bai1(View view) {
        intent=new Intent(MainActivity.this,Bai1Activity.class);
        startActivity(intent);
    }

    public void Bai2(View view) {
        intent=new Intent(MainActivity.this,Bai2Activity.class);
        startActivity(intent);
    }

    public void Bai3(View view) {
        intent=new Intent(MainActivity.this,Bai3Activity.class);
        startActivity(intent);
    }
}
