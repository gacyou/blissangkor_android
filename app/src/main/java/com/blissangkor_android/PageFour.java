package com.blissangkor_android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.socks.library.KLog;

import static android.widget.Toast.LENGTH_SHORT;
import static com.blissangkor_android.R.attr.toolbarId;

/**
 * Created by Gacyou on 2017/11/16.
 */

public class PageFour  extends android.support.v4.app.Fragment {

    Activity mActivity;
    Context mContext;

    private TextView tooltext;
    private Button   toolbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_four, container, false);

        mActivity = getActivity();
        mContext = view.getContext();

        Spinner spin = (Spinner) view.findViewById(R.id.spinner);
        Spinner spin2 = (Spinner) view.findViewById(R.id.spinner2);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.pagefour_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.search:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.myInfo:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.messenger:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.myPhoto:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.myCollection:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.memberSearch:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.setting:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.Disclaimer:
                        // Do onlick on menu action here
                        Toast.makeText(mContext,"你按的是" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

        toolbtn = (Button) view.findViewById(R.id.toolbar_button);
        toolbtn.setVisibility(View.GONE);
        tooltext = (TextView) view.findViewById(R.id.toolbar_text);
        tooltext.setText(R.string.Companion);

        final String[] list = {"請選擇", "中國", "日本", "美國", "法國"};
        final String[] list2 = {"請選擇", "A區", "B區", "C區", "區區"};
        ArrayAdapter<String> List = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        ArrayAdapter<String> List2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, list2);
        spin.setAdapter(List);
        spin2.setAdapter(List2);

        /*
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
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
