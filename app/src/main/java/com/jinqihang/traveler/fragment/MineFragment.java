package com.jinqihang.traveler.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jinqihang.traveler.LoginActivity;
import com.jinqihang.traveler.R;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class MineFragment extends Fragment implements View.OnClickListener{

    private View mineLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mineLayout = inflater.inflate(R.layout.mine_layout, container, false);
        initView();
        return mineLayout;
    }
    private void initView(){
        Button button = (Button) mineLayout.findViewById(R.id.button_login);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                // 跳转到登录页面
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
