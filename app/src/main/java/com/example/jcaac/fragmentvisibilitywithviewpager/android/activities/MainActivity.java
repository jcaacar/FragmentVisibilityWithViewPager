package com.example.jcaac.fragmentvisibilitywithviewpager.android.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.sliding_tabs)
    protected TabLayout tabLayout;

    @BindView(R.id.view_pager)
    protected ViewPager viewPager;

    @BindView(R.id.button_open_new_activity)
    protected Button btnOpenNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        ButterKnife.bind(this);
        setupViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.button_open_new_activity)
    protected void onOpenNewActivity(View view) {
        startActivity(ChildActivity.class);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
    }

    private void setupViewPager() {
        viewPager.setAdapter(new ViewPagerAdapter(this, getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }
}
