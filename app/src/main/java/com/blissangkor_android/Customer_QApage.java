package com.blissangkor_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Gacyou on 2017/12/1.
 */

public class Customer_QApage extends AppCompatActivity {

    private TextView tooltext;
    private Button   toolbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_qapage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbtn = (Button) findViewById(R.id.toolbar_button);


        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText("諮詢表單");

    }
}
