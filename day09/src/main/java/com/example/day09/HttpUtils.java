package com.example.day09;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2018/6/13.
 */

public class HttpUtils {

    private HttpListener httpListener;
    //饿汉式
    private static HttpUtils httpUtils;
    public static HttpUtils getHttpUtils(){
        if (httpUtils==null){
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }
    //Asynctask网络请求
    public  void  getdata(String url){
        MyAsyncTask asyncTast = new MyAsyncTask();
        asyncTast.execute(url);
    }
    //异步请求
    class MyAsyncTask extends AsyncTask<String ,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String json = "";
            try {

                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    //转换
                    json = StreamToString(inputStream,"utf-8");
                    Log.i("TAG",json);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            httpListener.getjsondata(s);

        }



    }
    //转换
    private String StreamToString(InputStream inputStream,String s) {
        StringBuilder builder = null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String string = null;
        builder = new StringBuilder();
        try {
            while ((string = reader.readLine()) != null) {
                builder.append(string);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    //接口
    public interface HttpListener{
        void getjsondata(String json);
    }
    public void setHttpListener(HttpListener httpListener){
            this.httpListener = httpListener;
    }
}
