package com.sict.mobile.appcomic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sict.mobile.appcomic.Adapter.ComicAdapter;
import com.sict.mobile.appcomic.Model.Comic;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.Remote.ApiClient;
import com.sict.mobile.appcomic.ServeComic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookFragment extends Fragment {
    private ComicAdapter comicAdapter;
    private RecyclerView recyclerView;
    private static final String TAG = "BookFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book,container,false);
        recyclerView = v.findViewById(R.id.recyclerview2);
        getAllComic();
        return v;
    }
    private void generateDataList(List<Comic> datacomic) {

        comicAdapter = new ComicAdapter(getContext(),datacomic);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
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

}
