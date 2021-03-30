package com.blue.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by blue on 2021/03/29.
 * (*^▽^*)
 * 描述:
 */
@Route(path = "/home/HomeActivity")
public class HomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        findViewById(R.id.btn_to_news).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过路由跳转到 购物车组件的购物车页面（但没有依赖购物车组件）
                ARouter.getInstance()
                        .build("/news/NewsActivity")
                        .withString("key1","value1")//携带参数1
                        .withString("key2","value2")//携带参数2
                        .navigation();
            }
        });
    }
}
