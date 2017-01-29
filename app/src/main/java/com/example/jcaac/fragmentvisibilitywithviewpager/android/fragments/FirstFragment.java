package com.example.jcaac.fragmentvisibilitywithviewpager.android.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;

public class FirstFragment extends BaseViewPageFragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    protected void onVisible() {
        Log.e(TAG, "onVisible()");
    }

    @Override
    protected void onHidden() {
        Log.e(TAG, "onHidden()");
    }
}