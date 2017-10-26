package com.jinqihang.traveler;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jinqihang.traveler.fragment.MultiFlightFragment;
import com.jinqihang.traveler.fragment.RoundFlightFragment;
import com.jinqihang.traveler.fragment.SingleFlightFragment;
import com.jinqihang.traveler.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 机票查询页面 模仿MainActivity
 * @author zhanghao
 */
public class FlightActivity extends AppCompatActivity implements View.OnClickListener{

    private SingleFlightFragment singleFlightFragment;
    private RoundFlightFragment roundFlightFragment;
    private MultiFlightFragment multiFlightFragment;

    private View singleFlightLayout;
    private View roundFlightLayout;
    private View multiFlightLayout;

    private TextView singleFlightText;
    private TextView roundFlightText;
    private TextView multiFlightText;

    private FragmentManager fragmentManager;
    private Banner flightBanner;

    private List<String> imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        // 初始化布局元素
        initBannerDate();
        initViews();
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
    }

    private void initBannerDate() {
        //图片地址
        imageUrl = new ArrayList<>();
        imageUrl.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
        imageUrl.add("http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg");
        imageUrl.add("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
        imageUrl.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        imageUrl.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");

    }

    private void initViews(){

        flightBanner = (Banner) findViewById(R.id.flight_banner);
        flightBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        flightBanner.setImageLoader(new GlideImageLoader());
        flightBanner.setImages(imageUrl);
        //banner.setBannerTitles(bannerTitle);
        flightBanner.setDelayTime(3000);
        flightBanner.start();

        singleFlightLayout = findViewById(R.id.single_flight_layout);
        roundFlightLayout = findViewById(R.id.round_flight_layout);
        multiFlightLayout = findViewById(R.id.multi_flight_layout);
        singleFlightText = (TextView) findViewById(R.id.single_flight_text);
        roundFlightText = (TextView) findViewById(R.id.round_flight_text);
        multiFlightText = (TextView) findViewById(R.id.multi_flight_text);

        singleFlightLayout.setOnClickListener(this);
        roundFlightLayout.setOnClickListener(this);
        multiFlightLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.single_flight_layout:
                setTabSelection(0);
                break;
            case R.id.round_flight_layout:
                setTabSelection(1);
                break;
            case R.id.multi_flight_layout:
                setTabSelection(2);
                break;
        }
    }

    private void setTabSelection(int index){
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index){
            case 0:
                // 当点击了消息tab时，改变控件的文字颜色
                singleFlightText.setTextColor(Color.parseColor("#000000"));
                singleFlightLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                if (singleFlightFragment == null) {
                    // 如果SingleFlightFragment为空，则创建一个并添加到界面上
                    singleFlightFragment = new SingleFlightFragment();
                    transaction.add(R.id.flight_content, singleFlightFragment);
                } else {
                    // 如果SingleFlightFragment不为空，则直接将它显示出来
                    transaction.show(singleFlightFragment);
                }
                break;
            case 1:
                roundFlightText.setTextColor(Color.parseColor("#000000"));
                roundFlightLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                if (roundFlightFragment == null) {
                    roundFlightFragment = new RoundFlightFragment();
                    transaction.add(R.id.flight_content, roundFlightFragment);
                } else {
                    transaction.show(roundFlightFragment);
                }
                break;
            case 2:
                multiFlightText.setTextColor(Color.parseColor("#000000"));
                multiFlightLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                if (multiFlightFragment == null) {
                    multiFlightFragment = new MultiFlightFragment();
                    transaction.add(R.id.flight_content, multiFlightFragment);
                } else {
                    transaction.show(multiFlightFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        singleFlightText.setTextColor(Color.parseColor("#ffffff"));
        roundFlightText.setTextColor(Color.parseColor("#ffffff"));
        multiFlightText.setTextColor(Color.parseColor("#ffffff"));
        singleFlightLayout.setBackgroundColor(Color.parseColor("#88000000"));
        roundFlightLayout.setBackgroundColor(Color.parseColor("#88000000"));
        multiFlightLayout.setBackgroundColor(Color.parseColor("#88000000"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (singleFlightFragment != null) {
            transaction.hide(singleFlightFragment);
        }
        if (roundFlightFragment != null) {
            transaction.hide(roundFlightFragment);
        }
        if (multiFlightFragment != null) {
            transaction.hide(multiFlightFragment);
        }
    }
}
