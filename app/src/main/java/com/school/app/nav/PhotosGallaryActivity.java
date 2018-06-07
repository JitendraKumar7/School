package com.school.app.nav;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.school.app.R;
import com.school.app.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotosGallaryActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.welcome)
    ImageView welcome;

    @BindView(R.id.study2)
    ImageView study2;

    @BindView(R.id.fun_games_3)
    ImageView fun_games_3;

    @BindView(R.id.fun_games_2)
    ImageView fun_games_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Picasso.get().load(BASE + "welcome.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(welcome);

        Picasso.get().load(BASE + "study2.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(study2);

        Picasso.get().load(BASE + "fun_games_3.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_3);

        Picasso.get().load(BASE + "fun_games_2.png")
                .placeholder(R.drawable.ic_launcher_web)
                .into(fun_games_2);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
