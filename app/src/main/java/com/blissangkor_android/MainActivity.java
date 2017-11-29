package com.blissangkor_android;


import android.nfc.tech.NfcV;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.FragmentAdapter;
import com.blissangkor_android.utils.NoScrollViewPager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.blissangkor_android.utils.Setting.abc;

/**
 *　　　　　　　　┏┓　　　┏┓+ +
 *　　　　　　　┏┛┻━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　　┃ 　
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 ████━████ ┃+
 *　　　　　　　┃　　　　　　　┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　　┃ + +
 *　　　　　　　┗━┓　　　┏━┛
 *　　　　　　　　　┃　　　┃　　　　　　　　　　　
 *　　　　　　　　　┃　　　┃ + + + +
 *　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting　　　　　　　
 *　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug　　
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+　　　　　　　　　
 *　　　　　　　　　┃　 　　┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 *　　　　　　　　　　┃┫┫　┃┫┫
 *　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    public  NoScrollViewPager Nvpager;

    private FragmentAdapter adapter;
    private long clickTime = 0; // 第一次点击的时间

    private TextView tab1, tab2, tab3, tab4, tab5, tab6;

    private ArrayList<String> titleList = new ArrayList<String>() {{
        add("");
        add("");
        add("");
        add("旅伴系統");
        add("");
        add("");
    }};

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new PageOne());
        add(new PageTwo());
        add(new PageThree());
        add(new PageFour());
        add(new PageFive());
        add(new PageSix());
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nvpager = (NoScrollViewPager) findViewById(R.id.pager);
        mTablayout = (TabLayout) findViewById(R.id.tabs);

        adapter = new FragmentAdapter(getSupportFragmentManager(), titleList, fragmentList);
        Nvpager.setAdapter(adapter);
        mTablayout.setupWithViewPager(Nvpager, true);
        mTablayout.setTabsFromPagerAdapter(adapter);

        tab1 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab1.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        tab1.setText(R.string.fa_globe);
        tab1.setTextColor(getResources().getColor(R.color.colorTab));
        mTablayout.getTabAt(0).setCustomView(tab1);

        tab2 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab2.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        tab2.setText(R.string.fa_map_marker);
        mTablayout.getTabAt(1).setCustomView(tab2);

        tab3 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab3.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        tab3.setText(R.string.fa_shopping_cart);
        mTablayout.getTabAt(2).setCustomView(tab3);

        tab4 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab4.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        tab4.setText(R.string.fa_handshake_o);
        mTablayout.getTabAt(3).setCustomView(tab4);

        tab5 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab5.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        tab5.setText(R.string.fa_bookmark);
        mTablayout.getTabAt(4).setCustomView(tab5);

        tab6 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab6.setTypeface(FontManager.getTypeface(this,FontManager.FONTAWESOME));
        tab6.setText(R.string.fa_user);
        mTablayout.getTabAt(5).setCustomView(tab6);

        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

               if(tab.getPosition() == 0)
               {
                   tab1.setTextColor(getResources().getColor(R.color.colorTab));

                   tab2.setTextColor(getResources().getColor(R.color.black));
                   tab3.setTextColor(getResources().getColor(R.color.black));
                   tab4.setTextColor(getResources().getColor(R.color.black));
                   tab5.setTextColor(getResources().getColor(R.color.black));
                   tab6.setTextColor(getResources().getColor(R.color.black));
                   adapter.notifyDataSetChanged();
               }
               else if(tab.getPosition() == 1)
               {
                   tab2.setTextColor(getResources().getColor(R.color.colorTab));

                   tab1.setTextColor(getResources().getColor(R.color.black));
                   tab3.setTextColor(getResources().getColor(R.color.black));
                   tab4.setTextColor(getResources().getColor(R.color.black));
                   tab5.setTextColor(getResources().getColor(R.color.black));
                   tab6.setTextColor(getResources().getColor(R.color.black));
                   adapter.notifyDataSetChanged();
               }
               else if(tab.getPosition() == 2)
               {
                   tab3.setTextColor(getResources().getColor(R.color.colorTab));

                   tab1.setTextColor(getResources().getColor(R.color.black));
                   tab2.setTextColor(getResources().getColor(R.color.black));
                   tab4.setTextColor(getResources().getColor(R.color.black));
                   tab5.setTextColor(getResources().getColor(R.color.black));
                   tab6.setTextColor(getResources().getColor(R.color.black));
                   adapter.notifyDataSetChanged();
               }
               else if(tab.getPosition() == 3)
               {
                   tab4.setTextColor(getResources().getColor(R.color.colorTab));

                   tab1.setTextColor(getResources().getColor(R.color.black));
                   tab2.setTextColor(getResources().getColor(R.color.black));
                   tab3.setTextColor(getResources().getColor(R.color.black));
                   tab5.setTextColor(getResources().getColor(R.color.black));
                   tab6.setTextColor(getResources().getColor(R.color.black));
                   adapter.notifyDataSetChanged();
               }
               else if(tab.getPosition() == 4)
               {
                   tab5.setTextColor(getResources().getColor(R.color.colorTab));

                   tab1.setTextColor(getResources().getColor(R.color.black));
                   tab2.setTextColor(getResources().getColor(R.color.black));
                   tab3.setTextColor(getResources().getColor(R.color.black));
                   tab4.setTextColor(getResources().getColor(R.color.black));
                   tab6.setTextColor(getResources().getColor(R.color.black));
                   adapter.notifyDataSetChanged();
               }
               else if(tab.getPosition() == 5)
               {
                   tab6.setTextColor(getResources().getColor(R.color.colorTab));

                   tab1.setTextColor(getResources().getColor(R.color.black));
                   tab2.setTextColor(getResources().getColor(R.color.black));
                   tab3.setTextColor(getResources().getColor(R.color.black));
                   tab4.setTextColor(getResources().getColor(R.color.black));
                   tab5.setTextColor(getResources().getColor(R.color.black));
                   adapter.notifyDataSetChanged();
               }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    public void onBackPressed() {
        exit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 是否触发按键为back键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        } else { // 如果不是back键正常响应
            return super.onKeyDown(keyCode, event);
        }
    }
    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(this, "再按一次後退出App", Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            this.finish();
        }
    }


}
