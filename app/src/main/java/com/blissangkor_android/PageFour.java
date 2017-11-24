package com.blissangkor_android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Gacyou on 2017/11/16.
 */

public class PageFour  extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_four, container, false);

        Spinner spin = (Spinner) view.findViewById(R.id.spinner);
        Spinner spin2 = (Spinner) view.findViewById(R.id.spinner2);
        final String[] list = {"請選擇", "中國", "日本", "美國", "法國"};
        final String[] list2 = {"請選擇", "A區", "B區", "C區", "區區"};
        ArrayAdapter<String> List = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        ArrayAdapter<String> List2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, list2);
        spin.setAdapter(List);
        spin2.setAdapter(List2);

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
