package com.chewy.hybridweb

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.chewy.hybridweb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.webView.settings.apply {
            javaScriptEnabled = true
        }

        binding.webView.apply {
           webViewClient= WebViewClient()
           loadUrl(HTML_URL)
           addJavascriptInterface(ChewyCartJavaScriptInterface(this@MainActivity), "androidWebNativeBridge")
        }




        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                // Implement your progress bar handling here
            }
        }

        binding.buttonWebcodeFromNativeCode.setOnClickListener{
            val msgFromNative = "Hello from Native Android! to web-code"
            binding.webView.evaluateJavascript("javascript:callWebCodeFunctionFromNativeCode('$msgFromNative');", null)

        }
    }

    companion object {
        const val HTML_URL="file:///android_asset/chewy-cart.html"
    }



}