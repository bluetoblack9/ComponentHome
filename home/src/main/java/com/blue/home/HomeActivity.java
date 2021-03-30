package com.blue.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blue.common.BaseActivity;
import com.blue.export_news.NewsServiceUtil;
import com.blue.export_news.router.NewsRouterTable;

/**
 * Created by blue on 2021/03/29.
 * (*^▽^*)
 * 描述:
 */
@Route(path = "/home/HomeActivity")
public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        findViewById(R.id.btn_to_news).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过路由跳转到 新闻组件的新闻页面（但没有依赖新闻组件）
//                ARouter.getInstance()
//                        .build("/news/NewActivity")
//                        .withString("key1","value1")//携带参数1
//                        .withString("key2","value2")//携带参数2
//                        .navigation();

                NewsServiceUtil.navigateNewsPage("param1", "param1");
            }
        });

        //调用新闻组件服务：获取新闻数量
        TextView tvNewProductCount = findViewById(R.id.tv_news_num);
        tvNewProductCount.setText("新闻数量:"+ NewsServiceUtil.getNewsProductCount().productCount);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();;

        //使用ARouter获取Fragment实例 并添加
        Fragment userFragment = (Fragment) ARouter.getInstance()
                .build(NewsRouterTable.PATH_FRAGMENT_NEWS).navigation();
        transaction.add(R.id.fm_news, userFragment, "tag");
        transaction.commit();
    }
}
