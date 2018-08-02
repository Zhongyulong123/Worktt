package com.example.day09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import Bean.CocietyBean;
import adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {
    private String path = "http://v.juhe.cn/toutiao/index?type=&key=edbcd842793dfde588f134a5bb3d6cab";
    private ListView listView;
    private HttpUtils httpUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        //获取实例
        httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getdata(path);
        httpUtils.setHttpListener(new HttpUtils.HttpListener() {
            @Override
            public void getjsondata(String json) {
                Gson gson = new Gson();
                CocietyBean cocietyBean = gson.fromJson(json, CocietyBean.class);
                List<CocietyBean.ResultBean.DataBean> data = cocietyBean.getResult().getData();

                MyAdapter adapter = new MyAdapter(MainActivity.this,data);
                listView.setAdapter(adapter);

            }
        });

    }
}
