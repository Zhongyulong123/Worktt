package com.example.day07;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.day07.Utils.DiskUtils;
import com.example.day07.Utils.MemoryUtils;
import com.example.day07.Utils.NetUtils;

/**
 * Created by Administrator on 2018/6/11.
 */

public class MyimageUtils {
    private static MyimageUtils myimageUtils;
    private static MemoryUtils memoryUtils;
    private static DiskUtils diskUtils;
    private static NetUtils netUtils;

    public static MyimageUtils getMyimageUtils(){
        if (myimageUtils == null){
            myimageUtils = new MyimageUtils();
            memoryUtils = new MemoryUtils();
            diskUtils = new DiskUtils();
            netUtils = new NetUtils();
        }
      return myimageUtils;
    }
    public  void dispaly(final String url, final ImageView imageView){
        Bitmap memoryUtilsmap = memoryUtils.getBitmap(url);
        if (memoryUtilsmap!=null){
            imageView.setImageBitmap(memoryUtilsmap);
        }else {
           final Bitmap diskUtilsBitmap1 = diskUtils.getBitmap(url);
           if (diskUtilsBitmap1!=null){
               imageView.setImageBitmap(diskUtilsBitmap1);
               memoryUtils.saveToMemory(url,diskUtilsBitmap1);
           }else {
               netUtils.getBitmapFramNetWork(url);
               netUtils.setLoadBitmapListenenr(new NetUtils.LoadBitmapListenenr() {
                   @Override
                   public void getBitmap(Bitmap bitmap) {
                       imageView.setImageBitmap(bitmap);

                       memoryUtils.saveToMemory(url,bitmap);
                       diskUtils.saveToDisk(url,bitmap);
                   }
               });
           }
        }
    }
}
