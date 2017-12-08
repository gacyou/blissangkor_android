package com.blissangkor_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gacyou on 2017/12/4.
 */

public class Customer_QALog extends AppCompatActivity {

    private TextView tooltext;
    private Button   toolbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_qalog);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbtn = (Button) findViewById(R.id.toolbar_button);


        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText("諮詢紀錄");

    }
}
