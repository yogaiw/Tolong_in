package com.fourthgroup.tolongin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class RumahSakit extends AppCompatActivity {

    String iframe = "<iframe width=\"400\" height=\"450\" frameborder=\"0\" style=\"border:0\" src=\"https://www.google.com/maps/embed/v1/search?q=rumah%20sakit&key=AIzaSyBFuTxCRWqURLziqj4bBfQA7urXyZmk0ZA\" allowfullscreen></iframe>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumahsakit);

        WebView webView;
        webView = (WebView) findViewById(R.id.embed_map);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(iframe, "text/html", null);
    }
}