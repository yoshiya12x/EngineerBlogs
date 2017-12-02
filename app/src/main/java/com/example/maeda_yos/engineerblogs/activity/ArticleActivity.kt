package com.example.maeda_yos.engineerblogs.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.maeda_yos.engineerblogs.R
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        setSupportActionBar(toolbar)

        val url = intent.getStringExtra("url")

        val webView = findViewById<WebView>(R.id.web_view_article)
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
        webView.settings.javaScriptEnabled = true
    }
}
