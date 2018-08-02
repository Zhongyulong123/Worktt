package com.example.day07.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2018/6/11.
 * 网络
 */


public class NetUtils {
    private  LoadBitmapListenenr loadBitmapListenenr;

    public  void getBitmapFramNetWork(String url){
        MyAsynvTask asyncTask = new MyAsynvTask();


    }
    class MyAsynvTask extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode() ==200){
                    InputStream inputStream = connection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return  bitmap;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            loadBitmapListenenr.getBitmap(bitmap);
        }
    }

    //接口
    public  interface LoadBitmapListenenr{
        void getBitmap(Bitmap bitmap);
    }
    public void setLoadBitmapListenenr(LoadBitmapListenenr loadBitmapListenenr){
        this.loadBitmapListenenr = loadBitmapListenenr;
    }
}
