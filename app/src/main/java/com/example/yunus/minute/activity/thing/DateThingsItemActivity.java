package com.example.yunus.minute.activity.thing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.yunus.minute.R;

import java.sql.Date;

public class DateThingsItemActivity extends AppBaseActivity {

    private static final String TAG = "DateThingsItemActivity";

    private Toolbar toolbar;
    private String date;
    private DrawerLayout drawerLayout;
    private FloatingActionButton fab;
    private TextView title;

    @Override
    protected void initVariables() {
        Log.d(TAG, "initVariables: ");
        Intent intent = getIntent();
        if (intent == null) {
            date = new Date(System.currentTimeMillis()).toString();
            Log.d(TAG, "initVariables: " + date);
        } else {
            date = intent.getStringExtra("data");
            Log.d(TAG, "initVariables: " + date);
        }

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.act_thing_datethingsitem);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // App Logo
        //toolbar.setLogo(R.drawable);
        // Title
        toolbar.setTitle("");
        title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(date);
        setSupportActionBar(toolbar);
        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
        // 否則會出現 back button
        toolbar.setNavigationIcon(R.drawable.common_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DateThingsItemActivity.this, AddThingActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
