package com.blissangkor_android.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;

import com.blissangkor_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gacyou on 2017/12/25.
 */

public class PageThree_ListAdapter extends BaseAdapter {


    private LayoutInflater mLayInf;
    private List<Integer> mitem;

    public PageThree_ListAdapter(Context context, List<Integer> itemList)
    {
        mLayInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mitem = itemList;
    }

    @Override
    public int getCount() {
        return mitem.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mLayInf.inflate(R.layout.page_three_listadapter, viewGroup, false);
        ImageView iv = (ImageView) v.findViewById(R.id.imageView);
        iv.setImageResource(mitem.get(i));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return v;
    }
}
