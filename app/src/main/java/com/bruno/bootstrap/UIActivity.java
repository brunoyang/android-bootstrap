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

public class UIActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    EditText nameEditText;
    EditText pwdEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        initView();
    }

    private void initView() {
        this.nameEditText = (EditText) findViewById(R.id.ui_name_edittext);
        this.nameEditText.addTextChangedListener(this);

        this.pwdEditText = (EditText) findViewById(R.id.ui_pwd_edittext);
        this.pwdEditText.addTextChangedListener(this);

        this.loginButton = (Button) findViewById(R.id.ui_login);
        this.loginButton.setOnClickListener(this);

        findViewById(R.id.goto_login).setOnClickListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        System.out.println("before");
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (this.pwdEditText.getText().toString().length() > 0 &&
                this.nameEditText.getText().toString().length() > 0) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        System.out.println("after");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goto_login: {
                startActivity(new Intent(this, LoginActivity.class));
                break;
            }
            case R.id.ui_login: {
                if (compareNameAndPwd()) {
                    System.out.println(1111);
                    finish();
                } else {
                    showLoginFailedMsg();
                }
                break;
            }
        }
    }

    private boolean compareNameAndPwd() {
        PreferenceUtils preferenceUtils = new PreferenceUtils(this);

        if ((this.nameEditText.getText().toString().trim().isEmpty() ||
                this.pwdEditText.getText().toString().trim().isEmpty())) {
            return false;
        }

        if (preferenceUtils.getStringParam("name").equals(this.nameEditText.getText().toString()) &&
                preferenceUtils.getStringParam("pwd").equals(this.pwdEditText.getText().toString())) {
            System.out.println(preferenceUtils.getStringParam("name"));
            System.out.println(this.nameEditText.getText().toString());
            System.out.println((preferenceUtils.getStringParam("name").equals(this.nameEditText.getText().toString())));
            return true;
        } else {
            return false;
        }
    }

    private void showLoginFailedMsg() {
        Toast.makeText(this, "是不是用户名或密码记错了？", Toast.LENGTH_SHORT).show();
    }
}
