package com.school.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.school.app.base.BaseActivity;
import com.school.app.nav.AboutActivity;
import com.school.app.nav.MapsActivity;
import com.school.app.nav.ContactActivity;
import com.school.app.nav.PhotosGallaryActivity;
import com.school.app.nav.PrincipleMessageActivity;
import com.school.app.utility.Helper;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView nav_view;

    @BindView(R.id.welcome)
    ImageView welcome;

    @BindView(R.id.welcome_1)
    ImageView welcome_1;

    @BindView(R.id.welcome_2)
    ImageView welcome_2;

    @BindView(R.id.study1)
    ImageView study1;

    @BindView(R.id.study2)
    ImageView study2;

    @BindView(R.id.study3)
    ImageView study3;

    @BindView(R.id.study4)
    ImageView study4;

    @BindView(R.id.study5)
    ImageView study5;

    @BindView(R.id.study6)
    ImageView study6;

    @BindView(R.id.computer_lab_1)
    ImageView computer_lab_1;

    @BindView(R.id.computer_lab_2)
    ImageView computer_lab_2;

    @BindView(R.id.computer_lab_3)
    ImageView computer_lab_3;

    @BindView(R.id.computer_lab_4)
    ImageView computer_lab_4;

    @BindView(R.id.computer_lab_5)
    ImageView computer_lab_5;

    @BindView(R.id.fun_games_1)
    ImageView fun_games_1;

    @BindView(R.id.fun_games_2)
    ImageView fun_games_2;

    @BindView(R.id.fun_games_3)
    ImageView fun_games_3;

    @BindView(R.id.fun_games_7)
    ImageView fun_games_7;

    @BindView(R.id.fun_games_8)
    ImageView fun_games_8;

    @BindView(R.id.fun_games_9)
    ImageView fun_games_9;

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

        nav_view.setNavigationItemSelectedListener(this);

        Picasso.get().load(BASE + "welcome.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(welcome);

        Picasso.get().load(BASE + "welcome_1.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(welcome_1);

        Picasso.get().load(BASE + "welcome_2.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(welcome_2);

        Picasso.get().load(BASE + "study1.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(study1);

        Picasso.get().load(BASE + "study2.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(study2);

        Picasso.get().load(BASE + "study3.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(study3);

        Picasso.get().load(BASE + "study4.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(study4);

        Picasso.get().load(BASE + "study5.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(study5);

        Picasso.get().load(BASE + "study6.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(study6);

        Picasso.get().load(BASE + "computer_lab_1.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(computer_lab_1);

        Picasso.get().load(BASE + "computer_lab_2.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(computer_lab_2);

        Picasso.get().load(BASE + "computer_lab_3.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(computer_lab_3);

        Picasso.get().load(BASE + "computer_lab_4.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(computer_lab_4);

        Picasso.get().load(BASE + "computer_lab_5.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(computer_lab_5);

        Picasso.get().load(BASE + "fun_games_1.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_1);

        Picasso.get().load(BASE + "fun_games_2.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_2);

        Picasso.get().load(BASE + "fun_games_3.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_3);

        Picasso.get().load(BASE + "fun_games_7.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_7);

        Picasso.get().load(BASE + "fun_games_8.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_8);

        Picasso.get().load(BASE + "fun_games_9.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_9);
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
                launchIntent(ContactActivity.class, false);
                break;

            case R.id.nav_share:
                Helper.shareApp(activity);
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
