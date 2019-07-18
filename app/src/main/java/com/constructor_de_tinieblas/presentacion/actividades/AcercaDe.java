package com.constructor_de_tinieblas.presentacion.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.constructor_de_tinieblas.R;

public class AcercaDe extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceStatee) {
        super.onCreate(savedInstanceStatee);
        setContentView(R.layout.acerca_de);
    
        WebView myWebView = findViewById(R.id.acercade);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        //myWebView.loadUrl("https://whitewolf.fandom.com/es/wiki/Mundo_de_Tinieblas_Cl%C3%A1sico");
        myWebView.loadUrl("file:///android_asset/acercade.html");
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView mWebView;
        mWebView = findViewById(R.id.acercade);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                } else {
                    finish();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
