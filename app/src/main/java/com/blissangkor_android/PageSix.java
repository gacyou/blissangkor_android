package com.blissangkor_android;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.blissangkor_android.utils.Util.getRoundedCornerBitmap;

/**
 * Created by Gacyou on 2017/11/16.
 */


public class PageSix extends android.support.v4.app.Fragment {

    public String[] str = {"帳戶設定","諮詢中心","更改語言/貨幣","登出帳號"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_six, container, false);

        ImageView mImg1 = (ImageView) view.findViewById(R.id.image);
        ListView mlist = (ListView) view.findViewById(R.id.list);

        mImg1.setImageBitmap(getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        getResources(), R.drawable.p1),360.0f));

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, str);
        mlist.setAdapter(adapter);
        mlist.setOnItemClickListener(onClickListView);

        return view;
    }


    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toast 快顯功能 第三個參數 Toast.LENGTH_SHORT 2秒  LENGTH_LONG 5秒
            Toast.makeText(getContext(),"點選第 "+(position +1) +" 個 \n內容："+str[position], Toast.LENGTH_SHORT).show();
        }
    };


}
