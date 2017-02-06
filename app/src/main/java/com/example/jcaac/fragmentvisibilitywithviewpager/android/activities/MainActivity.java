package com.example.jcaac.fragmentvisibilitywithviewpager.android.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.adapters.ViewPagerAdapter;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.components.FragmentStateFooter;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.models.FragmentState;

import org.greenrobot.eventbus.Subscribe;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.sliding_tabs)
    protected TabLayout tabLayout;

    @BindView(R.id.view_pager)
    protected ViewPager viewPager;

    @BindView(R.id.fragment_state_footer)
    protected FragmentStateFooter fragmentStateFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.open_second_activity:
                startActivity(SecondActivity.class);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentResourceLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getMenuResourceLayout() {
        return R.menu.menu_activity_main;
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    private void setupView(){
        setupViewPager();
    }

    private void setupViewPager() {
        viewPager.setAdapter(new ViewPagerAdapter(this, getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Subscribe
    protected void onChangesFragmentState(FragmentState fragmentState) {
        fragmentStateFooter.addFragmentState(fragmentState);
    }
}
