package com.fourthgroup.tolongin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class PertolonganPertama extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    String mTitle[] = {
            "Bantuan Hidup Dasar", "Resus Jantung Paru",
            "Pingsan", "Asma", "Pendarahan", "Syok", "Patah Tulang", "Luka Bakar",
            "Hipotermia", "Cedera Kepala"
    };
    int images[] = {R.drawable.ic_hospital, R.drawable.ic_hospital, R.drawable.ic_hospital,
            R.drawable.ic_hospital, R.drawable.ic_hospital, R.drawable.ic_hospital,
            R.drawable.ic_hospital, R.drawable.ic_hospital, R.drawable.ic_hospital,
            R.drawable.ic_hospital};

    LinearLayout minfoBHD, minfoRJP;
    Button btnBHD, btnRJP;
    DetailPertolongan dp = new DetailPertolongan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertolongan_pertama);

        listView = findViewById(R.id.lisView);
        minfoBHD = findViewById(R.id.infoBHD);
        minfoRJP = findViewById(R.id.infoRJP);

        btnBHD = findViewById(R.id.btnBHD);
        btnRJP = findViewById(R.id.btnRJP);

        btnBHD.setOnClickListener(this);
        btnRJP.setOnClickListener(this);

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    if (minfoBHD.getVisibility() != View.VISIBLE) {
                        setAllVisibilityGone();
                        minfoBHD.setVisibility(View.VISIBLE);
                    } else {
                        setAllVisibilityGone();
                    }
                } if(position == 1) {
                    if (minfoRJP.getVisibility() != View.VISIBLE) {
                        setAllVisibilityGone();
                        minfoRJP.setVisibility(View.VISIBLE);
                    } else {
                        setAllVisibilityGone();
                    }
                } if(position == 2) {
                    dp.posisi = 2;
                    keDetail();
                } if(position == 3) {
                    dp.posisi = 3;
                    keDetail();
                } if(position == 4) {
                    dp.posisi = 4;
                    keDetail();
                } if(position == 5) {
                    dp.posisi = 5;
                    keDetail();
                } if(position == 6) {
                    dp.posisi = 6;
                    keDetail();
                } if(position == 7) {
                    dp.posisi = 7;
                    keDetail();
                } if(position == 8) {
                    dp.posisi = 8;
                    keDetail();
                } if (position == 9) {
                    dp.posisi = 9;
                    keDetail();
                }
            }
        });
    }

    private void setAllVisibilityGone() {
        minfoBHD.setVisibility(View.GONE);
        minfoRJP.setVisibility(View.GONE);
    }

    private void keDetail() {
        startActivity(new Intent(PertolonganPertama.this, DetailPertolongan.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBHD: dp.posisi = 0; break;
            case R.id.btnRJP: dp.posisi = 1; break;
            default: break;
        }
        startActivity(new Intent(PertolonganPertama.this, DetailPertolongan.class));
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];

        MyAdapter(Context c, String title[], int imgs[]) {
            super(c, R.layout.row_pertolongan, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_pertolongan, parent, false);
            ImageView images = row.findViewById(R.id.image1);
            TextView myTitle = row.findViewById(R.id.textView1);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return row;
        }
    }
}