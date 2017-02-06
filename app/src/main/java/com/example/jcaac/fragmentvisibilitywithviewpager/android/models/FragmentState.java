package com.example.jcaac.fragmentvisibilitywithviewpager.android.models;

import android.support.v4.app.Fragment;
import com.example.jcaac.fragmentvisibilitywithviewpager.R;

public class FragmentState {

    public enum State {
        VISIBLE(R.string.visible_text),
        HIDDEN(R.string.hidden_text);

        private int resourceId;

        State(int resourceId){
            this.resourceId = resourceId;
        }

        public int getResourceId(){
            return this.resourceId;
        }
    }

    private Fragment fragment;
    private State state;

    public FragmentState(Fragment fragment, State state) {
        this.fragment = fragment;
        this.state = state;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public State getState() {
        return state;
    }
}
