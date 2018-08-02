package com.example.mylanya;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private BluetoothAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter!=null){
            if (!adapter.isEnabled()){
                adapter.enable();
            }
        }
    }
}
