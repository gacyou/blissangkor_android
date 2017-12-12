package com.blissangkor_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.blissangkor_android.utils.FontManager;

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
        toolbtn.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        toolbtn.setText(R.string.fa_chevron_left);
        toolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText("諮詢表單");

    }
}
