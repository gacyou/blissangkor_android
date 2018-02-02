package com.blissangkor_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.NoScrollViewPager;
import com.blissangkor_android.utils.PageSix_ListAdapter;
import com.blissangkor_android.utils.PageSix_info_ListAdapter;

import java.util.ArrayList;

/**
 * Created by Gacyou on 2017/12/7.
 */

public class Member_information extends AppCompatActivity {

    private Button toolbtn;
    private TextView tooltext;
    private String[] str;
    private PageSix_info_ListAdapter mAdapter;
    private android.support.design.widget.TabLayout mTabs;
    private NoScrollViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_six_member_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbtn = (Button) findViewById(R.id.toolbar_button);
        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText(getResources().getText(R.string.edit));

        toolbtn.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        toolbtn.setText(R.string.fa_chevron_left);
        toolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ListView mlist = (ListView) findViewById(R.id.list);

        ArrayList<String> str = new ArrayList<String>() {{
            add((String) "更換頭像");
        }};

        mAdapter = new PageSix_info_ListAdapter(this, str);
        mlist.setAdapter(mAdapter);
        mlist.setOnItemClickListener(onClickListView);

        mTabs = (android.support.design.widget.TabLayout) findViewById(R.id.tabs);
        mViewPager = (NoScrollViewPager) findViewById(R.id.viewpager);

    }


    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch( position ) {
                case 0:
                    Toast.makeText(view.getContext(),"功能還沒做喔",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
}
