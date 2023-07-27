package com.chewy.hybridweb

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class ChewyCartJavaScriptInterface(private var context: Context) {

    @JavascriptInterface
    fun showNativeToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    // Add other methods as needed
}