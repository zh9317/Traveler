package com.jinqihang.traveler.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jinqihang.traveler.R;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class FlightTitleLayout extends LinearLayout {
    public FlightTitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.flight_title, this);
        final ImageView flightTitleBack = (ImageView) findViewById(R.id.flight_title_back);
        flightTitleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
}
