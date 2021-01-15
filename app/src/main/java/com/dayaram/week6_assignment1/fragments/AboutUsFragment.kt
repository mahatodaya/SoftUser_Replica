package com.dayaram.week6_assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.dayaram.week6_assignment1.R

class AboutUsFragment : Fragment() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)
        webView = view.findViewById(R.id.webView)

        // Load website url with enabling javascript
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://softwarica.edu.np/")

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        return view
    }
}