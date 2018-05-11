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

public class MainActivity extends BaseActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
