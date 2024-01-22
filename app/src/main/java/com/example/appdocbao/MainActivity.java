package com.example.appdocbao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleView=findViewById(R.id.recycleview);
        String link = "https://vnexpress.net/thoi-su/chinh-tri";
        MyAsycTask myAsycTask = new MyAsycTask(MainActivity.this,link,recycleView);
        myAsycTask.execute();
    }
}