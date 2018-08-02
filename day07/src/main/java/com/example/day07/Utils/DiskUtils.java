package com.example.day07.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/6/11.
 * 磁盘
 */

public class DiskUtils {
private  String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/image";

public void saveToDisk(String url, Bitmap bitmap){
    String encode = null;

    try {
        encode = URLEncoder.encode(url,"UTF-8");

    } catch (Exception e) {
        e.printStackTrace();
    }
    File file = new File(path,encode);
    File parentFile = file.getParentFile();
    if (!parentFile.exists()){
        parentFile.mkdir();

        try {
            bitmap.compress(Bitmap.CompressFormat.PNG,100,new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
public Bitmap getBitmap(String url){
    String  encode = null;
    try {
        encode = URLEncoder.encode(url,"UTF-8");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    File file = new File(path,encode);
    Bitmap bitmap = BitmapFactory.decodeFile(file.getName());
    return bitmap;
}
}
