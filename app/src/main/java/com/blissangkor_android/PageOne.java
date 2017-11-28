package com.blissangkor_android;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.blissangkor_android.utils.ClickableViewPager;
import com.blissangkor_android.utils.PageOnePagerAdapter;
import com.blissangkor_android.utils.PageOnePagerAdapter2;
import com.blissangkor_android.utils.PageOnePagerAdapter3;

import com.blissangkor_android.utils.PageOnePagerAdapter4;
import com.blissangkor_android.utils.PageOnePagerAdapter5;
import com.blissangkor_android.utils.PageOnePagerAdapter6;
import com.socks.library.KLog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gacyou on 2017/11/15.
 */

public class PageOne  extends android.support.v4.app.Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener{

    public static final int VIEW_PAGER_DELAY = 7000;

    private PageOnePagerAdapter mAdapter;
    private PageOnePagerAdapter2 mAdapter2;
    private PageOnePagerAdapter3 mAdapter3;
    private PageOnePagerAdapter4 mAdapter4;
    private PageOnePagerAdapter5 mAdapter5;
    private PageOnePagerAdapter6 mAdapter6;

    private List<ImageView> mItems;
    private ImageView[] mBottomImages;
    private LinearLayout mBottomLiner;

    private ViewPager mViewPager;
    private ClickableViewPager mViewPager2;
    private ClickableViewPager mViewPager3;
    private ClickableViewPager mViewPager4;
    private ClickableViewPager mViewPager5;
    private ClickableViewPager mViewPager6;

    private SearchView mSearchView;

    private int currentViewPagerItem;

    private boolean isAutoPlay;

    private MyHandler mHandler;
    private Thread mThread;

