package com.blissangkor_android.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blissangkor_android.R;

import java.util.ArrayList;

import static com.blissangkor_android.utils.Util.getRoundedCornerBitmap;

/**
 * Created by Gacyou on 2018/1/31.
 */

public class PageSix_info_ListAdapter extends BaseAdapter {

    private LayoutInflater mLayInf;
    private ArrayList<String> mItemList;

    public PageSix_info_ListAdapter(Context context, ArrayList<String> itemList)
    {
        mLayInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItemList = itemList;
    }

    @Override
    public int getCount() {
        return mItemList.size();
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

        View v = mLayInf.inflate(R.layout.page_six_info_list_adpater, viewGroup, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        TextView textView = (TextView) v.findViewById(R.id.textView);

        switch (i)
        {
            case 0:
                imageView.setImageBitmap(getRoundedCornerBitmap(
                        BitmapFactory.decodeResource(
                                v.getResources(), R.drawable.people), 0f));

                break;
        }

        textView.setText(mItemList.get(i));

        return v;
    }
}