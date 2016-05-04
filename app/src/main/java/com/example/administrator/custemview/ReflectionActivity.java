package com.example.administrator.custemview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zchao on 2016/4/29.
 */
public class ReflectionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_reflection);
        getMethod();
    }

    public void getMethod() {
        try {
            Class<?> aClass = Class.forName("com.example.administrator.custemview.Utils.ImageUtil.class");
            Constructor<?> constructor = aClass.getConstructor();
            Object o = constructor.newInstance();
            System.out.print(o.toString() + "########");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
