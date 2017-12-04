package com.blissangkor_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blissangkor_android.utils.FragmentAdapter;
import com.blissangkor_android.utils.NoScrollViewPager;
import com.blissangkor_android.utils.PageTwoFragmentAdapter;
import com.blissangkor_android.utils.PageTwoPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Gacyou on 2017/11/15.
 */

public class PageTwo extends android.support.v4.app.Fragment {

    private Activity mActivity;

    private android.support.design.widget.TabLayout mTabs;
    private NoScrollViewPager mViewPager;
    private PageTwoFragmentAdapter adapter;

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new PageTwo_p1());
        add(new PageTwo_p2());
    }};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_two, container, false);

        mActivity = getActivity();

         ArrayList<String> titleList = new ArrayList<String>() {{
            add((String) mActivity.getResources().getText(R.string.hot_local));
            add((String) mActivity.getResources().getText(R.string.all));
        }};

        mTabs = (android.support.design.widget.TabLayout) view.findViewById(R.id.tabs);
        mViewPager = (NoScrollViewPager) view.findViewById(R.id.viewpager);

        adapter = new PageTwoFragmentAdapter(getChildFragmentManager(), titleList, fragmentList);
        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager, true);
        mTabs.setTabsFromPagerAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}