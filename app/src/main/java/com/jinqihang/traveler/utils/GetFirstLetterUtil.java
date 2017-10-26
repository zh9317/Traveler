package com.jinqihang.traveler.utils;

import android.text.TextUtils;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class GetFirstLetterUtil {
    public static String getFirstLetter(String pinyin) {
        if (TextUtils.isEmpty(pinyin)) return null;
        return pinyin.substring(0, 1);
    }
}
