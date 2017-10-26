package com.jinqihang.traveler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinqihang.traveler.R;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class RoundFlightFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View roundFlightLayout = inflater.inflate(R.layout.single_flight_layout, container, false);
        return roundFlightLayout;
    }
}
