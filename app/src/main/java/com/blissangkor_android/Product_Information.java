package com.blissangkor_android;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.Setting;
import com.blissangkor_android.utils.Util;
import com.socks.library.KLog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gacyou on 2017/12/5.
 */

public class Product_Information extends AppCompatActivity{


    private TextView tooltext, tv, tv2;
    private String id;
    private Button toolbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbtn =  (Button) findViewById(R.id.toolbar_button);
        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);

        toolbtn.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        toolbtn.setText(R.string.fa_chevron_left);
        toolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tooltext.setText("商品內容");

        Intent i = getIntent();
        id = i.getStringExtra("id");

        new getProductTask().execute();
    }


   class getProductTask extends AsyncTask<Void, Void, getProductTask.ReturnClass> {

        @Override
        protected ReturnClass doInBackground(Void... voids) {
            ReturnClass r = new ReturnClass();

            try {

                String url = Setting.getProductInfor + id;
                String retSrc = Util.getJson(url);
                JSONObject j = new JSONObject(retSrc);
                r.country = j.getString("country");
                r.city = j.getString("city");
                r.title = j.getString("title");
                r.subTitle = j.getString("subTitle");
                return r;
            }
            catch (Exception e) {
                e.printStackTrace();
                return r;
            }

        }
        @Override
        protected void onPostExecute(final ReturnClass result) {

            KLog.d("gggggggg",result.country);
            KLog.d("gggggggg",result.city);
            KLog.d("gggggggg",result.title);
            KLog.d("gggggggg",result.subTitle);

            tv.setText(result.title);
            tv2.setText(result.subTitle);

        }


        class ReturnClass {
            public String country;
            public String city;
            public String title;
            public String subTitle;
        }

    }
}
