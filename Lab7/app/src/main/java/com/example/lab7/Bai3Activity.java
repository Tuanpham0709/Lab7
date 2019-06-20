package com.example.lab7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Bai3Activity extends AppCompatActivity {
Intent intent;
Button btnDangnhap;
EditText edtUser,edtPass;
CheckBox chkDangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btnDangnhap=findViewById(R.id.btnDangnhap);
        edtUser=findViewById(R.id.edtUser);
        edtPass=findViewById(R.id.edtPass);
        chkDangnhap=findViewById(R.id.chkThongtin);
        SharedPreferences sharedPreferences=getSharedPreferences("myfile.f",MODE_PRIVATE);
        boolean chk=sharedPreferences.getBoolean("Savestatus",false);
        if(chk){
            String user=sharedPreferences.getString("Username","");
            String pass=sharedPreferences.getString("Password","");
            edtUser.setText(user);
            edtPass.setText(pass);

        }
        chkDangnhap.setChecked(chk);
    }
    public void dangnhap(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("myfile.f",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String user=edtUser.getText().toString();
        String pass=edtPass.getText().toString();


        boolean chk=chkDangnhap.isChecked();
        if(!chk){
            editor.clear();
        }else{
            editor.putString("Username",user);
            editor.putString("Password",pass);
            editor.putBoolean("Savestatus",chk);
        }
        editor.commit();
        intent=new Intent(Bai3Activity.this,DangnhapActivity.class);
        intent.putExtra("Username",user);
        startActivity(intent);
    }
}
