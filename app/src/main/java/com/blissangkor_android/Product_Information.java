package com.blissangkor_android;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.Setting;
import com.blissangkor_android.utils.Util;
import com.socks.library.KLog;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import static com.blissangkor_android.utils.Setting.getProductInfor;

/**
 * Created by Gacyou on 2017/12/5.
 */

public class Product_Information extends AppCompatActivity{


    private TextView tooltext;
    private String id;
    private Button toolbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbtn =  (Button) findViewById(R.id.toolbar_button);
        tooltext = (TextView) findViewById(R.id.toolbar_text);

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


    public class getProductTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {

                String url = Setting.getProductInfor + id;
                String retSrc = Util.getJson(url);
                return retSrc;
            } catch (IOException e1) {
                return "";
            } catch (Exception e2) {
                return "";
            }
        }
        @Override
        protected void onPostExecute(final String result) {

            KLog.d("gggggggg",result);

        }

    }
}
