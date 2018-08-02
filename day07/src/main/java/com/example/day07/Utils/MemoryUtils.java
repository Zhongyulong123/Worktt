package com.example.day07.Utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Administrator on 2018/6/11.
 * 内存缓存
 */

public class MemoryUtils {
    private LruCache<String,Bitmap> lruCache = new LruCache<>((int)(Runtime.getRuntime().freeMemory()/8));

    public void saveToMemory(String url,Bitmap bitmap){
        lruCache.put(url,bitmap);
    }

    public Bitmap getBitmap(String url){
        Bitmap bitmap = lruCache.get(url);
        return  bitmap;
    }
}
