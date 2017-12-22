package com.blissangkor_android.utils;

/**
 * Created by Gacyou on 2017/11/16.
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.blissangkor_android.R;
import com.socks.library.KLog;

import java.util.List;

public class PageOnePagerAdapter extends PagerAdapter {

    public static final int MAX_SCROLL_VALUE = 10000;

    private List<Integer> mItems;
    private Context mContext;
    private LayoutInflater mInflater;
    private int x;

    public PageOnePagerAdapter(List<Integer> items, Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
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
        //View ret = null;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 佈局
        View itemView = mInflater.inflate(R.layout.pageone_pageradapter, container, false);

        //对ViewPager页号求摸取出View列表中要显示的项
        position %= mItems.size();
        //x = position;
        //Log.d("Adapter", "instantiateItem: position: " + position);
       // ret = mItems.get(position);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(mItems.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent viewParent = itemView.getParent();
        if (viewParent != null) {
            ViewGroup parent = (ViewGroup) viewParent;
            parent.removeView(itemView);
        }

        container.addView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KLog.d("你現在按的是",x);
            }
        });

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
        //警告:不要在这里调用removeView, 已经在instantiateItem中处理了
    }


    @Override
    public int getCount() {
        int ret = 0;
        if (mItems.size() > 0) {
            ret = MAX_SCROLL_VALUE;
        }
        return ret;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }
}