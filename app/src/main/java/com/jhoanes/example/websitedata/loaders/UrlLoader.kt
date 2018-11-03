package com.jhoanes.example.websitedata.loaders

import android.webkit.WebView
import com.jhoanes.example.websitedata.utils.UrlGenerator
import com.jhoanes.example.websitedata.utils.WebEndsPoint.BASE_URL

class UrlLoader(webView: WebView) {
    private var mWebView : WebView = webView
    private lateinit var mLastURL : String

    private fun loadUrl(url: String){
        mWebView.loadUrl(url)
        mLastURL = url
    }

    fun loadBaseUrl(){
        loadUrl(BASE_URL)
    }

    fun loadOrdinances(){
        loadUrl(UrlGenerator.getOrdinances())
    }

    fun loadLaws(){
        loadUrl(UrlGenerator.getLaws())
    }

    fun loadDaily(){
        loadUrl(UrlGenerator.getDaily())
    }

    fun loadContracts(){
        loadUrl(UrlGenerator.getContracts())
    }

    fun refresh(){
        loadUrl(mLastURL)
    }
}