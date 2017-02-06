package com.example.jcaac.fragmentvisibilitywithviewpager.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jcaac.fragmentvisibilitywithviewpager.android.components.FragmentStateRow;
import com.example.jcaac.fragmentvisibilitywithviewpager.android.models.FragmentState;

import java.util.List;

public class FragmentStateAdapter extends RecyclerView.Adapter<FragmentStateAdapter.ViewHolder> {

    private List<FragmentState> items;

    public FragmentStateAdapter(List<FragmentState> items){
        this.items = items;
    }

    @Override
    public FragmentStateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new FragmentStateRow(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(FragmentStateAdapter.ViewHolder holder, int position) {
        holder.getItemView().setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(FragmentStateRow itemView) {
            super(itemView);
        }

        FragmentStateRow getItemView(){
            return (FragmentStateRow)itemView;
        }
    }
}
