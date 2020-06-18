package com.fourthgroup.tolongin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailPertolongan extends AppCompatActivity {

    DatabaseReference ref;
    TextView judul, definisi, section1;
    static int posisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pertolongan);

        definisi = findViewById(R.id.definisi);
        section1 = findViewById(R.id.section1);
        judul = findViewById(R.id.judul);

        System.out.println("posisi : " + posisi);

        switch (posisi) {
            case 0:
                ref = FirebaseDatabase.getInstance().getReference("BHD");
                break;
            case 1:
                ref = FirebaseDatabase.getInstance().getReference("RJP");
                break;
            default:
                break;

        }
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String mJudul = dataSnapshot.child("judul").getValue().toString();
                String mDefinisi = dataSnapshot.child("definisi").getValue().toString();
                String mSection1 = dataSnapshot.child("section1").getValue().toString();

                judul.setText(mJudul);
                definisi.setText(mDefinisi);
                section1.setText(mSection1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}