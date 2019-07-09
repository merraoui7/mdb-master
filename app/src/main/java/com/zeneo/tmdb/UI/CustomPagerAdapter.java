package com.zeneo.tmdb.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    List<String> titleList = new ArrayList<>();
    List<Fragment> fragList = new ArrayList<>();

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFrag(Fragment fragment , String title , String url ){
        Fragment fragment1 = fragment;
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        fragment1.setArguments(bundle);
        titleList.add(title);
        fragList.add(fragment1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }
}
