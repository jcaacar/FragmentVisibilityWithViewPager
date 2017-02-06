package com.example.jcaac.fragmentvisibilitywithviewpager.android.fragments;

import android.support.v4.app.Fragment;

import com.example.jcaac.fragmentvisibilitywithviewpager.android.models.FragmentState;
import org.greenrobot.eventbus.EventBus;

public abstract class BaseViewPageFragment extends Fragment {

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

    protected void onVisible() {
        EventBus.getDefault().post(new FragmentState(this, FragmentState.State.VISIBLE));
    }

    protected void onHidden() {
        EventBus.getDefault().post(new FragmentState(this, FragmentState.State.HIDDEN));
    }
}
