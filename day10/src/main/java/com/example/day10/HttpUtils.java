package com.example.day10;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2018/6/14.
 */

public class HttpUtils {
    private static final String TAG = "HttpUtils--------";
    private static HttpUtils httpUtils;
    private HttpListener httpListnenr;
    public static HttpUtils getInstance(){
        if (httpUtils == null){
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }
    //网络请求
    public void getdata(String url){
        Myasynctask asynctask = new Myasynctask();
        asynctask.execute(url);
    }
    //异步请求
    class Myasynctask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String json = "";
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    json = StreamToString(inputStream,"UTF-8");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "onPostExecute: ----"+s);
            httpListnenr.getjsondata(s);
        }
    }
    //转换
    private String StreamToString(InputStream inputStream,String s){
        StringBuilder builder = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream,s);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String string = null;
            builder = new StringBuilder();

            while ((string = reader.readLine())!=null){
                builder.append(string);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return builder.toString();

    }
    //定义接口
    public interface HttpListener{
        void  getjsondata(String json);
    }
    public void setHttpListnenr(HttpListener httpListnenr){
        this.httpListnenr = httpListnenr;
    }
}
