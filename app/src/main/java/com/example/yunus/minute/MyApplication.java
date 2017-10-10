package com.example.yunus.minute;

import android.app.Application;
import android.content.Context;

/**
 * Created by yun on 2017/10/10.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
