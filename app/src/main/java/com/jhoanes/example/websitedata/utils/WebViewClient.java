package com.jhoanes.example.websitedata.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import java.util.Objects;

import static com.jhoanes.example.websitedata.utils.WebEndsPoint.RODOLFO_FERNANDES_RN_GOV_BR;

public class WebViewClient extends android.webkit.WebViewClient {

    private static final String PDF = ".pdf";
    private Context mContext;
    private OnPageWeb mWeb;

    public interface OnPageWeb {
        void showLoading();
        void hideLoading();
        void showRefreshSwipe();
        void hideRefreshSwipe();
    }

    public WebViewClient(Context mContext, OnPageWeb web) {
        this.mContext = mContext;
        this.mWeb = web;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        if(Objects.requireNonNull(request.getUrl().getHost()).equals(RODOLFO_FERNANDES_RN_GOV_BR)
                && !request.getUrl().toString().endsWith(PDF)){
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
        mContext.startActivity(intent);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        mWeb.showLoading();
        mWeb.showRefreshSwipe();
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        mWeb.hideLoading();
        mWeb.hideRefreshSwipe();
    }
}
