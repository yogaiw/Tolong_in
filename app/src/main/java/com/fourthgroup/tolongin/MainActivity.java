package com.fourthgroup.tolongin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    ImageButton buttonPertolongan;
    CardView cardRSterdekat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPertolongan = (ImageButton) findViewById(R.id.button_pertolongan);
        cardRSterdekat = (CardView) findViewById(R.id.button_rsterdekat);

        buttonPertolongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PertolonganPertama.class));
            }
        });

        cardRSterdekat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RSTerdekat.class));
            }
        });
    }
}