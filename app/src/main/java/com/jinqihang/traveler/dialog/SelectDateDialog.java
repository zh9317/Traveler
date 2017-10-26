package com.jinqihang.traveler.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.jinqihang.traveler.R;
import com.jinqihang.traveler.view.WheelStyle;
import com.jinqihang.traveler.view.WheelView;

import java.util.Calendar;

/**
 * 日期选择对话框
 * Created by huangzj on 2015/10/25.
 * Created by Administrator on 2017/10/16 0016.
 */

public class SelectDateDialog extends BaseDialog {

    private View dialogView;
    private WheelView yearWheel;
    private WheelView monthWheel;
    private WheelView dayWheel;

    int selectYear;
    int selectMonth;

    private OnClickListener onClickListener;

    /**
     * 创建一个日期选择对话框
     *
     * @param mContext
     */
    public SelectDateDialog(Context mContext) {
        this.context = mContext;
        create();
    }

    /**
     * 创建一个日期选择对话框
     *
     * @param mContext
     */
    public SelectDateDialog(Context mContext, OnClickListener listener) {
        this.context = mContext;
        onClickListener = listener;
        create();
    }

    /**
     * 创建选择日期对话框
     */
    private void create() {

        if (dialog != null) {
            return;
        }

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        dialogView = layoutInflater.inflate(R.layout.dialog_wheel_select_date, null);
        yearWheel = (WheelView) dialogView.findViewById(R.id.select_date_wheel_year_wheel);
        monthWheel = (WheelView) dialogView.findViewById(R.id.select_date_month_wheel);
        dayWheel = (WheelView) dialogView.findViewById(R.id.select_date_day_wheel);

        yearWheel.setWheelStyle(WheelStyle.STYLE_YEAR);
        yearWheel.setOnSelectListener(new WheelView.SelectListener() {
            @Override
            public void onSelect(int index, String text) {
                selectYear = index + WheelStyle.minYear;
                dayWheel.setWheelItemList(WheelStyle.createDayString(selectYear, selectMonth));
            }
        });

        monthWheel.setWheelStyle(WheelStyle.STYLE_MONTH);
        monthWheel.setOnSelectListener(new WheelView.SelectListener() {
            @Override
            public void onSelect(int index, String text) {
                selectMonth = index + 1;
                dayWheel.setWheelItemList(WheelStyle.createDayString(selectYear, selectMonth));
            }
        });

        Button cancelBt = (Button) dialogView.findViewById(R.id.select_date_cancel);
        cancelBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    if (!onClickListener.onCancel()) {
                        dialog.dismiss();
                    }
                } else {
                    dialog.dismiss();
                }
            }
        });
        Button sureBt = (Button) dialogView.findViewById(R.id.select_date_sure);
        sureBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int year = yearWheel.getCurrentItem() + WheelStyle.minYear;
                int month = monthWheel.getCurrentItem();
                int day = dayWheel.getCurrentItem() + 1;
                int daySize = dayWheel.getItemCount();
                if (day > daySize) {
                    day = day - daySize;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DATE, day);
                String week = "";
                int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
                switch (weekIndex)
                {
                    case 1:
                        week = "周日";
                        break;
                    case 2:
                        week = "周一";
                        break;
                    case 3:
                        week = "周二";
                        break;
                    case 4:
                        week = "周三";
                        break;
                    case 5:
                        week = "周四";
                        break;
                    case 6:
                        week = "周五";
                        break;
                    case 7:
                        week = "周六";
                        break;
                }
                long setTime = calendar.getTimeInMillis();

                if (onClickListener != null) {
                    if (!onClickListener.onSure(year, month, day, setTime, week)) {
                        dialog.dismiss();
                    }
                } else {
                    dialog.dismiss();
                }
            }
        });
        dialog = new AlertDialog.Builder(context).setView(dialogView).create();


    }

    /**
     * 显示选择日期对话框
     *
     * @param year  默认显示的年
     * @param month 默认月
     * @param day   默认日
     */
    public void show(int year, int month, int day) {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dayWheel.setWheelItemList(WheelStyle.createDayString(year - WheelStyle.minYear, month + 1));
        yearWheel.setCurrentItem(year - WheelStyle.minYear);
        monthWheel.setCurrentItem(month);
        dayWheel.setCurrentItem(day - 1);
        dialog.show();
    }


    /**
     * 选择日期对话框回调
     *
     * @param listener
     */
    public void setOnClickListener(OnClickListener listener) {
        onClickListener = listener;
    }

    /**
     * 选择日期对话框回调接口，调用者实现
     *
     * @author huangzj
     */
    public interface OnClickListener {
        boolean onSure(int year, int month, int day, long time, String week);

        boolean onCancel();
    }
}
