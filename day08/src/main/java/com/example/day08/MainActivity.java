package com.example.day08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private String path1 = "https://cdn.duitang.com/uploads/item/201601/02/20160102003015_uvNSA.thumb.700_0.jpeg";
private String path2 = "https://img5.duitang.com/uploads/item/201601/13/20160113130212_sjMvJ.thumb.700_0.jpeg";
private String path3 = "https://img4.duitang.com/uploads/item/201610/07/20161007133128_iuLNC.thumb.700_0.jpeg";
private String path4 = "https://img3.duitang.com/uploads/item/201609/01/20160901152736_2tNTf.thumb.700_0.jpeg";
private String path5 = "http://img1.imgtn.bdimg.com/it/u=200295921,1517028715&fm=214&gp=0.jpg";
private List<String> list;
private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);

        //初始化
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
        //默认配置
        DisplayImageOptions options = DisplayImageOptions.createSimple();

        //设置展示图片
        ImageLoader.getInstance().displayImage(path2,img,options);
    }
}
