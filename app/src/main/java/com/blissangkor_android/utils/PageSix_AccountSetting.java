package com.blissangkor_android.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.blissangkor_android.R;

/**
 * Created by Gacyou on 2017/12/4.
 */

public class PageSix_AccountSetting extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_six_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.program_toolbar);
        toolbar.setTitle((String) this.getResources().getText(R.string.account_setting));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
