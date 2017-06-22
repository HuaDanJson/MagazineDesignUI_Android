package com.syc.a36_50ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class ComplexUiActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private String[] navigations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_complex_ui);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager mVp = (ViewPager) findViewById(R.id.vp);
        NavigationView mNavigations = (NavigationView) findViewById(R.id.navigation_view);

        //版本检查
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Api21以后才出现的方法
            mToolbar.inflateMenu(R.menu.second);
            //处理菜单项的点击事件
            mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_search:
                            Toast.makeText(ComplexUiActivity.this, "搜索...", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_setting:
                            Toast.makeText(ComplexUiActivity.this, "设置...", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return false;
                }
            });

            //处理Home菜单的点击事件
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //打开抽屉
                    if (!mDrawer.isDrawerOpen(Gravity.LEFT)) {
                        mDrawer.openDrawer(Gravity.LEFT);
                    }
                    //关闭抽屉
                    //mDrawer.closeDrawer(Gravity.LEFT);
                    //mDrawer.closeDrawers();
                }
            });
        }

        //API 23以后才出现的方法.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mToolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_more_overflow));
        }

        //导航标签
        navigations = getResources().getStringArray(R.array.navigations);

        //关联适配器
        mVp.setAdapter(new NavigationAdapter(getSupportFragmentManager()));

        //添加导航标签
        //tabLayout.addTab();
        //TabLayout与ViewPager关联在一起.
        tabLayout.setupWithViewPager(mVp, true);
        //导航模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //设置导航指示器的颜色
        //tabLayout.setSelectedTabIndicatorColor();
        //设置导航标签的颜色
        tabLayout.setTabTextColors(Color.GRAY, Color.WHITE);

        //处理导航菜单的点击事件
        mNavigations.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_exit:
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    class NavigationAdapter extends FragmentPagerAdapter {

        NavigationAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position, navigations[position]);
        }

        @Override
        public int getCount() {
            return navigations.length;
        }

        //获取对应的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return navigations[position];
        }
    }
}
