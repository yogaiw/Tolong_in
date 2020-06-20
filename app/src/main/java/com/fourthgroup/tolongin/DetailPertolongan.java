package com.fourthgroup.tolongin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailPertolongan extends AppCompatActivity implements View.OnClickListener {

    DatabaseReference ref;
    TextView judul, definisi, section1, section2_head, section2_content, section3_head, section3_content, section4_head, section4_content;
    CardView section2card, section3card, section4card;
    static int posisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pertolongan);

        judul = findViewById(R.id.judul);
        definisi = findViewById(R.id.definisi);
        section1 = findViewById(R.id.section1);

        section2card = findViewById(R.id.section2);
        section2_head = findViewById(R.id.section2_head);
        section2_content = findViewById(R.id.section2_content);

        section3card = findViewById(R.id.section3);
        section3_head = findViewById(R.id.section3_head);
        section3_content = findViewById(R.id.section3_content);

        section4card = findViewById(R.id.section4);
        section4_head = findViewById(R.id.section4_head);
        section4_content = findViewById(R.id.section4_content);

        section2card.setOnClickListener(this);
        section3card.setOnClickListener(this);
        section4card.setOnClickListener(this);

        System.out.println("posisi : " + posisi);

        switch (posisi) {
            case 0: ref = FirebaseDatabase.getInstance().getReference("BHD");
                break;
            case 1: ref = FirebaseDatabase.getInstance().getReference("RJP");
                break;
            case 2:
                ref = FirebaseDatabase.getInstance().getReference("Pingsan");
                section2card.setVisibility(View.GONE);
                section3card.setVisibility(View.GONE);
                section4card.setVisibility(View.GONE);
                break;
            case 3:
                ref = FirebaseDatabase.getInstance().getReference("Asma");
                section3card.setVisibility(View.GONE);
                section4card.setVisibility(View.GONE);
                break;
            case 4:
                ref = FirebaseDatabase.getInstance().getReference("Pendarahan");
                section3card.setVisibility(View.GONE);
                section4card.setVisibility(View.GONE);
                break;
            case 5:
                ref = FirebaseDatabase.getInstance().getReference("Syok");
                section2card.setVisibility(View.GONE);
                section3card.setVisibility(View.GONE);
                section4card.setVisibility(View.GONE);
                break;
            case 6: ref = FirebaseDatabase.getInstance().getReference("PatahTulang");
                break;
            case 7: ref = FirebaseDatabase.getInstance().getReference("LukaBakar");
                break;
            case 8:
                ref = FirebaseDatabase.getInstance().getReference("Hipotermia");
                break;
            case 9:
                ref = FirebaseDatabase.getInstance().getReference("CederaKepala");
                section4card.setVisibility(View.GONE);
                break;
            default:
                break;

        }
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                judul.setText(dataSnapshot.child("judul").getValue().toString());
                definisi.setText(dataSnapshot.child("definisi").getValue().toString());
                section1.setText(dataSnapshot.child("section1").getValue().toString());

                section2_head.setText(dataSnapshot.child("section2_head").getValue().toString());
                section2_content.setText(dataSnapshot.child("section2_content").getValue().toString());

                section3_head.setText(dataSnapshot.child("section3_head").getValue().toString());
                section3_content.setText(dataSnapshot.child("section3_content").getValue().toString());

                section4_head.setText(dataSnapshot.child("section4_head").getValue().toString());
                section4_content.setText(dataSnapshot.child("section4_content").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.section2:
                if(section2_content.getVisibility() != View.VISIBLE) {
                    section2_content.setVisibility(View.VISIBLE);
                } else {
                    section2_content.setVisibility(View.GONE);
                }
                break;
            case R.id.section3:
                if(section3_content.getVisibility() != View.VISIBLE) {
                    section3_content.setVisibility(View.VISIBLE);
                } else {
                    section3_content.setVisibility(View.GONE);
                }
                break;
            case R.id.section4:
                if(section4_content.getVisibility() != View.VISIBLE) {
                    section4_content.setVisibility(View.VISIBLE);
                } else {
                    section4_content.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }
}