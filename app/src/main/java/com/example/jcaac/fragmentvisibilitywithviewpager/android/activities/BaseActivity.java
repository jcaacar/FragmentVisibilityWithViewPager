package com.example.jcaac.fragmentvisibilitywithviewpager.android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void startActivity(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }
}
