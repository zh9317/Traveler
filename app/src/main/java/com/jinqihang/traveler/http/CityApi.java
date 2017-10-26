package com.jinqihang.traveler.http;


import com.google.gson.Gson;
import com.jinqihang.traveler.javabean.CityData;
import com.jinqihang.traveler.javabean.UrlHeader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于请求城市接口
 * Created by Administrator on 2017/10/19 0019.
 */

public class CityApi extends HttpUtil {

    @Override
    /**
     * 城市接口地址
     */
    public String getUrl() {
        return UrlHeader.CITY_URL;
    }

//    @Override
//    public RequestBody parameter() {
//        RequestBody requestBody = new FormBody.Builder()
//                .add("departcity", "北京")
//                .add("arrivecity", "上海")
//                .build();
//        return requestBody;
//    }

    /**
     * 处理接收到的数据
     * @param obj
     * @return
     */
    @Override
    public HttpUtil handleData(String obj) {
        HttpUtil response = new HttpUtil();
        Gson gson = new Gson();
        JSONArray hotArr = null;
        JSONArray cityesArr = null;
        try {
            JSONObject jsonObject = new JSONObject(obj);
            hotArr = new JSONArray(jsonObject.getString("city"));
            JSONArray tmpArr = new JSONArray(jsonObject.getString("nhotcity"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        try {
//            jsonobj.put("datas",obj);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


//        CityData model = gson.fromJson(jsonobj.toString(), CityData.class);
        List<CityData> dataList = new ArrayList<>();
        for (int i = 0; i < hotArr.length(); i++) {
            try {
                JSONObject jsonObj = (JSONObject) hotArr.get(i);
                CityData model = new CityData(jsonObj);
                dataList.add(model);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        response.responseObject = dataList;
        return response;
    }
}
