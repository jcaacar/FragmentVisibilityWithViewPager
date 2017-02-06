package com.example.jcaac.fragmentvisibilitywithviewpager.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;

public class SecondFragment extends BaseViewPageFragment {

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}
