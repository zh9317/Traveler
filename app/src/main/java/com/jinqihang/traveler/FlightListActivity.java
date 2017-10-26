package com.jinqihang.traveler;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jinqihang.traveler.adapter.FlightListAdapter;
import com.jinqihang.traveler.javabean.FlightBean;
import com.jinqihang.traveler.javabean.FlightModel;

import java.util.ArrayList;
import java.util.List;

public class FlightListActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView flightListView;

    private String[] startTime = {"8:00", "9:00", "10:00","8:00", "9:00", "10:00","8:00", "9:00", "10:00"};
    private String[] endTime = {"11:00", "12:00", "13:00","11:00", "12:00", "13:00","11:00", "12:00", "13:00"};
    private String[] startAirport = {"机场1", "机场3", "机场5","机场1", "机场3", "机场5","机场1", "机场3", "机场5"};
    private String[] endAirport = {"机场2", "机场4", "机场6","机场2", "机场4", "机场6","机场2", "机场4", "机场6"};
    private String[] startPlane = {"机型1","机型3","机型5","机型1","机型3","机型5","机型1","机型3","机型5"};
    private String[] endPlane = {"机型2","机型4","机型6","机型2","机型4","机型6","机型2","机型4","机型6"};
    private String[] price = {"￥600","￥700","￥800","￥600","￥700","￥800","￥600","￥700","￥800","￥900",
            "￥600","￥700","￥800","￥600","￥700","￥800","￥600","￥700","￥800","￥900"};

    private String startCityName;
    private String arriveCityName;
    private List<FlightBean> flightList;
    private FlightListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);
        // 隐藏原始标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        // 标题栏回退按钮
        ImageView titleBack = (ImageView) findViewById(R.id.flight_title_back);
        TextView startCity = (TextView) findViewById(R.id.start_city);
        TextView arriveCity = (TextView) findViewById(R.id.end_city);
        startCityName = getIntent().getStringExtra("startCityName");
        arriveCityName = getIntent().getStringExtra("arriveCityName");
        startCity.setText(startCityName);
        arriveCity.setText(arriveCityName);
        titleBack.setOnClickListener(this);
        //
        flightListView = (ListView) findViewById(R.id.flight_list);
        flightList = new ArrayList<FlightBean>();
        // 初始化航班信息数据
        initData();
        adapter = new FlightListAdapter(FlightListActivity.this);
        adapter.setListItems(flightList);
        flightListView.setAdapter(adapter);
        flightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(FlightListActivity.this, "点击了"+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initData(){
        List<FlightModel> flightModelList = (List<FlightModel>) getIntent().getSerializableExtra("flightList");
        for (int i = 0; i < flightModelList.size(); i++){
            FlightBean flightBean = new FlightBean();
            flightBean.setStartTime(flightModelList.get(i).getDepartTime());
            flightBean.setEndTime(flightModelList.get(i).getArriveTime());
            flightBean.setStartAirport(flightModelList.get(i).getDepartAirport());
            flightBean.setEndAirport(flightModelList.get(i).getArriveAirport());
            flightBean.setAirlineCompany(flightModelList.get(i).getAirlineShortName());
            flightBean.setPlane(flightModelList.get(i).getPlaneModelName());
            flightBean.setPrice(price[i]);

//            flightBean.setStartTime(startTime[i]);
//            flightBean.setEndTime(endTime[i]);
//            flightBean.setStartAirport(startAirport[i]);
//            flightBean.setEndAirport(endAirport[i]);
//            flightBean.setAirlineCompany(startPlane[i]);
//            flightBean.setPlane(endPlane[i]);
//            flightBean.setPrice(price[i]);
            flightList.add(flightBean);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.flight_title_back:
                finish();
                break;
        }
    }
}
