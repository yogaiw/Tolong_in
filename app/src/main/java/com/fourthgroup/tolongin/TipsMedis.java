package com.fourthgroup.tolongin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class TipsMedis extends AppCompatActivity implements View.OnClickListener {

    DatabaseReference ref;
    ImageButton back;
    CardView tips1card, tips2card, tips3card, tips4card, tips5card;
    TextView tips1_title, tips1_content, tips2_title, tips2_content
            ,tips3_title, tips3_content, tips4_title, tips4_content
            ,tips5_title, tips5_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsmedis);

        tips1card = findViewById(R.id.tips1);
        tips1_title = findViewById(R.id.tips1_title);
        tips1_content = findViewById(R.id.tips1_content);

        tips2card = findViewById(R.id.tips2);
        tips2_title = findViewById(R.id.tips2_title);
        tips2_content = findViewById(R.id.tips2_content);

        tips3card = findViewById(R.id.tips3);
        tips3_title = findViewById(R.id.tips3_title);
        tips3_content = findViewById(R.id.tips3_content);

        tips4card = findViewById(R.id.tips4);
        tips4_title = findViewById(R.id.tips4_title);
        tips4_content = findViewById(R.id.tips4_content);

        tips5card = findViewById(R.id.tips5);
        tips5_title = findViewById(R.id.tips5_title);
        tips5_content = findViewById(R.id.tips5_content);

        back = findViewById(R.id.tips_back_button);

        tips1card.setOnClickListener(this);
        tips2card.setOnClickListener(this);
        tips3card.setOnClickListener(this);
        tips4card.setOnClickListener(this);
        tips5card.setOnClickListener(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ref = FirebaseDatabase.getInstance().getReference("tips");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tips1_title.setText(dataSnapshot.child("tips1").child("title").getValue().toString());
                tips1_content.setText(dataSnapshot.child("tips1").child("content").getValue().toString());

                tips2_title.setText(dataSnapshot.child("tips2").child("title").getValue().toString());
                tips2_content.setText(dataSnapshot.child("tips2").child("content").getValue().toString());

                tips3_title.setText(dataSnapshot.child("tips3").child("title").getValue().toString());
                tips3_content.setText(dataSnapshot.child("tips3").child("content").getValue().toString());

                tips4_title.setText(dataSnapshot.child("tips4").child("title").getValue().toString());
                tips4_content.setText(dataSnapshot.child("tips4").child("content").getValue().toString());

                tips5_title.setText(dataSnapshot.child("tips5").child("title").getValue().toString());
                tips5_content.setText(dataSnapshot.child("tips5").child("content").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tips1:
                if (tips1_content.getVisibility() != View.VISIBLE) {
                    tips1_content.setVisibility(View.VISIBLE);
                } else {
                    tips1_content.setVisibility(View.GONE);
                }
                break;
            case R.id.tips2:
                if(tips2_content.getVisibility() != View.VISIBLE) {
                    tips2_content.setVisibility(View.VISIBLE);
                } else
                    tips2_content.setVisibility(View.GONE);
                break;
            case R.id.tips3:
                if(tips3_content.getVisibility() != View.VISIBLE) {
                    tips3_content.setVisibility(View.VISIBLE);
                } else
                    tips3_content.setVisibility(View.GONE);
                break;
            case R.id.tips4:
                if(tips4_content.getVisibility() != View.VISIBLE) {
                    tips4_content.setVisibility(View.VISIBLE);
                } else
                    tips4_content.setVisibility(View.GONE);
                break;
            case R.id.tips5:
                if(tips5_content.getVisibility() != View.VISIBLE) {
                    tips5_content.setVisibility(View.VISIBLE);
                } else
                    tips5_content.setVisibility(View.GONE);
                break;
        }
    }
}