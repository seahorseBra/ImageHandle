package com.example.administrator.custemview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import javaBean.Print;
import javaBean.Student;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    @Bind(R.id.main_activity_imghandle)
    Button mImgHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mImgHandle.setOnClickListener(this);
    }


    private void testGson() {
        Gson gson = new Gson();

        Student stu1 = new Student();
        stu1.setUserID(1);
        stu1.setUserName("阿花");
        stu1.setUserNickName("qq");
        stu1.setBirthDay(new Date());

        Student stu2 = new Student();
        stu2.setUserID(2);
        stu2.setUserName("笑话");
        stu2.setUserNickName("ww");

        Student stu3 = new Student();
        stu3.setUserID(3);
        stu3.setUserName("各位");
        stu3.setUserNickName("ee");

        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        String simpleBean = gson.toJson(stu1);
        Student stu4 = gson.fromJson(simpleBean, Student.class);

        String listToGson = gson.toJson(list);
        List<Student> list1 = gson.fromJson(listToGson, new TypeToken<ArrayList<Student>>() {
        }.getType());

        System.out.println(simpleBean);
        System.out.println(stu4);
        System.out.println(listToGson);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    private void testGson1() {
        Gson gson = new GsonBuilder()
                .generateNonExecutableJson()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .setVersion(1)
                .create();

        Student stu1 = new Student();
        stu1.setUserID(1);
        stu1.setUserName("阿花");
        stu1.setUserNickName("qq");
        stu1.setBirthDay(new Date());

        Student stu2 = new Student();
        stu2.setUserID(2);
        stu2.setUserName("笑话");
        stu2.setUserNickName("ww");

        Student stu3 = new Student();
        stu3.setUserID(3);
        stu3.setUserName("各位");
        stu3.setUserNickName("ee");

        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        String simpleBean = gson.toJson(stu1);
        Student stu4 = gson.fromJson(simpleBean, Student.class);

        String listToGson = gson.toJson(list);
        List<Student> list1 = gson.fromJson(listToGson, new TypeToken<List<Student>>() {
        }.getType());

        System.out.println(simpleBean);
        System.out.println(stu4);
        System.out.println(listToGson);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    private void testGson2() {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .create();

        Map<Print, String> map = new LinkedHashMap<>();
        map.put(new Print(1, 2), "a");
        map.put(new Print(2, 3), "b");

        String map1 = gson.toJson(map);
        System.out.println(map1);

        Map<Print, String> map2 = gson.fromJson(map1, new TypeToken<Map<Print, String>>() {
        }.getType());
        for (Print n : map2.keySet()) {
            System.out.println(n.toString() + n);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_imghandle:
                goActivity(ImageHandleActivity.class);
                break;
        }
    }

    private void goActivity(Class cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
}
