package com.jhoanes.example.websitedata.loaders

import android.webkit.WebView
import com.jhoanes.example.websitedata.utils.UrlGenerator
import com.jhoanes.example.websitedata.utils.WebEndsPoint.FULL_URL

class UrlLoader(webView: WebView) {
    private var mWebView : WebView = webView
    private lateinit var mLastURL : String

    private fun loadUrl(url: String){
        mWebView.loadUrl(url)
        mLastURL = url
    }

    fun loadBaseUrl(){
        loadUrl(FULL_URL)
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

    fun loadDecrees(){
        loadUrl(UrlGenerator.getDecrees())
    }

    fun loadBidding(){
        loadUrl(UrlGenerator.getBidding())
    }

    fun loadCounterCheck(){
        loadUrl(UrlGenerator.getCounterCheck())
    }

    fun loadTransparence(){
        loadUrl(UrlGenerator.getTransparency())
    }

    fun loadNFSE(){
        loadUrl(UrlGenerator.getNFSE())
    }

    fun loadDiary(){
        loadUrl(UrlGenerator.getDiary())
    }

    fun refresh(){
        loadUrl(mLastURL)
    }
}