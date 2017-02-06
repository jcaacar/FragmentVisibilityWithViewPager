package com.example.jcaac.fragmentvisibilitywithviewpager.android.components;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.jcaac.fragmentvisibilitywithviewpager.R;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.adapters.FragmentStateAdapter;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.models.FragmentState;

import java.util.ArrayList;
import java.util.List;

public class FragmentStateFooter extends LinearLayout {

    @BindView(R.id.footer_recycler_view)
    protected RecyclerView recyclerView;

    private FragmentStateAdapter adapter;
    private List<FragmentState> fragmentStates = new ArrayList<>();

    public FragmentStateFooter(Context context) {
        super(context);
        init();
    }

    public FragmentStateFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FragmentStateFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.fragment_state_footer, this);
        ButterKnife.bind(this);
        setupRecyclerView();
    }

    public void addFragmentState(FragmentState fragmentState) {
        fragmentStates.add(fragmentState);
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(fragmentStates.size() - 1);
    }

    private void setupRecyclerView() {
        adapter = new FragmentStateAdapter(fragmentStates);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
