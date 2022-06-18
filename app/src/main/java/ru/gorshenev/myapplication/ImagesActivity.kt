package ru.gorshenev.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        title = intent.getStringExtra("title")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        val ivBig = findViewById<ImageView>(R.id.ivBig)
            .apply { setImageResource(R.drawable.sheep_ccexpress) }

        val tuner = findViewById<SeekBar>(R.id.seekBar)
        tuner.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var lastProgress = 0
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                lastProgress = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                ivBig.setColorFilter(Color.argb(255, 0, lastProgress, 255 - lastProgress))
            }

        })
    }
}