package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_webview);
        WebView mywebview = (WebView) findViewById(R.id.web);
        mywebview.loadUrl("https://www.indianrail.gov.in/enquiry/PNR/PnrEnquiry.html?locale=en");
    }
}