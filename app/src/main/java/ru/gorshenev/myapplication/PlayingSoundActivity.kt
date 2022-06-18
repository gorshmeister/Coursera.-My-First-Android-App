package ru.gorshenev.myapplication

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class PlayingSoundActivity : AppCompatActivity() {
    lateinit var pianoMusic: MediaPlayer

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing_sound)

        title = intent.getStringExtra("title")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        pianoMusic = MediaPlayer.create(this, R.raw.piano)

        findViewById<Button>(R.id.btnPlay).setOnClickListener { play() }
        findViewById<Button>(R.id.btnPause).setOnClickListener { pause() }

        val looping = findViewById<Switch>(R.id.sLooping)
        looping.setOnCheckedChangeListener { buttonView, isChecked ->
            pianoMusic.isLooping = isChecked
        }
    }

    private fun play() {
        pianoMusic.start()
    }

    private fun pause() {
        if (pianoMusic.isPlaying)
            pianoMusic.pause()
    }
}