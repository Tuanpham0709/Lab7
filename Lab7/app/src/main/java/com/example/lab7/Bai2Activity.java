package com.example.lab7;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Bai2Activity extends AppCompatActivity {
    private EditText edtInput1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        edtInput1=findViewById(R.id.edtInput1);
    }
    public void savetoCard(View view){
    String sdcard= Environment.getExternalStorageDirectory().getAbsolutePath()+"/myfile.txt";
    try {
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(sdcard));
        writer.write(edtInput1.getText()+"");
        writer.close();
        edtInput1.setText("");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
    public  void loadfromCard(View view){
        String sdcard=Environment.getExternalStorageDirectory().getAbsolutePath()+"/myfile.txt";
        try {
            Scanner scan=new Scanner(new File(sdcard));
            String data="";
            while (scan.hasNext()){

                data+=scan.nextLine()+"\n";
            }
            scan.close();
            edtInput1.setText(data+"");
            edtInput1.setText(data+"");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
