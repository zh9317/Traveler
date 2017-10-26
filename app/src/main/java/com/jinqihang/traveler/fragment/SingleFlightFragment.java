package com.jinqihang.traveler.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jinqihang.traveler.FlightListActivity;
import com.jinqihang.traveler.R;
import com.jinqihang.traveler.SelectCityActivity;
import com.jinqihang.traveler.dialog.SelectDateDialog;
import com.jinqihang.traveler.http.CityApi;
import com.jinqihang.traveler.http.FlightApi;
import com.jinqihang.traveler.http.ResponseBlock;
import com.jinqihang.traveler.javabean.BaseModle;
import com.jinqihang.traveler.javabean.CityData;
import com.jinqihang.traveler.javabean.FlightModel;
import com.jinqihang.traveler.utils.ChineseToPinyin;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class SingleFlightFragment extends Fragment implements View.OnClickListener{

    View singleFlightLayout;
    RelativeLayout selectDateLayout;
    TextView selectStartCityText;
    TextView selectEndCityText;
    TextView selectStartDateText;
    TextView selectEndDateText;
    TextView selectStartWeekText;
    TextView selectEndWeekText;

    private String[] weekString;
    private String[] letterArr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private List<String> letterList;
    public static String startCityName;
    public static String arriveCityName;
    public static String[] firstLetterArr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        singleFlightLayout = inflater.inflate(R.layout.single_flight_layout, container, false);
        letterList = new ArrayList<>(Arrays.asList(letterArr));
        initValue();
        initView();
        return singleFlightLayout;
    }

    private void initValue() {
        startCityName = "北京";
        arriveCityName = "上海";
        weekString = getResources().getStringArray(R.array.weeks);
    }

    private void initView(){
        selectDateLayout = (RelativeLayout) singleFlightLayout.findViewById(R.id.flight_date_select_layout);
        // 启程日期
        selectStartDateText = (TextView) singleFlightLayout.findViewById(R.id.start_flight_date);
        // 返程日期
        selectEndDateText = (TextView) singleFlightLayout.findViewById(R.id.end_flight_date);
        // 单程票隐藏返程日期
        selectEndDateText.setVisibility(View.INVISIBLE);
        // 开始星期
        selectStartWeekText = (TextView) singleFlightLayout.findViewById(R.id.start_flight_week);
        // 返程星期
        selectEndWeekText = (TextView) singleFlightLayout.findViewById(R.id.end_flight_week);
        // 单程票隐藏返程星期
        selectEndWeekText.setVisibility(View.INVISIBLE);

        selectStartCityText = (TextView) singleFlightLayout.findViewById(R.id.start_city);
        selectEndCityText = (TextView) singleFlightLayout.findViewById(R.id.end_city);
        Button searchFlight = (Button) singleFlightLayout.findViewById(R.id.search_flight_button);
        selectDateLayout.setOnClickListener(this);
        selectStartCityText.setOnClickListener(this);
        selectEndCityText.setOnClickListener(this);
        searchFlight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_flight_button:
                // 跳转至航班列表页面
                Log.i("Single","-------------------------");
                FlightApi flightApi = new FlightApi();
                flightApi.requestHttpWithBlock(new ResponseBlock() {
                    @Override
                    public void onResponseBlock(boolean isSuccess, Object responseObject, String msg) throws IOException {
                        if (isSuccess){
                            // 得到航班列表
                            List<FlightModel> list = (ArrayList<FlightModel>) responseObject;
                            Log.i("SingleFlightFragment", list.get(0).getArriveTime());
                            Intent intent = new Intent(getActivity(), FlightListActivity.class);
                            intent.putExtra("flightList", (Serializable) list);
                            intent.putExtra("startCityName", startCityName);
                            Log.i("SingleFlightFragment", startCityName);
                            intent.putExtra("arriveCityName", arriveCityName);
                            startActivity(intent);
                        }else {
                            Log.i("SingleFlightFragment",msg);
                        }
                    }
                });
//                Intent intent = new Intent(getActivity(), FlightListActivity.class);
//                startActivity(intent);
                break;
            case R.id.flight_date_select_layout:
                // 点击选择日期
                showSelectDateDialog();
                break;
            case R.id.start_city:
                // 跳转到选择城市页面
                Log.i("Single","-------------------------");
                CityApi startCity = new CityApi();
                startCity.requestHttpWithBlock(new ResponseBlock() {
                    @Override
                    public void onResponseBlock(boolean isSuccess,Object responseObject, String msg) throws IOException {
                        if (isSuccess) {
                            // 得到城市信息列表
                            List<CityData> list = (ArrayList<CityData>) responseObject;
                            List<String> nameList = new ArrayList<String>();
                            for (int i = 0; i < list.size(); i++){
                                nameList.add(list.get(i).getZoneName());
                            }
                            // 放置首字母的List
                            List<String> firstLetterList = new ArrayList<String>();
                            for (CityData cityData : list){
                                firstLetterList.add(ChineseToPinyin.getPinYinFirstLetter(cityData.getZoneName()).toUpperCase());
                                Log.i("SingleFlightFragment",ChineseToPinyin.getPinYinFirstLetter(cityData.getZoneName()).toUpperCase());
                            }
//                            Map<String, String> cityMap = new HashMap<String, String>();
//                            for (int i = 0; i < 26; i++){
//                                for (int j = 0; j < firstLetterList.size(); j++){
//                                    if (firstLetterList.get(j).equals(letterList.get(i))){
//                                        cityMap.put(firstLetterList.get(j), list.get(i).getZoneName());
//                                    }
//                                }
//                            }
                            firstLetterArr = firstLetterList.toArray(new String[0]);
                            Intent intentStartCity = new Intent(getActivity(), SelectCityActivity.class);
                            intentStartCity.putExtra("list",(Serializable) list);
                            startActivityForResult(intentStartCity, 1);
                        }else {
                            Log.i("SingleFlightFragment",msg);
                        }
                    }
                });
                break;
            case R.id.end_city:
                CityApi endCity = new CityApi();
                endCity.requestHttpWithBlock(new ResponseBlock() {
                    @Override
                    public void onResponseBlock(boolean isSuccess,Object responseObject, String msg) throws IOException {
                        if (isSuccess) {
                            // 得到城市信息列表
                            List<CityData> list = (ArrayList<CityData>) responseObject;
                            // 放置首字母的List
                            List<String> firstLetterList = new ArrayList<String>();
                            for (CityData cityData : list){
                                firstLetterList.add(ChineseToPinyin.getPinYinFirstLetter(cityData.getZoneName()));
                                Log.i("SingleFlightFragment",ChineseToPinyin.getPinYinFirstLetter(cityData.getZoneName()));
                            }
                            firstLetterArr = firstLetterList.toArray(new String[0]);
                            Intent intentStartCity = new Intent(getActivity(), SelectCityActivity.class);
                            intentStartCity.putExtra("list",(Serializable) list);
                            startActivityForResult(intentStartCity, 1);
                        }else {
                            Log.i("SingleFlightFragment",msg);
                        }
                    }
                });
        }
    }

    private void showSelectDateDialog() {
        SelectDateDialog mSelectDateDialog = new SelectDateDialog(getContext());
        mSelectDateDialog.setOnClickListener(new SelectDateDialog.OnClickListener() {
            @Override
            public boolean onSure(int mYear, int mMonth, int mDay, long time, String week) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                selectStartDateText.setText(mMonth + 1 + "月" + mDay + "日");
                selectStartWeekText.setText(week);
                return false;
            }

            @Override
            public boolean onCancel() {
                return false;
            }
        });
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String date = dateFormat.format(curDate);
        String[] dateStr = date.split("-");
        int year = Integer.valueOf(dateStr[0]);
        int month = Integer.valueOf(dateStr[1]);
        int day = Integer.valueOf(dateStr[2]);
        mSelectDateDialog.show(year, month-1, day);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == getActivity().RESULT_OK){
                    startCityName =data.getStringExtra("cityName");
                    Log.i("Single", startCityName);
                    selectStartCityText.setText(startCityName);
                }
                break;
            case 2:
                if (resultCode == getActivity().RESULT_OK){
                    String endCityName =data.getStringExtra("cityName");
                    Log.i("Single", endCityName);
                    selectEndCityText.setText(endCityName);
                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void parseJSONWithGSON(String jsonData){
        Gson gson = new Gson();
        Log.i("Single","-------------------------");
        List<BaseModle> cityList = gson.fromJson(jsonData, new TypeToken<List<BaseModle>>(){}.getType());
        for (BaseModle baseModle : cityList){
            Log.i("SingleFlightFragment", baseModle.getData());
        }
    }

}
