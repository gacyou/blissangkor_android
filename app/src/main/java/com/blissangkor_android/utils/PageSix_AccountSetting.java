package com.blissangkor_android.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blissangkor_android.R;

/**
 * Created by Gacyou on 2017/12/4.
 */

public class PageSix_AccountSetting extends AppCompatActivity {

    private TextView tooltext;
    private Button   toolbtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_six_account);

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
        tooltext.setText(R.string.account_setting);

    }
}
