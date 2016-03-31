package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.administrator.custemview.R;

/**
 * Created by zchao on 2016/3/21.
 */
public class CustemViewTest extends FrameLayout {
    public CustemViewTest(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.test_layout, this);
    }
}
