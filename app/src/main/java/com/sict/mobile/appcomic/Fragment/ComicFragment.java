package com.sict.mobile.appcomic.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.sict.mobile.appcomic.Activity.InforActivity;
import com.sict.mobile.appcomic.Activity.SearchActivity;
import com.sict.mobile.appcomic.Adapter.ComicAdapter;
import com.sict.mobile.appcomic.Model.Comic;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.Remote.ApiClient;
import com.sict.mobile.appcomic.SelectComic;
import com.sict.mobile.appcomic.ServeComic;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicFragment extends Fragment implements SelectComic{
    private ImageSlider imageSlider;
    private RecyclerView recyclerView;
    private ComicAdapter comicAdapter;
    private ImageView img_search_icon;
    ProgressDialog progressDoalog;

    private static final String TAG = "Comic Fragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_comic, container,false);
        imageSlider = v.findViewById(R.id.slideshow1);
        recyclerView = v.findViewById(R.id.recyclerview1);
        img_search_icon = v.findViewById(R.id.img_search_icon);

        progressDoalog = new ProgressDialog(getContext());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        slideshow();
        getAllComic();
        nextSearchActivity();
        return v;
    }
    public void nextSearchActivity(){
        img_search_icon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });
    }
    public void slideshow(){
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://2.bp.blogspot.com/-21GFCbgZGt0/WRbH4vyl95I/AAAAAAAAArE/fEhfdU27dDknSRM4DORsrIGwKzzuDbxrQCLcB/s1600/soha-game-pham-nhan-tu-tien-duong-duong-2.jpg"));
        slideModels.add(new SlideModel("https://toplist.vn/images/800px/tap-do-phuong-tuong-77497.jpg"));
        slideModels.add(new SlideModel("https://2.bp.blogspot.com/-79wAg2nlk6E/WhjsKZzFtVI/AAAAAAAAJmg/I6whnuL5UKUAeXMRbwN8iQI9r7NrAqsCACLcBGAs/s1600/A780.jpg"));
        imageSlider.setImageList(slideModels,true);
    }
    private void generateDataList(List<Comic> datacomic) {

        comicAdapter = new ComicAdapter(getContext(),datacomic);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(comicAdapter);
    }

    public void getAllComic(){
        ServeComic serveComic = ApiClient.getRetrofitInstance().create(ServeComic.class);
        Call<List<Comic>> comiclist = serveComic.getComic();
        comiclist.enqueue(new Callback<List<Comic>>(){
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {

            }
        });
    }

    @Override
    public void SelectComic(Comic modelcomic) {
        startActivity(new Intent(getContext(), InforActivity.class).putExtra("data", modelcomic));
    }
}
