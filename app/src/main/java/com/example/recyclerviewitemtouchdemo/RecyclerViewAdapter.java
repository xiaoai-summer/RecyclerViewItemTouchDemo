package com.example.recyclerviewitemtouchdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxiaoyan on 2020/8/31.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private List<String> mData = new ArrayList<>();

    public RecyclerViewAdapter(List<String> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).mTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv);
        }
    }
}
