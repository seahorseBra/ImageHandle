package com.example.administrator.custemview;

import android.app.Application;
import android.view.WindowManager;

/**
 * Created by zchao on 2016/3/31.
 */
public class CApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.init(this);
    }


}
