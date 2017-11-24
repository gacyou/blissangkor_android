package com.blissangkor_android.utils;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.blissangkor_android.R;

/**
 * Created by Gacyou on 2017/11/23.
 */

public class PageTwoPagerAdapter extends PagerAdapter {

    private Activity mActivity;
    public PageTwoPagerAdapter(Activity activity) {

        mActivity = activity;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Item " + (position + 1);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.pagetwo_p1, container, false);


        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
