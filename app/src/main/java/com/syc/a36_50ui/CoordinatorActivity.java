package com.syc.a36_50ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

public class CoordinatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SnackBar的用法--->升级版的Toast.
                //①.可以很方便的修改背景色;②.处理点击事件;
                Snackbar snackbar = Snackbar.make(v, "要展示的信息...", Snackbar.LENGTH_LONG).setAction("点我啊", new View.OnClickListener() {//处理点击事件
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CoordinatorActivity.this, "高级的toast", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.parseColor("#E0E1DF"));//改变点击文字的颜色
                //获取Snackbar所在的View
                View view = snackbar.getView();
                //设置背景色
                view.setBackgroundColor(Color.parseColor("#7FB546"));
                //show处理
                snackbar.show();
                //snackbar.dismiss();
            }
        });
    }
}
