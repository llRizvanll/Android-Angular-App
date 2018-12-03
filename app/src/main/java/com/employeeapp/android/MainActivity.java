package com.employeeapp.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private static final String INDEX_PATH = "file:///android_asset/index.html";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        loadContents();
    }

    private void loadContents(){
        WebSettings webconfig = webView.getSettings();
        webconfig.setJavaScriptEnabled(true);
        webconfig.setJavaScriptCanOpenWindowsAutomatically(true);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            webconfig.setAllowFileAccessFromFileURLs(true);
            webconfig.setAllowUniversalAccessFromFileURLs(true);
        }

        webconfig.setDomStorageEnabled(true);
        webconfig.setAllowContentAccess(true);
        webconfig.setAllowFileAccessFromFileURLs(true);
        webconfig.setAppCacheEnabled(true);
        webconfig.setAllowFileAccess(true);
        webconfig.setDatabaseEnabled(true);
        webconfig.setGeolocationEnabled(true);
        webconfig.setLoadsImagesAutomatically(true);
        webconfig.setLoadWithOverviewMode(true);
        webconfig.setPluginState(WebSettings.PluginState.ON);
        webconfig.setUseWideViewPort(true);
        webView.loadUrl(INDEX_PATH);
    }
}
