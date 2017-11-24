package com.blissangkor_android.utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.blissangkor_android.R;

import java.util.List;

/**
 * Created by Gacyou on 2017/11/20.
 */

public class PageOnePagerAdapter4 extends PagerAdapter {

    public static final int MAX_SCROLL_VALUE = 10000;
    private List<Integer> mItems;
    private Context mContext;
    private LayoutInflater mInflater;


    public PageOnePagerAdapter4(List<Integer> items, Context context) {
        mContext = context;
        mItems = items;
    }

    /**
     * @param container
     * @param position
     * @return 对position进行求模操作
     * 因为当用户向左滑时position可能出现负值，所以必须进行处理
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 佈局
        View itemView = mInflater.inflate(R.layout.pageone_pageradapter4_item, container, false);

        // 佈局元件內容
        ImageView imageView = (ImageView)itemView.findViewById(R.id.listImage);
        imageView.setImageResource(mItems.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ViewParent viewParent = itemView.getParent();
        if (viewParent != null) {
            ViewGroup parent = (ViewGroup) viewParent;
            parent.removeView(itemView);
        }
        container.addView(itemView);
        return itemView;
    }


    /**
     * 由于我们在instantiateItem()方法中已经处理了remove的逻辑，
     * 因此这里并不需要处理。实际上，实验表明这里如果加上了remove的调用，
     * 则会出现ViewPager的内容为空的情况。
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }

    @Override
    public float getPageWidth(int position) {
        return (float) 0.8;
    }

}