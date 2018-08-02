package com.example.day10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.day10.Adapter.MyBase;
import com.example.day10.Bean.XlistBean;
import com.example.day10.XListView.XListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private String path = "http://www.yulin520.com/a2a/impressApi/news/mergeList?pageSize=15&page=";
        private int page = 1;
        private XListView xListView;

        private List<XlistBean.DataBean> list = new ArrayList<>();
        private MyBase myBase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            xListView = findViewById(R.id.xlisetview);
            //访问数据
            getDataFromWork();

            //获取资源
           initFromByID();

        }

        private void initFromByID() {


            //可以加载
            xListView.setPullRefreshEnable(true);
            //可以刷新
            xListView.setPullLoadEnable(true);
            xListView.setXListViewListener(new XListView.IXListViewListener() {
                @Override
                //刷新
                public void onRefresh() {
                    page = 1;
                    getDataFromWork();
                }

                @Override
                //加载
                public void onLoadMore() {
                    page ++;
                    getDataFromWork();
                }

            });
            myBase = new MyBase(MainActivity.this, list);
            xListView.setAdapter(myBase);
        }

        public void getDataFromWork() {
             HttpUtils httpUtils=HttpUtils.getInstance();
            String url = path + page;
            httpUtils.getdata(url);

            //接口回掉
            httpUtils.setHttpListnenr(new HttpUtils.HttpListener() {
                @Override
                public void getjsondata(String json) {
                    Gson gson = new Gson();
                    XlistBean xlistBean = gson.fromJson(json, XlistBean.class);

                    List<XlistBean.DataBean> data = xlistBean.getData();



                   if (page == 1) {
                        list.clear();
                    }
                    //添加数据
                    list.addAll(data);
                    myBase.notifyDataSetChanged();

                    if (page == 1) {
                        xListView.stopRefresh();
                    } else {
                        xListView.stopLoadMore();
                    }

                }
            });


        }
}
