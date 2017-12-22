package com.blissangkor_android.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blissangkor_android.R;

import java.util.ArrayList;

/**
 * Created by Gacyou on 2017/12/22.
 */

public class PageSix_ListAdapter extends BaseAdapter {

    private LayoutInflater mLayInf;
    private ArrayList<String>mItemList;

    public PageSix_ListAdapter(Context context, ArrayList<String> itemList)
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

        View v = mLayInf.inflate(R.layout.page_six_list_adpater, viewGroup, false);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        TextView textView2 = (TextView) v.findViewById(R.id.textView2);

        switch (i)
        {
            case 0:
                textView.setTypeface(FontManager.getTypeface(v.getContext(),FontManager.FONTAWESOME));
                textView.setText(R.string.fa_cog);
                break;
            case 1:
                textView.setTypeface(FontManager.getTypeface(v.getContext(),FontManager.FONTAWESOME));
                textView.setText(R.string.fa_volume_control_phone);
                break;
            case 2:
                textView.setTypeface(FontManager.getTypeface(v.getContext(),FontManager.FONTAWESOME));
                textView.setText(R.string.fa_refresh);
                break;
            case 3:
                textView.setTypeface(FontManager.getTypeface(v.getContext(),FontManager.FONTAWESOME));
                textView.setText(R.string.fa_sign_out);
                break;
        }

        textView2.setText(mItemList.get(i));

        return v;
    }
}
