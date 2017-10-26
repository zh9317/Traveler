package com.jinqihang.traveler.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinqihang.traveler.R;
import com.jinqihang.traveler.javabean.CitiesBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17 0017.
 */

public class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CitiesBean.DatasBean> cities;
    public static String cityText;

    private final int HEAD = 0;
    private final int WORD = 1;
    private final int CITY = 2;

    // 声明接口
    private OnCityClickListener onCityClickListener;

    public CitiesAdapter(Context context, List<CitiesBean.DatasBean> cities){
        this.context = context;
        this.cities = cities;
    }

    public List<CitiesBean.DatasBean> getData() {
        return cities;
    }

    @Override
    public int getItemCount() {
        int count = 1;
        // 城市列表为空时，count=1
        if(cities==null || cities.size()==0) return count;
        // 城市列表非空时，count = 1 + 城市列表长度
        count +=cities.size();
        for(CitiesBean.DatasBean datasBean:cities){
            count += datasBean.getAddressList().size();
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int count = 0;
        if(position==count) return HEAD;//下标为0的固定显示头部布局。

        for(int i = 0; i < cities.size(); i++){
            count++;
            if(position==count){
                return WORD;
            }
            List<CitiesBean.DatasBean.AddressListBean> addressList = cities.get(i).getAddressList();
            for(int j =0;j<addressList.size();j++){
                count++;
                if(position==count){
                    return CITY;
                }
            }
        }
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case HEAD:
                View head = LayoutInflater.from(context).inflate(R.layout.layout_head, parent, false);
                return new HeadViewHolder(head);
            case WORD:
                View word = LayoutInflater.from(context).inflate(R.layout.layout_word, parent, false);
                return new WordViewHolder(word);
            case CITY:
                final View city = LayoutInflater.from(context).inflate(R.layout.layout_city, parent, false);
                final CityViewHolder holder = new CityViewHolder(city);
                holder.textCity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CityViewHolder holderTmp = new CityViewHolder(v);
                        Log.i("aaa", (String) holderTmp.textCity.getText());
                        cityText = (String) holderTmp.textCity.getText();
                        // cityText要传回SingleFlightFragment,这个Fragment在FlightActivity中

                        // 在点击事件里调用接口里的方法
                        if (onCityClickListener != null) {
                            onCityClickListener.onCityClick(cityText);
                        }


                        if(Activity.class.isInstance(context))
                        {
                            // 转化为activity，然后finish就行了
                            Activity activity = (Activity)context;
                            Intent intent = new Intent();
                            intent.putExtra("selected_city",cityText);
                            activity.finish();
                        }
                    }
                });
                return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int count = 0;
        if(position==count){
            HeadViewHolder headViewHolder = (HeadViewHolder) holder;
        }
        for(int i = 0; i < cities.size(); i++){
            count++;
            if(position==count){
                WordViewHolder wordViewHolder = (WordViewHolder) holder;
                CitiesBean.DatasBean datasBean = cities.get(i);
                wordViewHolder.textWord.setText(datasBean.getAlifName());
            }
            List<CitiesBean.DatasBean.AddressListBean> addressList = cities.get(i).getAddressList();
            for(int j =0;j<addressList.size();j++){
                count++;
                if(position==count){
                    CityViewHolder cityViewHolder = (CityViewHolder) holder;
                    CitiesBean.DatasBean.AddressListBean addressListBean = addressList.get(j);
                    cityViewHolder.textCity.setText(addressListBean.getName());
                }
            }
        }

    }


    public static class HeadViewHolder extends RecyclerView.ViewHolder {
        public HeadViewHolder(View view) {
            super(view);
        }
    }
    public static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView textWord;
        public WordViewHolder(View view) {
            super(view);
            textWord = (TextView) view.findViewById(R.id.textWord);
        }
    }
    public static class CityViewHolder extends RecyclerView.ViewHolder {

        View cityView;
        TextView textCity;
        public CityViewHolder(View view) {
            super(view);
            cityView = view;
            textCity = (TextView) view.findViewById(R.id.textCity);
        }
    }

    // 定义一个接口
    public interface OnCityClickListener {
        void onCityClick(String name);
    }
    // 接口回调函数
    public void setOnCityClickListener(OnCityClickListener listener) {
        this.onCityClickListener = listener;
    }

}
