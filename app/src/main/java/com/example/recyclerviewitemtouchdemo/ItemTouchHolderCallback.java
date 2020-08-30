package com.example.recyclerviewitemtouchdemo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

/**
 * Created by wangxiaoyan on 2020/8/31.
 */
public class ItemTouchHolderCallback extends ItemTouchHelper.Callback {
    private RecyclerViewAdapter mAdapter;
    private List<String> mData;
    private Runnable mRunnable;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    public ItemTouchHolderCallback(RecyclerViewAdapter mAdapter, List<String> mData) {
        this.mData = mData;
        this.mAdapter = mAdapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        return makeMovementFlags(ItemTouchHelper.UP|ItemTouchHelper.DOWN|
                ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT,0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        int position = viewHolder.getAdapterPosition();
        int targetPosition = target.getAdapterPosition();
        Collections.swap(mData,position,targetPosition);
        mAdapter.notifyItemMoved(position,targetPosition);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if(viewHolder != null && actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            viewHolder.itemView.setBackgroundColor(Color.RED);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull final RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        mRunnable = new Runnable() {
            @Override
            public void run() {
                viewHolder.itemView.setBackgroundColor(TouchApp.context.getResources().getColor(R.color.colorNormal));
            }
        };
        viewHolder.itemView.postDelayed(mRunnable,3000);
    }

    public void onDestroy() {
        mUIHandler.removeCallbacks(mRunnable);
    }
}
