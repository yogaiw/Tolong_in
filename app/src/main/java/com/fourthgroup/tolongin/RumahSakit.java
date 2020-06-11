package com.fourthgroup.tolongin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class RumahSakit extends AppCompatActivity {

    String iframe = "<iframe width=\"400\" height=\"450\" frameborder=\"0\" style=\"border:0\" src=\"https://www.google.com/maps/embed/v1/search?q=rumah%20sakit&key=AIzaSyBFuTxCRWqURLziqj4bBfQA7urXyZmk0ZA\" allowfullscreen></iframe>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WebView webView;
        ImageButton back;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumahsakit);

        back = (ImageButton) findViewById(R.id.rs_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RumahSakit.this, MainActivity.class));
            }
        });

        webView = (WebView) findViewById(R.id.embed_map);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(iframe, "text/html", null);
    }
}