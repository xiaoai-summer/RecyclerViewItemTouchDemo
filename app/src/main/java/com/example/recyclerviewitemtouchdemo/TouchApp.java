package com.example.recyclerviewitemtouchdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by wangxiaoyan on 2020/8/31.
 */
public class TouchApp extends Application {
    public static Context context;

    public TouchApp() {
        this.context = this;
    }
}
