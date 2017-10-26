package com.jinqihang.traveler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinqihang.traveler.R;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class CustomServiceFragment extends Fragment {

    private View customServiceLayout;
    private String[] data = {};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customServiceLayout = inflater.inflate(R.layout.custom_service_layout, container, false);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data);
//        ListView listView = (ListView) customServiceLayout.findViewById(R.id.listview);
//        ImageView pullList = (ImageView) customServiceLayout.findViewById(R.id.pull_image);
//        pullList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "pull", Toast.LENGTH_SHORT).show();
//            }
//        });
//        listView.setAdapter(adapter);
//        listView.addHeaderView(new InputLayout(getContext()));

        return customServiceLayout;
    }
}
