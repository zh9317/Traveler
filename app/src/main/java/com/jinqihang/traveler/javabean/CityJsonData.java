package com.jinqihang.traveler.javabean;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/10/19 0019.
 */

public class CityJsonData extends JSONObject{
    public static void CreateJson(){
        try {
            JSONObject object = new JSONObject();
            JSONArray data = new JSONArray();//实例一个JSON数组

            JSONObject city1 = new JSONObject();//实例一个lan1的JSON对象
            city1.put("ZoneID",1);//对lan1对象添加数据
            city1.put("ZoneType",2);//对lan1对象添加数据
            city1.put("ZoneName","北京");//对lan1对象添加数据
            city1.put("ParentID",3);
            city1.put("PopularLevel",1);

            JSONObject city2 = new JSONObject();//实例一个lan2的JSON对象
            city2.put("ZoneID",2);//对lan1对象添加数据
            city2.put("ZoneType",2);//对lan1对象添加数据
            city2.put("ZoneName","上海");//对lan1对象添加数据
            city2.put("ParentID",3);
            city2.put("PopularLevel",1);

            JSONObject city3 = new JSONObject();//实例一个lan3的JSON对象
            city3.put("ZoneID",3);//对lan1对象添加数据
            city3.put("ZoneType",2);//对lan1对象添加数据
            city3.put("ZoneName","广州");//对lan1对象添加数据
            city3.put("ParentID",3);
            city3.put("PopularLevel",1);

            data.put(0,city1);//将lan1对象添加到JSON数组中去，角标为0
            data.put(1,city2);//将lan2对象添加到JSON数组中去，角标为1
            data.put(2,city3);//将lan3对象添加到JSON数组中去，角标为2

            object.put("data",data);//然后将JSON数组添加到名为object的JSON对象中去
            Log.i("aaa",object.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
