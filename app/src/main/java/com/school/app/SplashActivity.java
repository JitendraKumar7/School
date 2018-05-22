package com.school.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.school.app.base.BaseActivity;

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.postDelayed(new Runnable() {
            @Override
                public void run() {

        launchIntent(DashboardActivity.class, true);
                }
            },3000);
    }
}
