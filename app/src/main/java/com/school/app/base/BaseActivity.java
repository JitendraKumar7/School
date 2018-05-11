package com.school.app.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.school.app.utility.AppConstants;

import static android.view.Gravity.CENTER;

@SuppressWarnings("All")
public abstract class BaseActivity extends AppCompatActivity implements AppConstants {

    private Toast toast = null;
    protected Gson gson = new Gson();
    protected Handler handler = new Handler();
    protected Activity activity = BaseActivity.this;

    protected void showToast(String message) {
        if (toast == null) toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        toast.setGravity(CENTER, 0, 0);
        toast.show();
    }

    protected void launchIntent(Class<? extends Activity> cls, boolean finish) {
        Intent intent = new Intent(activity, cls);
        startActivity(intent);
        if (finish) finish();
    }

}
