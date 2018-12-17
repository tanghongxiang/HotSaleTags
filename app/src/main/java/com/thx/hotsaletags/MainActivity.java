package com.thx.hotsaletags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.thx.hotsaleview.HotSaleView;

/**
 * @Description:
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00
 * @Create Date: 2018/12/17 18:04
 */
public class MainActivity extends AppCompatActivity {
    private HotSaleView hotSaleView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotSaleView=findViewById(R.id.mHotSaleView);
        hotSaleView.setCanShowRightBlock(true);
    }

}
