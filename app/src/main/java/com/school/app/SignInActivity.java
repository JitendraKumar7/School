package com.school.app;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.school.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.txtMessage)
    TextView tvMessage;

    @BindView(R.id.txtEmailId)
    EditText tvEmailId;

    @BindView(R.id.txtPassword)
    EditText tvPassword;

    int email = 0;
    boolean type = false;

    @OnClick({R.id.btnSignIn,
            R.id.btnSignUp,
            R.id.btnPassword})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                if (type) {
                    String email = tvEmailId.getText().toString();
                    String password = tvPassword.getText().toString();
                    if (email.length() > 0 && password.length() > 0) {
                        switch (this.email) {
                            case 0:
                                if (email.equals("PankajAdmin@gmail.com") &&
                                        password.equals("Pankaj@123"))
                                    launchIntent(DashboardActivity.class, true);
                                break;

                            case 1:
                                if (email.equals("PankajTeacher@gmail.com") &&
                                        password.equals("Pankaj@123"))
                                    launchIntent(DashboardActivity.class, true);
                                break;

                            case 2:
                                if (email.equals("PankajParent@gmail.com") &&
                                        password.equals("Pankaj@123"))
                                    launchIntent(DashboardActivity.class, true);
                                break;


                            case 3:
                                if (email.equals("PankajStudent@gmail.com") &&
                                        password.equals("Pankaj@123"))
                                    launchIntent(DashboardActivity.class, true);
                                break;
                            default:
                                break;
                        }
                    } else {
                        tvEmailId.setError("Required");
                        tvPassword.setError("Required");
                    }
                } else {
                    showToast("Please Select User Type");
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence val = item.getTitle();
        switch (item.getItemId()) {
            case R.id.nav_admin:
                email = 0;
                break;
            case R.id.nav_teacher:
                email = 1;
                break;
            case R.id.nav_parent:
                email = 2;
                break;
            case R.id.nav_student:
                email = 3;
                break;
            default:
                email = 4;
                break;
        }
        type = true;
        tvMessage.setText(String.format(MESSAGE, val));
        return super.onOptionsItemSelected(item);
    }
}
