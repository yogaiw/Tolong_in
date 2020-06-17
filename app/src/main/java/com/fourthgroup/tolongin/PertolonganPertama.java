package com.fourthgroup.tolongin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class PertolonganPertama extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {
            "Bantuan Hidup Dasar", "Resus Jantung Paru", "Tenggelam",
            "Pingsan", "Asma", "Pendarahan"
    };
    int images[] = {R.drawable.ic_hospital, R.drawable.ic_hospital, R.drawable.ic_hospital,
            R.drawable.ic_hospital, R.drawable.ic_hospital, R.drawable.ic_hospital};

    LinearLayout minfoBHD, minfoRJP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertolongan_pertama);

        listView = findViewById(R.id.lisView);
        minfoBHD = findViewById(R.id.infoBHD);
        minfoRJP = findViewById(R.id.infoRJP);

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
                }

                if(position == 1) {
                    if (minfoRJP.getVisibility() != View.VISIBLE) {
                        setAllVisibilityGone();
                        minfoRJP.setVisibility(View.VISIBLE);
                    } else {
                        setAllVisibilityGone();
                    }
                }
            }
        });
    }

    private void setAllVisibilityGone() {
        minfoBHD.setVisibility(View.GONE);
        minfoRJP.setVisibility(View.GONE);
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