    private static final int[] pictures = { R.drawable.p2, R.drawable.p2, R.drawable.p1 };
    private static final int[] pictures2 = { R.drawable.p358x338, R.drawable.p358x338, R.drawable.p358x338, R.drawable.p358x338, R.drawable.p358x338, R.drawable.p358x338, R.drawable.p358x338, R.drawable.p358x338 };
    private static final int[] pictures3 = { R.drawable.p955x416, R.drawable.p955x416, R.drawable.p955x416 };
    private static final int[] pictures4 = { R.drawable.p955x416, R.drawable.p955x416, R.drawable.p955x416 };
    private static final int[] pictures5 = { R.drawable.p358x338, R.drawable.p358x338, R.drawable.p358x338 };
    private static final int[] pictures6 = { R.drawable.ad2, R.drawable.ad2, R.drawable.ad2 };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_one, container, false);
        mSearchView = ((SearchView) view.findViewById(R.id.SearchView));
        mSearchView.setIconifiedByDefault(false);


        //不會動的單張廣告圖
        ImageView imageView = ((ImageView)view.findViewById(R.id.imageView));
        imageView.setImageResource(R.drawable.ad);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);


        mHandler = new MyHandler(this);

        //配置轮播图ViewPager

        mViewPager = ((ViewPager) view.findViewById(R.id.live_view_pager));
        mItems = new ArrayList<>();
        mAdapter = new PageOnePagerAdapter(mItems, getContext());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnTouchListener(this);
        mViewPager.addOnPageChangeListener(this);
        isAutoPlay = true;

        //ViewPager2
        mViewPager2 = ((ClickableViewPager) view.findViewById(R.id.live_view_pager2));
        mViewPager2.setOffscreenPageLimit(4);
        mViewPager2.setPageMargin(1);
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i : pictures2){list2.add(i);}
        mAdapter2 = new PageOnePagerAdapter2(list2, getContext());
        mViewPager2.setAdapter(mAdapter2);

        //ViewPager3
        mViewPager3 = ((ClickableViewPager) view.findViewById(R.id.live_view_pager3));
        mViewPager3.setPageMargin(1);
        List<Integer> list3 = new ArrayList<Integer>();
        for(int i : pictures3){list3.add(i);}
        mAdapter3 = new PageOnePagerAdapter3(list3, getContext());
        mViewPager3.setAdapter(mAdapter3);

        //ViewPager4
        mViewPager4 = ((ClickableViewPager) view.findViewById(R.id.live_view_pager4));
        mViewPager4.setPageMargin(10);
        List<Integer> list4 = new ArrayList<Integer>();
        for(int i : pictures4){list4.add(i);}
        mAdapter4 = new PageOnePagerAdapter4(list4, getContext());
        mViewPager4.setAdapter(mAdapter4);

        //ViewPager5
        mViewPager5 = ((ClickableViewPager) view.findViewById(R.id.live_view_pager5));
        mViewPager5.setPageMargin(1);
        List<Integer> list5 = new ArrayList<Integer>();
        for(int i : pictures5){list5.add(i);}
        mAdapter5 = new PageOnePagerAdapter5(list5, getContext());
        mViewPager5.setAdapter(mAdapter5);

        //ViewPager6
        mViewPager6 = ((ClickableViewPager) view.findViewById(R.id.live_view_pager6));
        mViewPager6.setPageMargin(1);
        List<Integer> list6 = new ArrayList<Integer>();
        for(int i : pictures6){list6.add(i);}
        mAdapter6 = new PageOnePagerAdapter6(list6, getContext());
        mViewPager6.setAdapter(mAdapter6);

        //TODO: 添加ImageView
        addImageView();
        mAdapter.notifyDataSetChanged();
        mAdapter2.notifyDataSetChanged();
        mAdapter3.notifyDataSetChanged();
        mAdapter4.notifyDataSetChanged();
        mAdapter5.notifyDataSetChanged();
        mAdapter6.notifyDataSetChanged();

        //设置底部4个小点
        setBottomIndicator(view);

        //mViewPager2 OnClick
        mViewPager2.setOnItemClickListener(new ClickableViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                KLog.d("你現在按的是",position);
            }
        });

        //mViewPager3 OnClick
        mViewPager3.setOnItemClickListener(new ClickableViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                KLog.d("你現在按的是",position);
            }
        });

        //mViewPager4 OnClick
        mViewPager4.setOnItemClickListener(new ClickableViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                KLog.d("你現在按的是",position);
            }
        });

        //mViewPager5 OnClick
        mViewPager5.setOnItemClickListener(new ClickableViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                KLog.d("你現在按的是",position);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void addImageView( ){

        ImageView view0 = new ImageView(getContext());
        view0.setImageResource(R.drawable.p1080x445);
        ImageView view1 = new ImageView(getContext());
        view1.setImageResource(R.drawable.p1080x445);
        ImageView view2 = new ImageView(getContext());
        view2.setImageResource(R.drawable.p1080x445);

        view0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mItems.add(view0);
        mItems.add(view1);
        mItems.add(view2);
    }


    private void setBottomIndicator(View view) {
        //获取指示器(下面三个小点)
        mBottomLiner = ((LinearLayout) view.findViewById(R.id.live_indicator));
        //右下方小圆点
        mBottomImages = new ImageView[mItems.size()];
        for (int i = 0; i < mBottomImages.length; i++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(6, 6);
            params.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(params);
            //如果当前是第一个 设置为选中状态
            if (i == 0) {
                imageView.setImageResource(R.drawable.indicator_select);
            } else {
                imageView.setImageResource(R.drawable.indicator_no_select);
            }
            mBottomImages[i] = imageView;
            //添加到父容器
            mBottomLiner.addView(imageView);
        }

        //让其在最大值的中间开始滑动, 一定要在 mBottomImages初始化之前完成
        int mid = PageOnePagerAdapter.MAX_SCROLL_VALUE / 2;
        mViewPager.setCurrentItem(mid);
        currentViewPagerItem = mid;



            //定时发送消息
            mThread = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        mHandler.sendEmptyMessage(0);
                        try {
                            Thread.sleep(PageOne.VIEW_PAGER_DELAY);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            };
            mThread.start();

    }






    ///////////////////////////////////////////////////////////////////////////
    // ViewPager的监听事件
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        currentViewPagerItem = position;
        if (mItems != null) {
            position %= mBottomImages.length;
            int total = mBottomImages.length;

            for (int i = 0; i < total; i++) {
                if (i == position) {
                    mBottomImages[i].setImageResource(R.drawable.indicator_select);
                } else {
                    mBottomImages[i].setImageResource(R.drawable.indicator_no_select);
                }
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isAutoPlay = false;
                break;
            case MotionEvent.ACTION_UP:
                isAutoPlay = true;
                break;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 为防止内存泄漏, 声明自己的Handler并弱引用Activity
    ///////////////////////////////////////////////////////////////////////////
    private static class MyHandler extends Handler {
        private WeakReference<PageOne> mWeakReference;

        public MyHandler(PageOne activity) {
            mWeakReference = new WeakReference<PageOne>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    PageOne activity = mWeakReference.get();
                    if (activity.isAutoPlay) {

                        activity.mViewPager.setCurrentItem(++activity.currentViewPagerItem);
                    }

                    break;
            }

        }
    }


    @Override
    public void onHiddenChanged(boolean hidd) {
        if (hidd) {
            //隐藏时所作的事情

        } else {
            //显示时所作的事情

        }
    }


}
