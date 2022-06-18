package ru.gorshenev.myapplication

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WebPagesActivity : AppCompatActivity() {
    private lateinit var possibilities: NumberPicker
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_pages)
        title = intent.getStringExtra("title")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        possibilities = findViewById(R.id.npWeb)
        possibilities.displayedValues = arrayOf(
            "Android",
            "Supélec",
            "Coursera"
        )
        possibilities.minValue = 0
        possibilities.maxValue = possibilities.displayedValues.size - 1

        webView = findViewById(R.id.webView)
        findViewById<Button>(R.id.btnOk).setOnClickListener { navigate() }
    }

    private fun navigate() {
        when (possibilities.value) {
            0 -> webView.loadUrl("file:///android_asset/andr.html")
            1 -> webView.loadUrl("file:///android_asset/sup.html")
            2 -> webView.loadUrl("https://www.coursera.org")
        }
    }
}