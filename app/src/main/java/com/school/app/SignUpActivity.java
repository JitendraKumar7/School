package com.school.app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.school.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.txtEmailId)
    EditText tvEmailId;

    @BindView(R.id.txtPassword)
    EditText tvPassword;

    @BindView(R.id.txtConfirm)
    EditText tvConfirm;

    @OnClick({R.id.btnSignIn,
            R.id.btnSignUp,
            R.id.btnPassword})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                String email = tvEmailId.getText().toString();
                String password = tvPassword.getText().toString();
                String confirm = tvConfirm.getText().toString();
                if (email.length() > 0 && password.length() > 0) {
                    if (password.equals(confirm))
                        launchIntent(DashboardActivity.class, true);
                    else tvConfirm.setError("Password Doesn't Match");
                } else {
                    tvEmailId.setError("Required");
                    tvPassword.setError("Required");
                }

                break;
            case R.id.btnSignUp:
                break;
            case R.id.btnPassword:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }
}
