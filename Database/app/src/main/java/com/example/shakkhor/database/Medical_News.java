package com.example.shakkhor.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.Toast;

public class Medical_News extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical__news);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        Toast.makeText(Medical_News.this, "Medical News Activity", Toast.LENGTH_LONG).show();
        webView = (WebView)findViewById(R.id.web);
        webView.loadUrl("https://www.medicalnewstoday.com/");
    }
}
