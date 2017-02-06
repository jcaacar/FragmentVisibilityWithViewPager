package com.example.jcaac.fragmentvisibilitywithviewpager.android.activities;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;

public class SecondActivity extends BaseActivity {

    @Override
    protected int getContentResourceLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected boolean listenEvents() {
        return false;
    }
}
