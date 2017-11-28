package com.blissangkor_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.blissangkor_android.utils.PageOnePagerAdapter2;
import com.blissangkor_android.utils.PageTwo_p1_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gacyou on 2017/11/23.
 */

public class PageTwo_p1 extends android.support.v4.app.Fragment{

    private ListView list ;
    private static final int[] pictures = { R.drawable.p1080x445, R.drawable.p1080x445, R.drawable.p1080x445 };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagetwo_p1, container, false);

        list = (ListView) view.findViewById(R.id.list);

        List<Integer> p1_list = new ArrayList<Integer>();
        for(int i : pictures){p1_list.add(i);}
        PageTwo_p1_Adapter mAdapter = new PageTwo_p1_Adapter(getActivity() , getContext(), p1_list);
        list.setAdapter(mAdapter);
        list.setOnItemClickListener(new ListItemClickListener());
        return view;
    }

    class ListItemClickListener implements ListView.OnItemClickListener{


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // Toast 快顯功能 第三個參數 Toast.LENGTH_SHORT 2秒  LENGTH_LONG 5秒
            Toast.makeText(getContext(),"點選第 "+(i +1) +" 個 \n內容："+pictures[i], Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
