package com.fourthgroup.tolongin;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Lapor extends AppCompatActivity {

    EditText txtEmail, txtLaporan;
    Button buttonSumbit;
    ImageButton back;
    DatabaseReference ref;
    Laporan laporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapor);

        txtEmail = (EditText) findViewById(R.id.editEmail);
        txtLaporan = (EditText) findViewById(R.id.editLaporan);
        buttonSumbit = (Button) findViewById(R.id.btnSubmit);
        back = (ImageButton) findViewById(R.id.lpr_back_button);

        laporan = new Laporan();

        ref = FirebaseDatabase.getInstance().getReference().child("laporan");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laporan.setEmail(txtEmail.getText().toString().trim());
                laporan.setLaporan(txtLaporan.getText().toString().trim());
                ref.push().setValue(laporan);
                Toast.makeText(Lapor.this, "Laporan terkirim", Toast.LENGTH_SHORT).show();
            }
        });

    }
}