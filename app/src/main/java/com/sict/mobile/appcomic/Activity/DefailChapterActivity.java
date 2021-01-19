package com.sict.mobile.appcomic.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.sict.mobile.appcomic.R;

public class DefailChapterActivity extends Activity{
    private TextView txt_Chapter_Noidung, txt_Chapter_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defail_chapter);

        txt_Chapter_Noidung = findViewById(R.id.txt_Chapter_Noidung);
        txt_Chapter_Name = findViewById(R.id.txt_Chapter_Name);

        if(getIntent().hasExtra("chapter_noidung")){
            String chapter_noidung =getIntent().getStringExtra("chapter_noidung");
            String chapter_name =getIntent().getStringExtra("chapter_name");
            txt_Chapter_Name.setText(chapter_name);
            txt_Chapter_Noidung.setText(chapter_noidung);


        }
    }
}