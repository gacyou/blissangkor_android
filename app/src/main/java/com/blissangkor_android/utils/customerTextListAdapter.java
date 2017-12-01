package com.blissangkor_android.utils;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blissangkor_android.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

/**
 * Created by Gacyou on 2017/12/1.
 */

public class customerTextListAdapter extends BaseAdapter {

    private final Context mContext;
    private final SparseBooleanArray mCollapsedStatus;
    private final String[] sampleStrings;
    private  String[] sampleStrings2;

    public customerTextListAdapter(Context context,String[] strings ) {
        mContext  = context;
        mCollapsedStatus = new SparseBooleanArray();
        sampleStrings = strings;
    }

    @Override
    public int getCount() {
        return sampleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.customer_list_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.expandableTextView = (ExpandableTextView) view.findViewById(R.id.expand_text_view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.expandableTextView.setText(sampleStrings[position], mCollapsedStatus, position);

        TextView title = (TextView) view.findViewById(R.id.title);
        sampleStrings2 = new String[]{"要怎麼出國", "要怎麼去機場", "要怎麼辦護照", "要怎麼免費搭機", "要怎麼搭訕空姐", "要怎麼搭訕導遊", "要怎麼免費購物", "要怎麼當奧客", "要怎麼付錢", "要怎麼回家"};
        title.setText(sampleStrings2[position]);

        return view;
    }

    private static class ViewHolder{
        ExpandableTextView expandableTextView;
    }
}
