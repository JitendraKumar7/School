package com.school.app;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.school.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.txtEmailId)
    EditText tvEmailId;

    @OnClick({R.id.btnResetPassword})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnResetPassword:
                String email = tvEmailId.getText().toString();
                if (email.length() > 0) {
                    showToast("OTP Send Successfully!");
                    launchIntent(ResetPasswordActivity.class, true);
                } else {
                    tvEmailId.setError("Required");
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

}
