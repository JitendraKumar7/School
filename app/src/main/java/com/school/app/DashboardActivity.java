package com.school.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.school.app.base.BaseActivity;
import com.school.app.nav.AboutActivity;
import com.school.app.nav.AccountSectionsActivity;
import com.school.app.nav.MapsActivity;
import com.school.app.nav.NoticeBoardActivity;
import com.school.app.nav.PhotosGallaryActivity;
import com.school.app.nav.PrincipleMessageActivity;
import com.school.app.nav.StudentsActivity;
import com.school.app.utility.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_about:
                launchIntent(AboutActivity.class, false);
                break;

            case R.id.nav_location:
                launchIntent(MapsActivity.class, false);
                break;

            case R.id.nav_message:
                launchIntent(PrincipleMessageActivity.class, false);
                break;

            case R.id.nav_gallary:
                launchIntent(PhotosGallaryActivity.class, false);
                break;

            case R.id.nav_rate:
                Helper.rateApp(activity);
                break;

            case R.id.nav_contact:
                showToast("Coming Soon...");
                break;

            case R.id.nav_share:
                Helper.shareApp(activity);
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
