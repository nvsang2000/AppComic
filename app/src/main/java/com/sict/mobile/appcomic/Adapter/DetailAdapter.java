package com.sict.mobile.appcomic.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sict.mobile.appcomic.Fragment.ChapterFragment;
import com.sict.mobile.appcomic.Fragment.InforFragment;


public class DetailAdapter extends FragmentPagerAdapter{
    private int NumberOfTabs;

    public DetailAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.NumberOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new InforFragment();
            case 1:
                return  new ChapterFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NumberOfTabs;
    }
}
