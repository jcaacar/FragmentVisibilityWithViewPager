package com.example.jcaac.fragmentvisibilitywithviewpager.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private final int NO_MENU = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResourceLayout());
        ButterKnife.bind(this);
        setupActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int res = getMenuResourceLayout();
        if (res == NO_MENU) {
            return false;
        }
        getMenuInflater().inflate(res, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listenEvents()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    private void setupActionBar() {
        Toolbar toolbar = getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public void startActivity(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }

    int getMenuResourceLayout() {
        return NO_MENU;
    }

    Toolbar getToolbar() {
        return null;
    }

    boolean listenEvents(){
        return true;
    }

    protected abstract int getContentResourceLayout();
}
