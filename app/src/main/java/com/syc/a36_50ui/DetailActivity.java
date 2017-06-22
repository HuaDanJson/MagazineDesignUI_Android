package com.syc.a36_50ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailActivity extends Activity {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolBar = (Toolbar) findViewById(R.id.tool_detail);
        CollapsingToolbarLayout collapseLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_layout);
        ImageView ivDetail = (ImageView) findViewById(R.id.iv_detail);
        FloatingActionButton floatingDetail = (FloatingActionButton) findViewById(R.id.floating_detail);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        String logo = intent.getStringExtra("logo");
        Log.i("TAG", "logo=" + logo);

        //toolBar.setTitle(name);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolBar.inflateMenu(R.menu.second);
            toolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        //图片
        int imgId = getResources().getIdentifier(logo, "mipmap", getPackageName());
        Log.i("TAG", "id=" + imgId);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgId);
        ivDetail.setImageBitmap(bitmap);

        //处理折叠和展开时的文字颜色
        collapseLayout.setTitle(name);
        //设置折叠时候的标题文字颜色
        collapseLayout.setCollapsedTitleTextColor(Color.WHITE);
        //设置展开时候的标题文字颜色
        collapseLayout.setExpandedTitleColor(Color.RED);

        floatingDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "选择了" + name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
