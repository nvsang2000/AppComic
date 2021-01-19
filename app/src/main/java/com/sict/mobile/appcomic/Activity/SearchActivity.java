package com.sict.mobile.appcomic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.sict.mobile.appcomic.Adapter.ComicAdapter;
import com.sict.mobile.appcomic.Adapter.SearchAdapter;
import com.sict.mobile.appcomic.Model.Comic;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.Remote.ApiClient;
import com.sict.mobile.appcomic.ServeComic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity{
    private SearchAdapter comicAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getAllComic();
    }
    private void generateDataList(List<Comic> datacomic) {
        recyclerView = findViewById(R.id.recyclerview_search);
        comicAdapter = new SearchAdapter(getApplicationContext(),datacomic);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(comicAdapter);
    }

    public void getAllComic(){
        ServeComic serveComic = ApiClient.getRetrofitInstance().create(ServeComic.class);
        Call<List<Comic>> comiclist = serveComic.getComic();
        comiclist.enqueue(new Callback<List<Comic>>(){
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.acction_search);
        SearchView searchView =(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                comicAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}