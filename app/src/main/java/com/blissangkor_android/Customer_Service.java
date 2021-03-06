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
import android.widget.TextView;

import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.customerTextListAdapter;

/**
 * Created by Gacyou on 2017/11/29.
 */

public class Customer_Service extends AppCompatActivity {

    customerTextListAdapter textListAdapter;
    private  String[] textListStrings;
    private ListView lv;
    private SearchView sv;
    private Button btn, btn2, toolbtn;
    private TextView tooltext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_service);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbtn = (Button) findViewById(R.id.toolbar_button);
        toolbtn.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        toolbtn.setText(R.string.fa_chevron_left);
        toolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText("諮詢中心");


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

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), Customer_QALog.class);
                startActivity(i);
            }
        });

    }
}
