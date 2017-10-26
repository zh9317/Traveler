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

public class TravelRouteFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View travelRouteLayout = inflater.inflate(R.layout.travel_route_layout, container, false);
        return travelRouteLayout;
    }
}
