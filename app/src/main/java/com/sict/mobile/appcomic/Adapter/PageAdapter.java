package com.sict.mobile.appcomic.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter{
    private  ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private ArrayList<String> arraytitle = new ArrayList<>();
    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
    public void addFragment(Fragment fragment, String title) {
        arraytitle.add(title);
        fragmentArrayList.add(fragment);
    }
}
