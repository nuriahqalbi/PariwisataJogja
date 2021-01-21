package com.latihan.pariwisata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_portal_wisata.*

class PortalWisata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal_wisata)

        webview.settings.javaScriptEnabled = true
        webview.settings.saveFormData = true

        webview.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
//                if (newProgress == 100){
//                    pb.visibility = View.GONE
//                }
                Toast.makeText(applicationContext, "Halaman berhasil di muat", Toast.LENGTH_SHORT).show()
            }
        }

        webview.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress == 100){
                    pb.visibility = View.GONE
                }
            }
        }

        webview.loadUrl("https://id.wikipedia.org/wiki/Daerah_Istimewa_Yogyakarta")

    }
}