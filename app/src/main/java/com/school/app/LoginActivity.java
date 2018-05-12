package com.school.app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.school.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.txtMessage)
    TextView tvMessage;

    @BindView(R.id.txtEmailId)
    EditText tvEmailId;

    @BindView(R.id.txtPassword)
    EditText tvPassword;

    @OnClick({R.id.btnSignIn,
            R.id.btnSignUp,
            R.id.btnPassword})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                String email = tvEmailId.getText().toString();
                String password = tvPassword.getText().toString();
                if (email.length() > 0 && password.length() > 0) {
                    launchIntent(DashboardActivity.class, true);
                } else {
                    tvEmailId.setError("Required");
                    tvPassword.setError("Required");
                }

                break;
            case R.id.btnSignUp:
                launchIntent(SignUpActivity.class, true);
                break;
            case R.id.btnPassword:
                launchIntent(ForgotPasswordActivity.class, true);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence val = item.getTitle();
        switch (item.getItemId()) {
            case R.id.nav_admin:
                break;
            case R.id.nav_teacher:
                break;
            case R.id.nav_parent:
                break;
            case R.id.nav_student:
                break;
        }
        tvMessage.setText(String.format(MESSAGE, val));
        return super.onOptionsItemSelected(item);
    }
}
