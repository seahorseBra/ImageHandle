package com.example.administrator.custemview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 应用级别上下文
 * Created by zchao on 2016/3/31.
 */
public class AppContext {
    public static Context context;
    private static DisplayMetrics displayMetrics;

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        AppContext.context = context;
    }

    /**
     * 获取屏幕数据
     * @return
     */
    public static synchronized DisplayMetrics getDisplayMetrics() {
        if (displayMetrics == null) {
            displayMetrics = new DisplayMetrics();
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            manager.getDefaultDisplay().getMetrics(displayMetrics);

        }
        return displayMetrics;
    }
}
