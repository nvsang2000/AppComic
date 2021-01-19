package com.sict.mobile.appcomic.Fragment;;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sict.mobile.appcomic.Activity.DefailChapterActivity;
import com.sict.mobile.appcomic.Adapter.ChapterAdapter;
import com.sict.mobile.appcomic.Model.Chapter;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.Remote.ApiClient;
import com.sict.mobile.appcomic.SelectChapter;
import com.sict.mobile.appcomic.ServeComic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterFragment extends Fragment implements SelectChapter{
    private RecyclerView recyclerView;
    private ChapterAdapter chapterAdapter;
    private static final String TAG = "ChapterFragment";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_chapter);

        getDataChapter();
        return view;
    }
    public void setDataChapter(List<Chapter> chapterList){
        chapterAdapter = new ChapterAdapter(getContext(),chapterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(chapterAdapter);
    }
    public void getDataChapter(){
        ServeComic  serveComic = ApiClient.getRetrofitInstance().create(ServeComic.class);
        Call<List<Chapter>> listCall = serveComic.getChapter();
        listCall.enqueue(new Callback<List<Chapter>>(){
            @Override
            public void onResponse(Call<List<Chapter>> call, Response<List<Chapter>> response) {
                if (response.isSuccessful()){
                    setDataChapter(response.body());
                }
               else {
                    Toast.makeText(getContext(), "lỗi lấy chap", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Chapter>> call, Throwable t) {
                Toast.makeText(getContext(), "lỗi ", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void SelectChapter(Chapter chaptermodel) {
        startActivity(new Intent(getContext(), DefailChapterActivity.class));
    }
}