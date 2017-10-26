package com.jinqihang.traveler.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jinqihang.traveler.R;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class InputLayout extends RelativeLayout {
    public InputLayout(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.account_list, this);
//        ImageView pullList = (ImageView) findViewById(R.id.pull_image);
//        pullList.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "pull", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
