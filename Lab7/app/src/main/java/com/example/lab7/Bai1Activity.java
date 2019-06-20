package com.example.lab7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Bai1Activity extends AppCompatActivity {
    private EditText edtInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        edtInput=findViewById(R.id.edtInput);
    }
    private String fileCacheName="myCache.cache";
    public void saveToCache(View view){
        String input=edtInput.getText().toString().trim();
        //lay ra duong dan cua thu muc chưa file cache
        File file=getCacheDir();
        File cacheFile=new File(file,fileCacheName);
        //ghi no ra bo nho
        try {
            cacheFile.createNewFile();
            FileOutputStream stream=new FileOutputStream(cacheFile);
            stream.write(input.getBytes());
            stream.close();
            edtInput.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void loadFromCache(View view){
        File file=getCacheDir();
        File cacheFile=new File(file,fileCacheName);
        try {
            Scanner scanner=new Scanner(cacheFile);
            String output="";
            while (scanner.hasNext()){
                output=output+scanner.nextLine();

            }
            scanner.close();
            edtInput.setText(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
