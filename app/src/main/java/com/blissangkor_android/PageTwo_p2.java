package com.blissangkor_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.blissangkor_android.utils.ExListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gacyou on 2017/11/23.
 */

public class PageTwo_p2 extends android.support.v4.app.Fragment {

    ExpandableListView exlist;
    ArrayList<String> listHeader ;
    HashMap<String, List<String>> listDataChild;
    ExListAdapter ExlistAdapter;
    SearchView Sv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagetwo_p2_item, container, false);

        Sv = (SearchView) view.findViewById(R.id.SearchView);
        Sv.setIconifiedByDefault(false);

        exlist = (ExpandableListView) view.findViewById(R.id.ExList);
        listDataChild = new HashMap<String, List<String>>();

        listHeader = new ArrayList<String>();
        listHeader.add("國家一");
        listHeader.add("國家二");
        listHeader.add("國家三");

        List<String> one = new ArrayList<String>();
        one.add("地區一");
        one.add("地區二");
        one.add("地區三");
        List<String> two = new ArrayList<String>();
        two.add("地區一");
        two.add("地區二");
        two.add("地區三");
        List<String> three = new ArrayList<String>();
        three.add("地區一");
        three.add("地區二");
        three.add("地區三");

        listDataChild.put(listHeader.get(0),one);
        listDataChild.put(listHeader.get(1),two);
        listDataChild.put(listHeader.get(2),three);

        ExlistAdapter = new ExListAdapter(getContext(), listHeader, listDataChild);
        exlist.setAdapter(ExlistAdapter);

        // 點選標題 展開 監聽事件
        exlist.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext().getApplicationContext(), "您點選:" + listHeader.get(groupPosition), Toast.LENGTH_SHORT).show();
            }
        });

        // 點選標題監聽事件
        exlist.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getContext().getApplicationContext(), "這是:" + listHeader.get(groupPosition) + " : " + listDataChild.get(listHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
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
