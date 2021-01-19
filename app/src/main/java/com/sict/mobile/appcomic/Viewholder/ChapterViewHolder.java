package com.sict.mobile.appcomic.Viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sict.mobile.appcomic.R;

public class ChapterViewHolder extends RecyclerView.ViewHolder{
    public TextView txtChapter;
    public RelativeLayout item_chapter_layout;
    public ChapterViewHolder(@NonNull View itemView) {
        super(itemView);

        txtChapter = itemView.findViewById(R.id.txtChapter);
        item_chapter_layout =itemView.findViewById(R.id.item_chapter_layout);
    }
}
