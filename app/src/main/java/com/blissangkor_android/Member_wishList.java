package com.blissangkor_android;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.PageFive_ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gacyou on 2017/12/7.
 */

public class Member_wishList extends AppCompatActivity {

    private Context mcontext;

    private Button toolbtn;
    private TextView tooltext;

    private ListView list ;
    private static final int[] pictures = { R.drawable.p1080x445, R.drawable.p1080x445, R.drawable.p1080x445 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_six_wishlist);

        mcontext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbtn = (Button) findViewById(R.id.toolbar_button);
        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText(getResources().getText(R.string.wish_list));

        toolbtn.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        toolbtn.setText(R.string.fa_chevron_left);
        toolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        list = (ListView) findViewById(R.id.wishList);
        List<Integer> wish_list = new ArrayList<Integer>();
        for(int i : pictures){wish_list.add(i);}
        PageFive_ListAdapter mAdapter = new PageFive_ListAdapter(this, wish_list);
        list.setAdapter(mAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mcontext,"你按的是第" + (i+1) + "個",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
