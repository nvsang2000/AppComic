package com.sict.mobile.appcomic.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sict.mobile.appcomic.Activity.InforActivity;
import com.sict.mobile.appcomic.Model.Comic;
import com.sict.mobile.appcomic.R;
import com.sict.mobile.appcomic.Viewholder.ComicViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicViewHolder>{

    private static final String TAG = "ComicAdapter";
    private Context context;
    private List<Comic> comicList;
    private static String url = "http://192.168.1.6:8080/AppTruyenTranh/public/resources/upload/";

    public ComicAdapter(Context context, List<Comic> comicList) {
        this.context = context;
        this.comicList = comicList;
    }
    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent,false);
        return new ComicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, final int position) {
        holder.txttentruyen.setText(comicList.get(position).getTentruyen());
        Picasso.get().load(url+ comicList.get(position).getHinh()).into(holder.imgAvata);
        holder.itemlayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, InforActivity.class);
                intent.putExtra("comic_id",comicList.get(position).getId());
                intent.putExtra("comic_name", comicList.get(position).getTentruyen());
                intent.putExtra("comic_img", url+comicList.get(position).getHinh());
                intent.putExtra("comic_chitiet", comicList.get(position).getChitiet());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

}
