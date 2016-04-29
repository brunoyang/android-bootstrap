package com.bruno.bootstrap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    EditText nameEditText;
    EditText pwdEditText;
    EditText rPwdEditText;
    Button signupBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }
    private void initView() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("注册");
//        setSupportActionBar(toolbar);



        nameEditText = (EditText) findViewById(R.id.ui_name_edittext);
        nameEditText.addTextChangedListener(this);

        pwdEditText = (EditText) findViewById(R.id.ui_pwd_edittext);
        pwdEditText.addTextChangedListener(this);

        rPwdEditText = (EditText) findViewById(R.id.ui_rpwd_edittext);
        rPwdEditText.addTextChangedListener(this);

        signupBtn = (Button) findViewById(R.id.signup);
        signupBtn.setOnClickListener(this);

        backBtn = (Button) findViewById(R.id.back);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup: {
                handleSignup();
                break;
            }
            case R.id.back: {
                handleBack();
                break;
            }
        }
    }

    private void handleBack() {
        finish();
    }

    private void handleSignup() {
        String nameStr = nameEditText.getText().toString().trim();
        String pwdStr = pwdEditText.getText().toString().trim();
        String rPwdStr = rPwdEditText.getText().toString().trim();

        if (nameStr.isEmpty() || pwdStr.isEmpty() || rPwdStr.isEmpty()) {
            Toast.makeText(this, "不要留空哦", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pwdStr.equals(rPwdStr)) {
            Toast.makeText(this, "两次输入的密码好像不一样呀", Toast.LENGTH_SHORT).show();
            return;
        } else {
            PreferenceUtils preferenceUtils = new PreferenceUtils(this);
            preferenceUtils.saveParam("name", nameStr);
            preferenceUtils.saveParam("pwd", rPwdStr);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String nameStr = nameEditText.getText().toString().trim();
        String pwdStr = pwdEditText.getText().toString().trim();
        String rPwdStr = rPwdEditText.getText().toString().trim();
        if (nameStr.isEmpty() || pwdStr.isEmpty() || rPwdStr.isEmpty()) {
            signupBtn.setEnabled(false);
        } else {
            signupBtn.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
