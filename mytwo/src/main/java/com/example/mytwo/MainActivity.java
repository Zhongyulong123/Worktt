package com.example.mytwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private  HttpUitls uitls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uitls = new HttpUitls(this);

        boolean connectivity = uitls.isConnectivity();

        if (connectivity){

        }else {

        }
    }
}
