package com.atg.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mr_TT on 2015/12/27 0027.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private String[] dataset;

    public MyAdapter(String[] dataset) {
        this.dataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_textview,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mViewHolder= (ViewHolder) holder;
        mViewHolder.mTextView.setText(dataset[position]);
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    private static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView= (TextView) itemView.findViewById(R.id.mtextView);
        }
    }
}
