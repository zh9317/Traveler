package com.jinqihang.traveler;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinqihang.traveler.fragment.CustomServiceFragment;
import com.jinqihang.traveler.fragment.HomepageFragment;
import com.jinqihang.traveler.fragment.MineFragment;
import com.jinqihang.traveler.fragment.TravelRouteFragment;

/**
 * 项目的主Activity，嵌入四个Fragment
 * @author zhanghao
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // 用于展示“主页”的Fragment
    private HomepageFragment homepageFragment;
    // 用于展示“行程”的Fragment
    private TravelRouteFragment travelRouteFragment;
    // 用于展示“客服”的Fragment
    private CustomServiceFragment customServiceFragment;
    // 用于展示“我的”的Fragment
    private MineFragment mineFragment;

    // “主页”界面布局
    private View homepageLayout;
    // “行程”界面布局
    private View travelRouteLayout;
    // “客服”界面布局
    private View customServiceLayout;
    // “我的”界面布局
    private View mineLayout;

    // 在Tab布局上显示“主页”图标的控件
    private ImageView homepageImage;
    // 在Tab布局上显示“行程”图标的控件
    private ImageView travelRouteImage;
    // 在Tab布局上显示“客服”图标的控件
    private ImageView customServiceImage;
    // 在Tab布局上显示“我的”图标的控件
    private ImageView mineImage;

    // 在Tab布局上显示“主页”标题的控件
    private TextView homepageText;
    // 在Tab布局上显示“行程”标题的控件
    private TextView travelRouteText;
    // 在Tab布局上显示“客服”标题的控件
    private TextView customServiceText;
    // 在Tab布局上显示“我的”标题的控件
    private TextView mineText;

    // 用于对Fragment进行管理
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化布局元素
        // CityJsonData.CreateJson();// 模拟数据
        initViews();
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
    }

    private void initViews(){
        homepageLayout = findViewById(R.id.homepage_layout);
        travelRouteLayout = findViewById(R.id.travel_route_layout);
        customServiceLayout = findViewById(R.id.custom_service_layout);
        mineLayout = findViewById(R.id.mine_layout);
        homepageImage = (ImageView) findViewById(R.id.homepage_image);
        travelRouteImage = (ImageView) findViewById(R.id.travel_route_image);
        customServiceImage = (ImageView) findViewById(R.id.custom_service_image);
        mineImage = (ImageView) findViewById(R.id.mine_image);
        homepageText = (TextView) findViewById(R.id.homepage_text);
        travelRouteText = (TextView) findViewById(R.id.travel_route_text);
        customServiceText = (TextView) findViewById(R.id.custom_service_text);
        mineText = (TextView) findViewById(R.id.mine_text);
        homepageLayout.setOnClickListener(this);
        travelRouteLayout.setOnClickListener(this);
        customServiceLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homepage_layout:
                setTabSelection(0);
                break;
            case R.id.travel_route_layout:
                setTabSelection(1);
                break;
            case R.id.custom_service_layout:
                setTabSelection(2);
                break;
            case R.id.mine_layout:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页
     * @param index 每个tab页对应的下标
     */
    private void setTabSelection(int index){
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index){
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                homepageImage.setImageResource(R.drawable.homepage_selected);
                homepageText.setTextColor(Color.parseColor("#000055"));
                if (homepageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    homepageFragment = new HomepageFragment();
                    transaction.add(R.id.content, homepageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(homepageFragment);
                }
                break;
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                travelRouteImage.setImageResource(R.drawable.travel_route_selected);
                travelRouteText.setTextColor(Color.parseColor("#000055"));
                if (travelRouteFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    travelRouteFragment = new TravelRouteFragment();
                    transaction.add(R.id.content, travelRouteFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(travelRouteFragment);
                }
                break;
            case 2:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                customServiceImage.setImageResource(R.drawable.custom_service_selected);
                customServiceText.setTextColor(Color.parseColor("#000055"));
                if (customServiceFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    customServiceFragment = new CustomServiceFragment();
                    transaction.add(R.id.content, customServiceFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(customServiceFragment);
                }
                break;
            case 3:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                mineImage.setImageResource(R.drawable.mine_selected);
                mineText.setTextColor(Color.parseColor("#000055"));
                if (mineFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mineFragment = new MineFragment();
                    transaction.add(R.id.content, mineFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mineFragment);
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
        homepageImage.setImageResource(R.drawable.homepage_unselected);
        homepageText.setTextColor(Color.parseColor("#000000"));
        travelRouteImage.setImageResource(R.drawable.travel_route_unselected);
        travelRouteText.setTextColor(Color.parseColor("#000000"));
        customServiceImage.setImageResource(R.drawable.custom_service_unselected);
        customServiceText.setTextColor(Color.parseColor("#000000"));
        mineImage.setImageResource(R.drawable.mine_unselected);
        mineText.setTextColor(Color.parseColor("#000000"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homepageFragment != null) {
            transaction.hide(homepageFragment);
        }
        if (travelRouteFragment != null) {
            transaction.hide(travelRouteFragment);
        }
        if (customServiceFragment != null) {
            transaction.hide(customServiceFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }
}
