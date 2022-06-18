package ru.gorshenev.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ButtonsActivity : AppCompatActivity() {
    lateinit var btnBlue: Button

    lateinit var btnPurple: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)
        title = intent.getStringExtra("title")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        btnBlue = findViewById(R.id.btnInvisible)
        btnPurple = findViewById(R.id.btnToast)

        btnBlue.setOnClickListener { action(btnBlue) }
        btnPurple.setOnClickListener { action(btnPurple) }
    }

    private fun action(view: View) {
        when (view) {
            btnBlue -> view.visibility = View.INVISIBLE
            btnPurple -> Toast.makeText(this, "Toast button text", Toast.LENGTH_SHORT).show()
        }

    }
}