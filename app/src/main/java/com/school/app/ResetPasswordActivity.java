package com.school.app;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.school.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.txtOTP)
    EditText tvEmailId;

    @BindView(R.id.txtPassword)
    EditText tvPassword;

    @BindView(R.id.txtConfirm)
    EditText tvConfirm;

    @OnClick({R.id.btnResendOTP,
            R.id.btnResetPassword})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnResendOTP:
                showToast("OTP Send Successfully!");
                break;
            case R.id.btnResetPassword:
                String email = tvEmailId.getText().toString();
                String password = tvPassword.getText().toString();
                String confirm = tvConfirm.getText().toString();
                if (email.length() > 0 && password.length() > 0) {
                    if (password.equals(confirm))
                        launchIntent(SignInActivity.class, true);
                    else tvConfirm.setError("Password Doesn't Match");
                } else {
                    tvEmailId.setError("Required");
                    tvPassword.setError("Required");
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }
}
