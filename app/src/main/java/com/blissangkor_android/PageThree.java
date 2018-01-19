package com.blissangkor_android;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.blissangkor_android.utils.PageThree_ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gacyou on 2017/11/15.
 */

public class PageThree  extends android.support.v4.app.Fragment {

    private ListView list ;
    private TextView tooltext;
    private Button   toolbtn;
    private static final int[] pictures = { R.drawable.p1080x445, R.drawable.p1080x445, R.drawable.p1080x445 };
    private int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_three, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        toolbtn = (Button) view.findViewById(R.id.toolbar_button);
        toolbtn.setVisibility(View.GONE);

        tooltext = (TextView) view.findViewById(R.id.toolbar_text);
        tooltext.setText(R.string.shopping_car);

        list = (ListView) view.findViewById(R.id.textList);

        list.setItemsCanFocus(false);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        List<Integer> carlist = new ArrayList<Integer>();
        for(int i : pictures){carlist.add(i);}
        PageThree_ListAdapter mAdapter = new PageThree_ListAdapter(getContext(), carlist);
        list.setAdapter(mAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                pos = i;
                CheckedTextView chkItem = (CheckedTextView) view.findViewById(R.id.checkedTextView);
                chkItem.setChecked(!chkItem.isChecked());
                Toast.makeText(getActivity(),"點選第 "+(i +1) +" 個 \n內容："+pictures[i], Toast.LENGTH_SHORT).show();

                Button btn = (Button) view.findViewById(R.id.button);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(),"點選第 "+(pos +1) +" 個 \n內容的更改", Toast.LENGTH_SHORT).show();
                    }
                });
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
