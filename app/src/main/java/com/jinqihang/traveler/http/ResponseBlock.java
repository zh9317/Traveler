package com.jinqihang.traveler.http;

import java.io.IOException;



/**
 *
 * Created by Administrator on 2017/10/19 0019.
 */

public interface ResponseBlock {

    void onResponseBlock(boolean isSuccess,Object responseObject,String msg) throws IOException;

}
