package com.jinqihang.traveler.http;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/18 0018.
 */

public class HttpUtil {

    public  Object responseObject;

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public void postOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = this.parameter();

        Request request;
        if ( requestBody == null) {
            request = new Request.Builder()
                    .url(address)
                    .build();
        }else {
            request = new Request.Builder()
                    .url(address)
                    .post(requestBody)
                    .build();
        }
        client.newCall(request).enqueue(callback);
    }

    /**
     * 请求数据块
     * @param block 接口类型参数
     */
    public void requestHttpWithBlock(final ResponseBlock block) {

        this.postOkHttpRequest(this.getUrl(), new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("HttpUtil","无法访问");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Json字符串
                String responseString = response.body().string();
                //
                HttpUtil responseData = new HttpUtil();

                // 将Json字符串转为JSONObject对象
                JSONObject jsonobj = null;
                try {
                    jsonobj = new JSONObject(responseString);
                    if (jsonobj.getString("code").equals("10001")) {
                        // handleData()返回HttpUtil类的对象responseData
                        responseData = handleData(jsonobj.getString("data"));
                        Log.i("HttpUtil", responseString);
                        Log.i("HttpUtil", jsonobj.getString("data"));
                        // responseData调成员变量responseObject
                        block.onResponseBlock(true,responseData.responseObject,jsonobj.getString("msg"));
                    }else {
                        block.onResponseBlock(false,responseData.responseObject,jsonobj.getString("msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public String getUrl() {
        return "";
    }

    public RequestBody parameter() {
        return null;
    }

    public HttpUtil handleData(String obj) {
        return new HttpUtil();
    }

}
