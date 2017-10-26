package com.jinqihang.traveler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jinqihang.traveler.R;
import com.jinqihang.traveler.javabean.FlightBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class FlightListAdapter extends BaseAdapter {

    // 航班信息列表集合
    private List<FlightBean> flightListItems;
    private LayoutInflater inflater;

    public FlightListAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    /**
     * 获取航班列表
     * @return
     */
    public List<FlightBean> getListItems(){
        return flightListItems;
    }

    /**
     *
     * @param flightListItems
     */
    public void setListItems(List<FlightBean> flightListItems){
        this.flightListItems = flightListItems;
    }

    @Override
    public int getCount() {
        return flightListItems.size();
    }

    @Override
    public Object getItem(int position) {
        // 获取某一位置数据
        return flightListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        // 获取数据位置
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.flight_list_item, null);
            viewHolder.setStartTimeText((TextView) convertView.findViewById(R.id.start_time));
            viewHolder.setEndTimeText((TextView) convertView.findViewById(R.id.end_time));
            viewHolder.setStartAirportText((TextView) convertView.findViewById(R.id.start_airport));
            viewHolder.setEndAirportText((TextView) convertView.findViewById(R.id.end_airport));
            viewHolder.setAirlineCompanyText((TextView) convertView.findViewById(R.id.start_plane));
            viewHolder.setPlaneText((TextView) convertView.findViewById(R.id.end_plane));
            viewHolder.setPriceText((TextView) convertView.findViewById(R.id.flight_price));
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.getStartTimeText().setText(flightListItems.get(position).getStartTime());
//        viewHolder.getEndTimeText().setText(flightListItems.get(position).getEndTime());
//        viewHolder.getStartAirportText().setText(flightListItems.get(position).getStartAirport());
//        viewHolder.getEndAirportText().setText(flightListItems.get(position).getEndAirport());
//        viewHolder.getAirlineCompanyText().setText(flightListItems.get(position).getAirlineCompany());
//        viewHolder.getPlaneText().setText(flightListItems.get(position).getPlane());
//        viewHolder.getPriceText().setText(flightListItems.get(position).getPrice());

        viewHolder.getStartTimeText().setText(flightListItems.get(position).getStartTime());
        viewHolder.getEndTimeText().setText(flightListItems.get(position).getEndTime());
        viewHolder.getStartAirportText().setText(flightListItems.get(position).getStartAirport());
        viewHolder.getEndAirportText().setText(flightListItems.get(position).getEndAirport());
        viewHolder.getAirlineCompanyText().setText(flightListItems.get(position).getAirlineCompany());
        viewHolder.getPlaneText().setText(flightListItems.get(position).getPlane());
        viewHolder.getPriceText().setText(flightListItems.get(position).getPrice());

        return convertView;
    }

    class ViewHolder{
        private TextView startTimeText;
        private TextView endTimeText;
        private TextView startAirportText;
        private TextView endAirportText;
        private TextView airlineCompanyText;
        private TextView planeText;
        private TextView priceText;

        public TextView getStartTimeText() {
            return startTimeText;
        }

        public void setStartTimeText(TextView startTimeText) {
            this.startTimeText = startTimeText;
        }

        public TextView getEndTimeText() {
            return endTimeText;
        }

        public void setEndTimeText(TextView endTimeText) {
            this.endTimeText = endTimeText;
        }

        public TextView getStartAirportText() {
            return startAirportText;
        }

        public void setStartAirportText(TextView startAirportText) {
            this.startAirportText = startAirportText;
        }

        public TextView getEndAirportText() {
            return endAirportText;
        }

        public void setEndAirportText(TextView endAirportText) {
            this.endAirportText = endAirportText;
        }

        public TextView getAirlineCompanyText() {
            return airlineCompanyText;
        }

        public void setAirlineCompanyText(TextView airlineCompanyText) {
            this.airlineCompanyText = airlineCompanyText;
        }

        public TextView getPlaneText() {
            return planeText;
        }

        public void setPlaneText(TextView PlaneText) {
            this.planeText = PlaneText;
        }

        public TextView getPriceText() {
            return priceText;
        }

        public void setPriceText(TextView priceText) {
            this.priceText = priceText;
        }
    }

}
