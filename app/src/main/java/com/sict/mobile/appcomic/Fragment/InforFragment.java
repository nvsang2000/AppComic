package com.sict.mobile.appcomic.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sict.mobile.appcomic.R;

public class InforFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_infor_comic, container, false);
        TextView txtInforComic = view.findViewById(R.id.txtInfor_comic);

        String infor_comic = getActivity().getIntent().getStringExtra("comic_chitiet");
        txtInforComic.setText(infor_comic);
        return view;
    }
}
