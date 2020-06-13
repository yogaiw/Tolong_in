package com.fourthgroup.tolongin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class PertolonganPertama extends AppCompatActivity {

    CardView cardBHD, cardRJP;
    LinearLayout minfoBHD, minfoRJP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertolongan_pertama);

        cardBHD = (CardView) findViewById(R.id.btn_BHD);
        cardRJP = (CardView) findViewById(R.id.btn_RJP);

        minfoBHD = (LinearLayout) findViewById(R.id.infoBHD);
        minfoRJP = (LinearLayout) findViewById(R.id.infoRJP);

        cardBHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minfoBHD.getVisibility()==View.GONE) {
                    minfoRJP.setVisibility(View.GONE);
                    minfoBHD.setVisibility(View.VISIBLE);
                }
                else {
                    /*expandBHD.setVisibility(View.GONE);*/
                    minfoBHD.setVisibility(View.GONE);
                }
            }
        });

        cardRJP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minfoRJP.getVisibility() == View.GONE) {
                    minfoBHD.setVisibility(View.GONE);
                    minfoRJP.setVisibility(View.VISIBLE);
                }
                else {
                    minfoRJP.setVisibility(View.GONE);
                }
            }
        });
    }
}