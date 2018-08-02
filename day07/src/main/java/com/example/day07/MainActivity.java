package com.example.day07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private ImageView imageView;
private String url = "https://cdn.duitang.com/uploads/item/201601/02/20160102003015_uvNSA.thumb.700_0.jpeg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);

        MyimageUtils.getMyimageUtils().dispaly(url,imageView);
    }
}
