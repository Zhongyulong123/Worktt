package com.example.myasynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
private  String path = "http://v.juhe.cn/joke/content/list.php?sort=112&page=&pagesize=&time=1418816972&key=bd9fed04f70d0112cd52b674c0a1b671";
private ListView listView;
private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        MyAsynctask asynctask = new MyAsynctask();
        asynctask.execute(path);
    }
    class  MyAsynctask extends AsyncTask<String,Void,String>{

        private String StreamToString(InputStream inputStream){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader reader = new BufferedReader(inputStreamReader);
            String s = null;
            StringBuilder builder = new StringBuilder();

            try {
                while ((s = reader.readLine())!=null){
                    builder.append(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return builder.toString();
        }

        @Override
        protected String doInBackground(String... strings) {
            String json = "";
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                if (connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    json = StreamToString(inputStream);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return json;
        }
        //在doinbackground之前的方法
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.show();;
        }
        //在doinbackground之后执行的方法
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("TAG",s);
            Gson gson = new Gson();
           ConstellationBean constellationBean = gson.fromJson(s,ConstellationBean.class);
            List<ConstellationBean.ResultBean.DataBean> list =constellationBean.getResult().getData();
                Mybase mybase = new Mybase(MainActivity.this,list);
                listView.setAdapter(mybase);
                if (dialog!=null){
                    dialog.dismiss();
                }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
