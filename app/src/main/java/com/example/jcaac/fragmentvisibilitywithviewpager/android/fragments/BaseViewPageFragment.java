package com.example.jcaac.fragmentvisibilitywithviewpager.android.fragments;

import android.support.v4.app.Fragment;

public abstract class BaseViewPageFragment extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isResumed()) {
            if (isVisibleToUser) {
                onVisible();
            } else {
                onHidden();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            onVisible();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getUserVisibleHint()) {
            onHidden();
        }
    }

    protected abstract void onVisible();

    protected abstract void onHidden();
}
