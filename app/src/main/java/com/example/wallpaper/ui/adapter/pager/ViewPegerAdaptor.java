package com.example.wallpaper.ui.adapter.pager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPegerAdaptor extends FragmentPagerAdapter {

    private List<Fragment> list = new ArrayList<>();

    public ViewPegerAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    public void addFragment(Fragment fragment){
        list.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
