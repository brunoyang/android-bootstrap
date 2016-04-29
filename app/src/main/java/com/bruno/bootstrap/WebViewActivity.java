package com.bruno.bootstrap;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class WebViewActivity extends Fragment {
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.activity_web_view, container, false);


        webView = (WebView) relativeLayout.findViewById(R.id.webview);
        if (Build.VERSION.SDK_INT >= 19) {
            Toast.makeText(getContext(), "hhahhhhaha", Toast.LENGTH_LONG).show();
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(getContext(), "bruno");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:document.querySelector('#logo>img').src = 'http://i1.hdslb.com/headers/58c71871161412e2ad656485c9a89ecc.png';");
            }

        });
        webView.loadUrl("http://baidu.com");


        return relativeLayout;
    }

}
