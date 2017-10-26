package com.jinqihang.traveler.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jinqihang.traveler.FlightActivity;
import com.jinqihang.traveler.R;
import com.jinqihang.traveler.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10 0010.
 */

public class HomepageFragment extends Fragment implements AdapterView.OnItemClickListener{

    private Context context;
    private View homepageLayout;
    private Banner banner;
    private List<String> imageUrl;
    private List<String> bannerTitle;

    private GridView functionGrid;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter gridAdapter;

    private int[] icon = {
            R.drawable.flight,
            R.drawable.tour_route,
            R.drawable.hotel,
            R.drawable.more};

//    private String[] iconName = {context.getString(R.string.passenger_ticket),
//            context.getString(R.string.travel_route),
//            context.getString(R.string.hotel),
//            context.getString(R.string.more_service)};
//    这样写报错
    private String[] iconName = {"机票","旅游路线","酒店预订","更多服务"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homepageLayout = inflater.inflate(R.layout.homepage_layout, container, false);
        initBannerDate();
        initView();
        functionGrid.setOnItemClickListener(this);
        return homepageLayout;
    }

    private void initBannerDate() {
        //图片地址
        imageUrl = new ArrayList<>();
        imageUrl.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
        imageUrl.add("http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg");
        imageUrl.add("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
        imageUrl.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        imageUrl.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");

        //Title名称
//        bannerTitle = new ArrayList<>();
//        bannerTitle.add("一");
//        bannerTitle.add("二");
//        bannerTitle.add("三");
    }
    private void initView() {
        banner = (Banner) homepageLayout.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imageUrl);
        //banner.setBannerTitles(bannerTitle);
        banner.setDelayTime(3000);
        banner.start();

        functionGrid = (GridView) homepageLayout.findViewById(R.id.function_grid);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from ={"image","text"};
        int[] to = { R.id.grid_image, R.id.grid_text };
        gridAdapter = new SimpleAdapter(getContext(), data_list, R.layout.grid_item, from, to);
        //配置适配器
        functionGrid.setAdapter(gridAdapter);
    }

    public List<Map<String, Object>> getData(){
        for(int i = 0; i < icon.length; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

    // GridView点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent = new Intent(getActivity(), FlightActivity.class);
                startActivity(intent);
                break;
        }
        Toast.makeText(getContext(), iconName[position], Toast.LENGTH_SHORT).show();
    }
}
