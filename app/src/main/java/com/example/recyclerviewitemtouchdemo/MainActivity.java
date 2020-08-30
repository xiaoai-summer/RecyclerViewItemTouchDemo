package com.example.recyclerviewitemtouchdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private List<String> mData;
    private RecyclerViewAdapter mAdapter;
    private ItemTouchHolderCallback mItemTouchHolderCallback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        mData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mData.add("" + i);
        }

        mAdapter = new RecyclerViewAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

        mItemTouchHolderCallback = new ItemTouchHolderCallback(mAdapter,mData);

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mItemTouchHolderCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mItemTouchHolderCallback.onDestroy();
    }
}