package com.jinqihang.traveler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.jinqihang.traveler.adapter.CitiesAdapter;
import com.jinqihang.traveler.adapter.CityAdapter;
import com.jinqihang.traveler.javabean.CitiesBean;
import com.jinqihang.traveler.javabean.CityData;
import com.jinqihang.traveler.javabean.Data;
import com.jinqihang.traveler.utils.ChineseToPinyin;
import com.jinqihang.traveler.view.QuickIndexView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCityActivity extends AppCompatActivity {

    private QuickIndexView quickIndexView;
    private RecyclerView recyclerView;
    private CitiesAdapter adapter;
    private CityAdapter cityAdapter;
    private String cityText;

    private String[] letterArr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private List<String> letterList;
    public static String[] firstLetterArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        letterList = new ArrayList<>(Arrays.asList(letterArr));
        initView();
//        initEvent();
    }

    private void initView() {
        quickIndexView = (QuickIndexView) findViewById(R.id.quickIndexView);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Gson gson = new Gson();
        // 解析模拟的Json数据
        CitiesBean citiesBean = gson.fromJson(Data.citiesJson, CitiesBean.class);
        // 放置城市信息的list
        List<CityData> cityList = (List<CityData>) getIntent().getSerializableExtra("list");
        List<String> cityNameList = new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++){
            cityNameList.add(cityList.get(i).getZoneName());
            Log.i("list",cityList.get(i).getZoneName());
        }
        Log.i("list",cityList.get(0).getZoneName());
        // 放置首字母的List
        List<String> firstLetterList = new ArrayList<String>();
        for (CityData cityData : cityList){
            firstLetterList.add(ChineseToPinyin.getPinYinFirstLetter(cityData.getZoneName()).toUpperCase());
            Log.i("SingleFlightFragment",ChineseToPinyin.getPinYinFirstLetter(cityData.getZoneName()).toUpperCase());
        }
        // “首字母”：“城市”键值对
        Map<String, String> cityMap = new HashMap<>();
        for (int i = 0; i < cityNameList.size(); i++){
            cityMap.put(firstLetterList.get(i), cityNameList.get(i));
        }
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < letterList.size(); i++){
            // i: 1-26个字母
            for (int j = 0; j < firstLetterList.size(); j++){
                // j: 首字母
                if (letterList.get(i).equals(firstLetterList.get(j))){
                    // 如果26个字母列表中的某一个与第一个首字母一样，就将26个字母列表中的这个字母添加进来，并添加首字母是这个字母的城市名
                    // 这样造成了重复
                    newList.add(letterList.get(i));
                    newList.add(cityMap.get(letterList.get(i)));
                }
            }
        }
//        for (int i = 0; i < cityMap.size(); i++){
//            newList.add(firstLetterList.get(i));
//            newList.add(cityMap.get(firstLetterList.get(i)));
//        }
        for (int i = 0; i < newList.size(); i++){
            Log.i("SelectCityActivity", newList.get(i));
        }
        adapter = new CitiesAdapter(this,citiesBean.getDatas());
        cityAdapter = new CityAdapter(this, newList);

//        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(cityAdapter);
        cityAdapter.setOnCityClickListener(new CityAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(String name) {
                cityText = name;
                Intent intent = new Intent();
                intent.putExtra("cityName",cityText);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
//        adapter.setOnCityClickListener(new CitiesAdapter.OnCityClickListener() {
//            @Override
//            public void onCityClick(String name) {
//                cityText = name;
//                Log.i("Select",name);
//                Intent intent = new Intent();
//                intent.putExtra("cityName",cityText);
//                setResult(RESULT_OK, intent);
//                finish();
//            }
//        });
    }

    private void initEvent() {
        quickIndexView.setOnIndexChangeListener(new QuickIndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String words) {
                if(words.equals("当") || words.equals("热")){
                    LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                            .getLayoutManager();
                    llm.scrollToPositionWithOffset(0, 0);
                    return;
                }
                List<CitiesBean.DatasBean> dataList = adapter.getData();
                if(dataList!=null && dataList.size()>0) {
                    int count = 0;
                    for (int i = 0; i < dataList.size(); i++) {
                        CitiesBean.DatasBean datasBean = dataList.get(i);
                        if(datasBean.getAlifName().equals(words)){
                            LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                                    .getLayoutManager();
                            llm.scrollToPositionWithOffset(count+1, 0);
                            return;
                        }
                        count+=datasBean.getAddressList().size()+1;
                    }
                }
            }
        });
    }
    private void initCityEvent(){
        quickIndexView.setOnIndexChangeListener(new QuickIndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String words) {
                if(words.equals("当") || words.equals("热")){
                    LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                            .getLayoutManager();
                    llm.scrollToPositionWithOffset(0, 0);
                    return;
                }
                List<String> cityList = cityAdapter.getData();
                if (cityList != null && cityList.size() > 0){
                    int count = 0;
                    for (int i = 0; i < cityList.size(); i++){

                    }
                }
            }
        });
    }

}
