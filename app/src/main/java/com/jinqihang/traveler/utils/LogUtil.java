package com.jinqihang.traveler.utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/10/19 0019.
 */

public class LogUtil {
    public static void i(String tag, String message){
        if (message != null){
            Log.i(tag, message);
        }else {
            Log.i(tag, "该字符串为空");
        }
    }
}
