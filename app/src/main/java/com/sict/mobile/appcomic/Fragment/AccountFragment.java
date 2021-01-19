package com.sict.mobile.appcomic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sict.mobile.appcomic.R;

public class AccountFragment extends Fragment{
    private  TextView txt_name_account ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container,false);
        TextView txtName = v.findViewById(R.id.txtName_Account);
        TextView txtEmail = v.findViewById(R.id.txtEmail_account);
        TextView txtGioi = v.findViewById(R.id.txtGioitinh_account);

        String name= getActivity().getIntent().getStringExtra("Name_Account");
        String email = getActivity().getIntent().getStringExtra("email_account");
        String gioitinh = getActivity().getIntent().getStringExtra("gioitinh_account");

        txtName.setText(name);
        txtEmail.setText(email);
        txtGioi.setText(gioitinh);


        return v;

    }

}
