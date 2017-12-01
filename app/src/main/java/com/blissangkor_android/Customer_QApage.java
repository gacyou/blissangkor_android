package com.blissangkor_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Gacyou on 2017/12/1.
 */

public class Customer_QApage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_qapage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.program_toolbar);
        toolbar.setTitle("諮詢表單");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
