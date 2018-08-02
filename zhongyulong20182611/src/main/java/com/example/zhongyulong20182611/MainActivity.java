package com.example.zhongyulong20182611;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView listView;
    private String path = "http://www.wanandroid.com/article/list/0/json";
    private List<UserBean.DataBean.DatasBean> datas;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(path);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this,longin.class);
                String projectLink = datas.get(i).getProjectLink();
                it.putExtra("projectLink",projectLink);
                startActivity(it);
            }
        });

    }
        class  MyAsyncTask extends AsyncTask<String,Void,String>{

            @Override
            protected String doInBackground(String... strings) {

                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    if (urlConnection.getResponseCode() == 200){
                        InputStream inputStream = urlConnection.getInputStream();
                        s = toString(inputStream);
                        Log.i("TAG",s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                return s;
            }

            private String toString(InputStream inputStream) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuilder builder = new StringBuilder();
                String ss = null;
                try {
                    while ((ss = reader.readLine())!=null){
                        builder.append(ss);
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return builder.toString();
            }


            @Override
            protected void onPostExecute(String sa) {

                Gson gson = new Gson();
                UserBean userBean = gson.fromJson(sa,UserBean.class);
                datas = userBean.getData().getDatas();
                Mybaes mybaes = new Mybaes(MainActivity.this,datas);
                listView.setAdapter(mybaes);
                super.onPostExecute(sa);
            }




        }
}
