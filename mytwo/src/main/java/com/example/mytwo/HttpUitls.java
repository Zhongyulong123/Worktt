package com.example.mytwo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class HttpUitls {
 private Context context;
 private  boolean isConnectivity;

    public HttpUitls(Context context) {
        this.context = context;
    }
    public boolean isConnectivity(){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnected()){
            isConnectivity = true;
        }else {
            isConnectivity = false;
        }
        return isConnectivity;
    }
}
