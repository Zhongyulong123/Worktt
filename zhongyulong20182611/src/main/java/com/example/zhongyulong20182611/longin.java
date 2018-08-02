package com.example.zhongyulong20182611;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Administrator on 2018/6/11.
 */

public class longin extends Activity {
    private WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.login);
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String projectLink = intent.getStringExtra("projectLink");

        Log.i("TAG","llllll");
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        webView.loadUrl(projectLink);

    }
}
