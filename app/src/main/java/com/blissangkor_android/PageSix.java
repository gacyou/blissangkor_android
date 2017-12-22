package com.blissangkor_android;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blissangkor_android.utils.FontManager;
import com.blissangkor_android.utils.PageSix_AccountSetting;
import com.blissangkor_android.utils.PageSix_ListAdapter;

import java.util.ArrayList;

import static com.blissangkor_android.utils.Util.getRoundedCornerBitmap;

/**
 * Created by Gacyou on 2017/11/16.
 */


public class PageSix extends android.support.v4.app.Fragment {

    private String[] str;
    private TextView tx6, tx7;
    private Button btn1, btn2, btn3, btn4;
    private PageSix_ListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_six, container, false);

        ArrayList<String> str = new ArrayList<String>() {{
            add((String) getActivity().getResources().getText(R.string.account_setting));
            add((String) getActivity().getResources().getText(R.string.qa));
            add((String) getActivity().getResources().getText(R.string.language));
            add((String) getActivity().getResources().getText(R.string.logout));
        }};


        ImageButton mImg1 = (ImageButton) view.findViewById(R.id.imageButton);
        ListView mlist = (ListView) view.findViewById(R.id.list);

        mImg1.setImageBitmap(getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        getResources(), R.drawable.people),360.0f));
        mImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), Member_information.class);
                startActivity(i);
            }
        });

        mAdapter = new PageSix_ListAdapter(getContext(), str);
        mlist.setAdapter(mAdapter);
        mlist.setOnItemClickListener(onClickListView);

        tx6 = (TextView) view.findViewById(R.id.textView6);
        tx6.setTypeface(FontManager.getTypeface(view.getContext(),FontManager.FONTAWESOME));
        tx6.setText(R.string.fa_bookmark_o);

        tx7 = (TextView) view.findViewById(R.id.textView7);
        tx7.setTypeface(FontManager.getTypeface(view.getContext(),FontManager.FONTAWESOME));
        tx7.setText(R.string.fa_heart_o);

        btn1 = (Button) view.findViewById(R.id.button);
        btn2 = (Button) view.findViewById(R.id.button2);
        btn3 = (Button) view.findViewById(R.id.button3);
        btn4 = (Button) view.findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), Member_Order.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), Member_wishList.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), Member_point.class);
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), Member_Code.class);
                startActivity(i);
            }
        });


        return view;
    }


    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch( position ){
                case 0:

                    Intent i = new Intent(getContext(), PageSix_AccountSetting.class);
                    getContext().startActivity(i);

                    break;
                case 1:

                    Intent i2 = new Intent(getContext(), Customer_Service.class);
                    getContext().startActivity(i2);

                    break;
                case 2:

                    LayoutInflater inflater = getActivity().getLayoutInflater();
                    View v = inflater.inflate(R.layout.language_dailog, null);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle((String) getActivity().getResources().getText(R.string.language))
                            .setView(v)
                            .setPositiveButton((String) getActivity().getResources().getText(R.string.yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                            .setNegativeButton((String) getActivity().getResources().getText(R.string.no), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    Spinner spin = (Spinner) v.findViewById(R.id.spinner);
                    Spinner spin2 = (Spinner) v.findViewById(R.id.spinner2);
                    final String[] list = {"請選擇", "繁中", "簡中", "英文"};
                    final String[] list2 = {"請選擇", "NT", "CNY", "USD"};
                    ArrayAdapter<String> List = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
                    ArrayAdapter<String> List2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list2);
                    spin.setAdapter(List);
                    spin2.setAdapter(List2);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                    break;
                case 3:

                    new AlertDialog.Builder(getActivity())
                            .setTitle((String) getActivity().getResources().getText(R.string.logout))//設定視窗標題
                            .setMessage((String) getActivity().getResources().getText(R.string.isLogout))//設定顯示的文字
                            .setPositiveButton((String) getActivity().getResources().getText(R.string.yes),new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(getContext(), LoginPage.class);
                                    getContext().startActivity(i);
                                    ((Activity)getContext()).overridePendingTransition(R.anim.activity_open,0);
                                    getActivity().finish();
                                }
                            })
                            .setNegativeButton((String) getActivity().getResources().getText(R.string.no), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();//呈現對話視窗

                    break;
            }

        }
    };


}
