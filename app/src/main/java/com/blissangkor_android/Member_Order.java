package com.blissangkor_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.Member_Order_FragmentAdapter;
import com.blissangkor_android.utils.Member_Order_p1;
import com.blissangkor_android.utils.Member_Order_p2;
import com.blissangkor_android.utils.NoScrollViewPager;
import com.blissangkor_android.utils.PageTwoFragmentAdapter;

import java.util.ArrayList;

/**
 * Created by Gacyou on 2017/12/7.
 */

public class Member_Order extends AppCompatActivity {

    private android.support.design.widget.TabLayout mTabs;
    private NoScrollViewPager mViewPager;
    private Member_Order_FragmentAdapter adapter;
    private Button toolbtn;
    private TextView tooltext;

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new Member_Order_p1());
        add(new Member_Order_p2());
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_order);

        ArrayList<String> titleList = new ArrayList<String>() {{
            add((String) getResources().getText(R.string.nPayOrder));
            add((String) getResources().getText(R.string.historyOrder));
        }};

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbtn = (Button) findViewById(R.id.toolbar_button);
        tooltext = (TextView) findViewById(R.id.toolbar_text);
        tooltext.setText(getResources().getText(R.string.my_Order));

        toolbtn.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        toolbtn.setText(R.string.fa_chevron_left);
        toolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mTabs = (android.support.design.widget.TabLayout) findViewById(R.id.tabs);
        mViewPager = (NoScrollViewPager) findViewById(R.id.viewpager);

        adapter = new Member_Order_FragmentAdapter(getSupportFragmentManager(), titleList, fragmentList);
        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager, true);
        mTabs.setTabsFromPagerAdapter(adapter);
    }

}
