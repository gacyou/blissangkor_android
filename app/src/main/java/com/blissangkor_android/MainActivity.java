package com.blissangkor_android;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;


import com.blissangkor_android.utils.FragmentAdapter;
import com.blissangkor_android.utils.NoScrollViewPager;

import java.util.ArrayList;

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
    private Toolbar mToolbar;
    private NoScrollViewPager mViewPager;

    private FragmentAdapter adapter;
    private long clickTime = 0; // 第一次点击的时间

    private ArrayList<String> titleList = new ArrayList<String>() {{
        add("首頁");
        add("目的地");
        add("購物車");
        add("旅伴系統");
        add("我的收藏");
        add("個人中心");
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

        mViewPager = (NoScrollViewPager) findViewById(R.id.pager);
        mTablayout = (TabLayout) findViewById(R.id.tabs);

        adapter = new FragmentAdapter(getSupportFragmentManager(), titleList, fragmentList);
        mViewPager.setAdapter(adapter);
        mTablayout.setupWithViewPager(mViewPager, true);
        mTablayout.setTabsFromPagerAdapter(adapter);

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
