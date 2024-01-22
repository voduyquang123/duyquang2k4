package com.example.appdocbao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailActivity extends AppCompatActivity {

    private WebView wedView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        wedView=findViewById(R.id.wed);
        Intent intent=getIntent();
        String link = intent.getStringExtra("link");
        wedView.loadUrl(link);
        wedView.setWebViewClient(new WebViewClient());
    }
}