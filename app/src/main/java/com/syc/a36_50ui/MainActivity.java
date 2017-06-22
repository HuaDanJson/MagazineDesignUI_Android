package com.syc.a36_50ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void edit(View view) {
        startActivity(new Intent(this,EditActivity.class));
    }

    //协调布局
    public void coordinator(View view) {
        startActivity(new Intent(this,CoordinatorActivity.class));
    }

    public void complexUi(View view) {
        startActivity(new Intent(this,ComplexUiActivity.class));
    }
}
