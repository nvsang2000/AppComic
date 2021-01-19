package com.sict.mobile.appcomic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sict.mobile.appcomic.Activity.DefailChapterActivity;
import com.sict.mobile.appcomic.Activity.InforActivity;
import com.sict.mobile.appcomic.Model.Chapter;
import com.sict.mobile.appcomic.Model.Comic;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.SelectComic;
import com.sict.mobile.appcomic.Viewholder.ChapterViewHolder;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterViewHolder> {
    private Context context;
    private List<Chapter> chapterList;
    public ChapterAdapter(Context context, List<Chapter> chapterList){
        this.context=context;
        this.chapterList=chapterList;

    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_chapter,parent,false);
        return new ChapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder,final int position) {
        holder.txtChapter.setText(chapterList.get(position).getTenchap());
        holder.item_chapter_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, DefailChapterActivity.class);
                intent.putExtra("chapter_id",chapterList.get(position).getIdchapter());
                intent.putExtra("chapter_name", chapterList.get(position).getTenchap());
                intent.putExtra("chapter_noidung", chapterList.get(position).getNoidung());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

}
