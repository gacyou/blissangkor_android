package com.blissangkor_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Gacyou on 2017/12/4.
 */

public class Customer_QALog extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_qalog);

        Toolbar toolbar = (Toolbar) findViewById(R.id.program_toolbar);
        toolbar.setTitle("諮詢紀錄");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
