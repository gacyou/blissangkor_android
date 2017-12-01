package com.blissangkor_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import com.blissangkor_android.utils.customerTextListAdapter;

/**
 * Created by Gacyou on 2017/11/29.
 */

public class Customer_Service extends AppCompatActivity {

    customerTextListAdapter textListAdapter;
    private  String[] textListStrings;
    private ListView lv;
    private SearchView sv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_service);

        Toolbar toolbar = (Toolbar) findViewById(R.id.program_toolbar);
        toolbar.setTitle("諮詢中心");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sv = (SearchView)findViewById(R.id.searchView);
        sv.setIconifiedByDefault(false);

        textListStrings = getResources().getStringArray(R.array.sampleStrings);
        lv = (ListView) findViewById(R.id.textList);
        textListAdapter = new customerTextListAdapter(this, textListStrings);
        lv.setAdapter(textListAdapter);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), Customer_QApage.class);
                startActivity(i);
            }
        });

    }
}
