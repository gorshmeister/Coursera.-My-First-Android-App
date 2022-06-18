package ru.gorshenev.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SmsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
        title = intent.getStringExtra("title")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<Button>(R.id.btnSend).setOnClickListener { send() }
    }

    private fun send() {
        val message = findViewById<EditText>(R.id.etMessage).text.toString()

        val destination = Uri.parse("smsto:(555)521-5554")

        val smsIntent = Intent(Intent.ACTION_SENDTO, destination)
        smsIntent.putExtra("sms_body", message)
        startActivity(smsIntent)
    }
}