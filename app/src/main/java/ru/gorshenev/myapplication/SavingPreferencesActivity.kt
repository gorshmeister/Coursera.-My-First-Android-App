package ru.gorshenev.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SavingPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saving_preferences)

        title = intent.getStringExtra("title")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        val preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()

        val layout = findViewById<ConstraintLayout>(R.id.layout)

        if (preferences.contains("color"))
            layout.setBackgroundColor(preferences.getInt("color", 0))

        val rgColors = findViewById<RadioGroup>(R.id.radioGroup)
        rgColors.setOnCheckedChangeListener { group, checkedId ->
            var colorCode = 0
            when (checkedId) {
                R.id.rbBlue -> colorCode = Color.BLUE
                R.id.rbYellow -> colorCode = Color.YELLOW
                R.id.rbMagenta -> colorCode = Color.MAGENTA
            }
            layout.setBackgroundColor(colorCode)
            editor.putInt("color", colorCode)
            editor.commit()
        }


    }
}