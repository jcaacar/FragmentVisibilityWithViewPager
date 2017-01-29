package com.example.jcaac.fragmentvisibilitywithviewpager.android.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.fragments.FirstFragment;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.fragments.SecondFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<PageInfo> pages = new ArrayList<>();

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;

        loadPagesMap();
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position).fragment;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(pages.get(position).title);
    }

    private void loadPagesMap() {
        pages.add(new PageInfo(R.string.first_page, new FirstFragment()));
        pages.add(new PageInfo(R.string.second_page, new SecondFragment()));
    }

    private static class PageInfo {

        private int title;
        private Fragment fragment;

        PageInfo(int title, Fragment fragment) {
            this.title = title;
            this.fragment = fragment;
        }
    }
}
