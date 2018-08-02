package com.example.zhoukao01;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zhoukao01.com.bawei.Fragment.Fragmentone;
import com.example.zhoukao01.com.bawei.Fragment.Fragmenttwo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private FrameLayout fragment;
private Fragmentone fragmentone;
private Fragmenttwo fragmenttwo;
private RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        group = findViewById(R.id.group);
    }
    private  void initViews(){
        RadioButton btn1 = findViewById(R.id.btn1);
        RadioButton btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        fragment=findViewById(R.id.frame);
        fragmentone = new Fragmentone();
        fragmenttwo = new Fragmenttwo();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.replace(R.id.frame,fragmentone);
        beginTransaction.commit();


    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.btn1:
    android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.replace(R.id.frame,fragmentone);
        beginTransaction.commit();

        break;
    case R.id.btn2:
        android.support.v4.app.FragmentManager manager1 = getSupportFragmentManager();
        FragmentTransaction beginTransaction1 = manager1.beginTransaction();
        beginTransaction1.replace(R.id.frame,fragmenttwo);
        beginTransaction1.commit();

        break;
    
}
    }
}
