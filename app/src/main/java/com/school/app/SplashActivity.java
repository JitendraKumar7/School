package com.school.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.school.app.base.BaseActivity;

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchIntent(SignInActivity.class, true);
    }
}
