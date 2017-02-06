package com.example.jcaac.fragmentvisibilitywithviewpager.android.components;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.models.FragmentState;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentStateRow extends LinearLayout {

    @BindView(R.id.fragment_name)
    protected TextView txtName;

    @BindView(R.id.fragment_state)
    protected TextView txtState;

    public FragmentStateRow(Context context) {
        super(context);
        init();
    }

    public FragmentStateRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FragmentStateRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.fragment_state_row, this);
        view.setLayoutParams(new LinearLayout.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        ButterKnife.bind(this);
    }

    public void setData(FragmentState data){
        txtName.setText(data.getFragment().getClass().getSimpleName());
        txtState.setTextColor( (data.getState() == FragmentState.State.VISIBLE) ? Color.BLUE : Color.RED );
        txtState.setText(getContext().getString(data.getState().getResourceId()));
    }
}
