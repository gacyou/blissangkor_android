package com.blissangkor_android.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Gacyou on 2018/1/16.
 */

public class Member_Order_p2_Adapter extends BaseAdapter {

    private LayoutInflater myInflater;
    private Context mContext;
    private Activity mActivity;
    private List<Integer> mItems;

    public Member_Order_p2_Adapter(Activity activity, Context context, List<Integer> ls)
    {
        myInflater = LayoutInflater.from(context);
        mActivity = activity;
        mContext = context;
        mItems = ls;
    }
    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewTag viewTag;
        if(convertView == null) {
            convertView = myInflater.inflate(mContext.getResources().getIdentifier("member_order_p1_listadpater_item", "layout", mContext.getPackageName()), null);

            viewTag = new ViewTag(
                    (ImageView) convertView.findViewById(
                            mContext.getResources().getIdentifier("imageView", "id", mContext.getPackageName()))
            );

            convertView.setTag(viewTag);
        }
        else{
            viewTag = (ViewTag) convertView.getTag();
        }

        viewTag.img.setImageResource(mItems.get(i));
        viewTag.img.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return convertView;
    }

    class ViewTag {
        ImageView img;

        public ViewTag(ImageView img) {
            this.img = img;
        }
    }
}