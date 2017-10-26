package com.jinqihang.traveler.http;

import android.util.Log;

import com.jinqihang.traveler.fragment.SingleFlightFragment;
import com.jinqihang.traveler.javabean.FlightModel;
import com.jinqihang.traveler.javabean.UrlHeader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * 用于请求航班接口
 * Created by Administrator on 2017/10/20 0020.
 */

public class FlightApi extends HttpUtil {
    /**
     * 航班接口地址
     * @return
     */
    @Override
    public String getUrl() {
        return UrlHeader.FLIGHT_URL;
    }

    @Override
    public RequestBody parameter() {
        RequestBody requestBody = new FormBody.Builder()
                .add("departcity", SingleFlightFragment.startCityName)
                .add("arrivecity", SingleFlightFragment.arriveCityName)
                .build();
        return requestBody;
    }

    /**
     * 处理接受到的数据
     * @param obj
     * @return
     */
    @Override
    public HttpUtil handleData(String obj) {
        HttpUtil response = new HttpUtil();
        JSONArray flightArr = null;// "data"中的数据：航班json数组
        try {
            flightArr = new JSONArray(obj);
            Log.i("FlightApi", flightArr.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<FlightModel> dataList = new ArrayList<>();
        for (int i = 0; i < flightArr.length(); i++) {
            try {
                JSONObject jsonObj = (JSONObject) flightArr.get(i);
                FlightModel model = new FlightModel(jsonObj);
                dataList.add(model);
                Log.i("FlightApi", dataList.get(i).getArriveTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        response.responseObject = dataList;
        return response;
    }
}
