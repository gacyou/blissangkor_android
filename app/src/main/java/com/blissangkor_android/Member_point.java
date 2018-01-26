package com.blissangkor_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blissangkor_android.utils.FontManager;

/**
 * Created by Gacyou on 2017/12/7.
 */

public class Member_point extends AppCompatActivity{

    private Button toolbtn;
    private TextView tooltext,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_six_point);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbtn = (Button) findViewById(R.id.toolbar_button);
        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText(getResources().getText(R.string.integral));

        toolbtn.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        toolbtn.setText(R.string.fa_chevron_left);
        toolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        tv2.setText(R.string.fa_gift);

    }

}
