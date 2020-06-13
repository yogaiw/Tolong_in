package com.fourthgroup.tolongin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class PertolonganPertama extends AppCompatActivity {

    CardView cardBHD, expandBHD;
    LinearLayout minfoBHD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertolongan_pertama);

        cardBHD = (CardView) findViewById(R.id.btn_BHD);
        expandBHD = (CardView) findViewById(R.id.expandableList1);
        minfoBHD = (LinearLayout) findViewById(R.id.infoBHD);

        cardBHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandBHD.getVisibility()==View.GONE) {
                    expandBHD.setVisibility(View.VISIBLE);
                    minfoBHD.setVisibility(View.VISIBLE);
                }
                else {
                    expandBHD.setVisibility(View.GONE);
                    minfoBHD.setVisibility(View.GONE);
                }
            }
        });
    }
}