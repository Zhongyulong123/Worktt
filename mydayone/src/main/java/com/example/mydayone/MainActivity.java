package com.example.mydayone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
private String path = "http://v.juhe.cn/joke/content/list.php?sort=asc&page=&pagesize=&time=1418816972&key=bd9fed04f70d0112cd52b674c0a1b671";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getdate(View view){
        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    URL url = new URL(path);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);

                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode == 200){
                        InputStream inputStream = urlConnection.getInputStream();


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    private  String streamToString(InputStream inputStream){
        return  null;
    }
}
