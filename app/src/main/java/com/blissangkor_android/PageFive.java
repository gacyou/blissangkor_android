package com.blissangkor_android;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.blissangkor_android.utils.PageFive_ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gacyou on 2017/11/16.
 */

public class PageFive extends android.support.v4.app.Fragment {

    private TextView tooltext;
    private Button   toolbtn;

    private ListView list ;
    private static final int[] pictures = { R.drawable.p1080x445, R.drawable.p1080x445, R.drawable.p1080x445 };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_five, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        toolbtn = (Button) view.findViewById(R.id.toolbar_button);
        toolbtn.setVisibility(View.GONE);


        tooltext = (TextView) view.findViewById(R.id.toolbar_text);
        tooltext.setText("願望清單");

        list = (ListView) view.findViewById(R.id.wishlist);

        List<Integer> wish_list = new ArrayList<Integer>();
        for(int i : pictures){wish_list.add(i);}
        PageFive_ListAdapter mAdapter = new PageFive_ListAdapter(getContext(), wish_list);
        list.setAdapter(mAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),"你按的是第" + (i+1) + "個",Toast.LENGTH_SHORT).show();
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
}
