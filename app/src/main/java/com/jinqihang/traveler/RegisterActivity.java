package com.jinqihang.traveler;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        TextView titleText = (TextView) findViewById(R.id.title_text);
        TextView titleRight = (TextView) findViewById(R.id.title_edit);
        ImageView titleBack = (ImageView) findViewById(R.id.title_back);
        titleText.setText("注册");
        titleRight.setVisibility(View.INVISIBLE);
        titleBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
