package com.jinqihang.traveler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jinqihang.traveler.javabean.RecycleViewItemData;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class FlightDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_CONTENT = 0;
    private ArrayList<RecycleViewItemData> dataList;//数据集合

    public FlightDetailAdapter (ArrayList<RecycleViewItemData> dataList){
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder{

        public HeadViewHolder(View itemView) {
            super(itemView);

        }
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder{

        public ContentViewHolder(View itemView) {
            super(itemView);
        }
    }
}
