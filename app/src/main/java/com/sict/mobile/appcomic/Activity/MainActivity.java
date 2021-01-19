package com.sict.mobile.appcomic.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sict.mobile.appcomic.Fragment.AccountFragment;
import com.sict.mobile.appcomic.Fragment.BookFragment;
import com.sict.mobile.appcomic.Fragment.ComicFragment;
import com.sict.mobile.appcomic.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new ComicFragment()).commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navbottom);
        getDataAccount();

    }
    public void getDataAccount(){
        Intent intent = getIntent();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navbottom =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            fragment = new ComicFragment();
                            break;
                        case R.id.nav_book:
                            fragment = new BookFragment();
                            break;
                        case R.id.nav_account:
                            fragment = new AccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
                    return false;
                }
            };

}