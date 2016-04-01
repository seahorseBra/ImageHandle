package com.example.administrator.custemview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zchao on 2016/3/30.
 */
public class ImageHandleActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int CAMERA = 100;
    private static final String TAG = "ImageHandleActivity";
    @Bind(R.id.account)
    EditText account;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.select_img)
    Button selectImg;
    @Bind(R.id.start_compress)
    Button startCompress;
    @Bind(R.id.save_img)
    Button saveImg;
    @Bind(R.id.image_grid)
    GridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_handle_activity);
        ButterKnife.bind(this);
        selectImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_img:
                selectImage();
                break;
        }
    }

    /**
     * 选择一张照片
     */
    private void selectImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Environment.DIRECTORY_DCIM);
        startActivityForResult(intent, CAMERA);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA && resultCode == Activity.RESULT_OK && null != data) {
            Log.d(TAG, "onActivityResult() called with: " + "requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data.toString() + "]");
        }

    }
}
