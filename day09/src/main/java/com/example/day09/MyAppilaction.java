package com.example.day09;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.logging.Handler;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MyAppilaction extends Application {
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initImageLoader();
    }

    private void initImageLoader() {
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context);
        ImageLoader.getInstance().init(builder.build());
    }
    public static DisplayImageOptions getOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher) // 设置图片加载或解码过程中发生错误显示的图片
                .resetViewBeforeLoading(false)  // default 设置图片在加载前是否重置、复位
                .delayBeforeLoading(0)  // 下载前的延迟时间
                .cacheInMemory(true) // default  设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // default  设置下载的图片是否缓存在SD卡中
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default 设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default 设置图片的解码类型
//                .displayer(new RoundedBitmapDisplayer(300)) // default  还可以设置圆角图片new RoundedBitmapDisplayer(20)
                .build();
        return options;
    }
}
