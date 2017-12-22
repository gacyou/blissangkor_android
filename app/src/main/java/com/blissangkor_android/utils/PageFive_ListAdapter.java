package com.blissangkor_android.utils;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.blissangkor_android.R;

import java.util.List;

/**
 * Created by Gacyou on 2017/12/22.
 */

public class PageFive_ListAdapter extends BaseAdapter{

    private final Context mContext;
    private List<Integer> mitem;
    private LayoutInflater mLayInf;

    public PageFive_ListAdapter(Context context, List<Integer> item ) {
        mContext  = context;
        mitem = item;
        mLayInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        View v = mLayInf.inflate(R.layout.page_five_wishlist_item, viewGroup, false);
        // 佈局元件內容
        ImageView imageView = (ImageView) v.findViewById(R.id.listImage);
        imageView.setImageResource(mitem.get(i));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return v;
    }
}
