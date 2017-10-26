package com.jinqihang.traveler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinqihang.traveler.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class CityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> cityList;
    public static String cityText;

    private final int HEAD = 0;
    private final int WORD = 1;
    private final int CITY = 2;

    // 声明接口
    private OnCityClickListener onCityClickListener;

    public CityAdapter(Context context, List<String> cityList){
        this.context = context;
        this.cityList = cityList;
    }

    public List<String> getData(){
        return cityList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case HEAD:
                // 列表第一行（热门城市和历史）
                View head = LayoutInflater.from(context).inflate(R.layout.layout_head, parent, false);
                return new HeadViewHolder(head);
            case WORD:
                // 城市首字母
                View word = LayoutInflater.from(context).inflate(R.layout.layout_word, parent, false);
                return new WordViewHolder(word);
            case CITY:
                // 城市名称
                View city = LayoutInflater.from(context).inflate(R.layout.layout_city, parent, false);
                CityViewHolder cityViewHolder = new CityViewHolder(city);
                cityViewHolder.cityText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CityViewHolder holder = new CityViewHolder(v);
                        cityText = (String) holder.cityText.getText();
                        // cityText要传回SingleFlightFragment,这个Fragment在FlightActivity中

                        // 在点击事件里调用接口里的方法
                        if (onCityClickListener != null) {
                            onCityClickListener.onCityClick(cityText);
                        }

//                        if(Activity.class.isInstance(context))
//                        {
//                            // 转化为activity，然后finish就行了
//                            Activity activity = (Activity)context;
//                            Intent intent = new Intent();
//                            intent.putExtra("selected_city",cityText);
//                            activity.finish();
//                        }
                    }
                });
                return new CityViewHolder(city);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int count = 0;
        if(position==count){
            HeadViewHolder headViewHolder = (HeadViewHolder) holder;
        }
        Log.i("CityAdapter",cityList.size()+"");
        for(int i = 0; i < cityList.size(); i++){
            count++;
            if(position==count){
                CityViewHolder cityViewHolder = (CityViewHolder) holder;
                //CityData cityData = cityList.get(i);
                cityViewHolder.cityText.setText(cityList.get(i));
                Log.i("CityAdapter",cityList.get(i));
            }
        }
    }

    @Override
    public int getItemCount() {
        // 城市列表为空时，列表的项目个数为1，即列表头部
        int count = 1;
        if (cityList == null || cityList.size() == 0){
            return count;
        }
        count += cityList.size();
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int count = 0;
        if(position==count) {
            return HEAD;//下标为0的固定显示头部布局。
        }
        for(int i = 0; i < cityList.size(); i++){
            count++;
            if(position==count){
                return CITY;
            }
        }
        return super.getItemViewType(position);
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder{

        View cityView;
        TextView cityText;

        public CityViewHolder(View itemView) {
            super(itemView);
            cityView = itemView;
            cityText = (TextView) itemView.findViewById(R.id.textCity);
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

    // 定义一个接口
    public interface OnCityClickListener {
        void onCityClick(String name);
    }
    // 接口回调函数
    public void setOnCityClickListener(OnCityClickListener listener) {
        this.onCityClickListener = listener;
    }

}
