package com.syc.a36_50ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends Activity {

    private EditText etPwd;
    private TextInputLayout mTiL;
    private TextInputEditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_acitity);

        etPwd = (EditText) findViewById(R.id.et_pass);
        mEdit = (TextInputEditText) findViewById(R.id.et_name);
        mTiL = (TextInputLayout) findViewById(R.id.til);
    }

    public void login(View view) {
        String pwd = etPwd.getText().toString();
        if ("123".equals(pwd)) {
            //app:errorEnable
            mTiL.setErrorEnabled(true);
            //设置提示信息
            mTiL.setError("密码正确");
        } else {
            mTiL.setError("密码错误");
        }

        String name = mEdit.getText().toString();
        if ("abc".equals(name)) {
            mEdit.setError("输入正确");
        } else {
            mEdit.setError("输入错误");
        }
    }
}
