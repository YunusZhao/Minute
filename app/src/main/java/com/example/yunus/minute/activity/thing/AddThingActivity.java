package com.example.yunus.minute.activity.thing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.yunus.minute.R;

import java.sql.Date;

public class AddThingActivity extends AppBaseActivity {
    private String date;
    private Toolbar toolbar;
    TextView title;

    @Override
    protected void initVariables() {
        Intent intent = getIntent();
        date = intent.getStringExtra("data");
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.act_thing_addthing);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // App Logo
        //toolbar.setLogo(R.drawable);
        // Title
        toolbar.setTitle("");
        title = (TextView) findViewById(R.id.toolbar_title);

        title.setText("增加记录");
        setSupportActionBar(toolbar);
        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
        // 否則會出現 back button
        toolbar.setNavigationIcon(R.drawable.common_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
