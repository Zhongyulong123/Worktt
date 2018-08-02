package com.example.day0802;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private String path1 = "https://cdn.duitang.com/uploadhttps://s/item/201601/02/20160102003015_uvNSA.thumb.700_0.jpeg";
    private String path2 = "https://img5.duitang.com/uploads/item/201601/13/20160113130212_sjMvJ.thumb.700_0.jpeg";
    private String path3 = "https://img4.duitang.com/uploads/item/201610/07/20161007133128_iuLNC.thumb.700_0.jpeg";
    private String path4 = "https://img3.duitang.com/uploads/item/201609/01/20160901152736_2tNTf.thumb.700_0.jpeg";
    private String path5 = "http://img1.imgtn.bdimg.com/it/u=200295921,1517028715&fm=214&gp=0.jpg";
    private List<String> list;
    private ListView listView;

    private static final String TAG = "MainActivity-------";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取资源ID
        listView = findViewById(R.id.listview);

        list = new ArrayList<>();
            //list.add(path1);
            list.add(path2);
            list.add(path3);
            list.add(path4);
            list.add(path5);
        Log.d(TAG, "onCreate: ----"+list);
        Mybase mybase = new Mybase(list,MainActivity.this);
        listView.setAdapter(mybase);
    }
}
