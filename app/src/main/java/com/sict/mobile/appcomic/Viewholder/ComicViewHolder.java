package com.sict.mobile.appcomic.Viewholder;


import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sict.mobile.appcomic.R;

public class ComicViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgAvata;
    public TextView txttentruyen;
    public TextView txtid;
    public RelativeLayout itemlayout;

    public ComicViewHolder(@NonNull View itemView) {
        super(itemView);
        imgAvata = itemView.findViewById(R.id.Img_Avata_Comic);
        txttentruyen = itemView.findViewById(R.id.txt_Name_Comic);
        itemlayout = itemView.findViewById(R.id.relativelayout);
    }

}