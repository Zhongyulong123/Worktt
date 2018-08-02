package com.example.myday04;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private String path ="http://v.juhe.cn/joke/content/list.php?sort=112&page=&pagesize=&time=1418816972&key=bd9fed04f70d0112cd52b674c0a1b671";
    private ListView listView;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        MyAsynctack myAsynctack=new MyAsynctack();
        myAsynctack.execute(path);
    }
    class MyAsynctack extends AsyncTask<String,Void,String> {


        //请求网络 做耗时操作   String... 数组   Uri
        @Override
        protected String doInBackground(String... params) {

            String json = "";
            try {
                //将传进来的接口转换成URL
                URL url = new URL(params[0]);
                //打开HttpURLConnection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //设置请求方式
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);//设置超时链接
                connection.setReadTimeout(5000);//设置读取超时

                //得到响应码 进行判断
                if(connection.getResponseCode() == 200){
                    //得到数据
                    InputStream inputStream = connection.getInputStream();

                    //转换
                    json = StreamToString(inputStream);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return json;
        }

        //在doInBackground之前执行的方法
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //创建进度条的弹框
            dialog = new ProgressDialog(MainActivity.this);
            //设置样式
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("正在加载...");
            dialog.show();


        }
        //在doInBackground之后执行的方法
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //解析
            Log.i("TAG",s);
            Gson gson = new Gson();

            ConstellationBean constellationBean = gson.fromJson(s, ConstellationBean.class);
            //将解析出来的数据 存入集合
            List<ConstellationBean.ResultBean.DataBean> list = constellationBean.getResult().getData();
            Mybase Mybase = new Mybase(MainActivity.this,list);
            listView.setAdapter(Mybase);

            //请求完数据后 将进度框显示
            if(dialog!=null){
                dialog.dismiss();
            }

        }

        //网络加载的进度
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    //将字节流转换成字符流的方法
    private String StreamToString(InputStream inputStream) {

        //字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //缓冲流
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String s = null;
        StringBuilder builder = new StringBuilder();

        try {
            while ((s = reader.readLine())!=null){

                builder.append(s);

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return builder.toString();

    }
}
