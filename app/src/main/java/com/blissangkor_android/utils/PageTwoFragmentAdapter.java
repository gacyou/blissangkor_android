package com.blissangkor_android.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Gacyou on 2017/11/23.
 */

public class PageTwoFragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> titleList;
    private ArrayList<Fragment> fragmentList;

    private FragmentTransaction mCurTransaction = null;
    private  FragmentManager mFragmentManager;
    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList<Fragment.SavedState>();

    public PageTwoFragmentAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.mFragmentManager = fm;
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment)object;

        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        while (mSavedState.size() <= position) {
            mSavedState.add(null);
        }
        mSavedState.set(position, mFragmentManager.saveFragmentInstanceState(fragment));
        fragmentList.set(position, null);

        mCurTransaction.remove(fragment);
    }

}
