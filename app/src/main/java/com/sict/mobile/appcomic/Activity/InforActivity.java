package com.sict.mobile.appcomic.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.sict.mobile.appcomic.Adapter.DetailAdapter;
import com.sict.mobile.appcomic.R;
import com.squareup.picasso.Picasso;

import static com.sict.mobile.appcomic.R.layout.activity_infor;

public class InforActivity extends AppCompatActivity{
    private static final String TAG = "InfoComic";
    private ImageView imgAvata;
    private TextView txtChap, txtName;
    private TabItem tabInfor,tabChapter;

    private DetailAdapter pageAdapter;
    private  ViewPager viewPager;
    private TabLayout tabLayout;
    private Button btnPrevMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_infor);
        getItentComic();
        tag_tab();
        prevMainComic();
    }
    private void getItentComic(){

        if (getIntent().hasExtra("comic_name")){
            Log.d(TAG, " on infor" );
            String namecomic = getIntent().getStringExtra("comic_name");
            String img_url = getIntent().getStringExtra("comic_img");
            setdata(namecomic, img_url);
        }
        else {
            Log.d(TAG, "fail infor" );
        }

    }
    private void setdata(String namecomic, String img_url){
        txtChap = (TextView) findViewById(R.id.txtChap);
        imgAvata = (ImageView)findViewById(R.id.imgAvata);
        txtName=(TextView)findViewById(R.id.txtName) ;
        txtName.setText(namecomic);
        Picasso.get().load(img_url).into(imgAvata);
    }
    public void prevMainComic(){
        btnPrevMain = findViewById(R.id.btnPrev);
        btnPrevMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void tag_tab(){
        tabLayout = findViewById(R.id.tab_comic_chapter);
        tabInfor = findViewById(R.id.tabitem_infor);
        tabChapter = findViewById(R.id.tabitem_chapter);
        viewPager = findViewById(R.id.vp_comic_chapter);
        pageAdapter = new DetailAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (getIntent().hasExtra("comic_chitiet")){
                    Log.d(TAG, " on infor chi tiet" );

                }
                else {
                    Log.d(TAG, " not infor chi tiet" );
                }
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
