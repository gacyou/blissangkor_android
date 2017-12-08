package com.blissangkor_android;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gacyou on 2017/11/16.
 */

public class PageFive extends android.support.v4.app.Fragment {

    private TextView tooltext;
    private Button   toolbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagefive, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        toolbtn = (Button) view.findViewById(R.id.toolbar_button);
        toolbtn.setVisibility(View.GONE);


        tooltext = (TextView) view.findViewById(R.id.toolbar_text);
        tooltext.setText("願望清單");

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
