package ru.gorshenev.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var numPicker: NumberPicker

    lateinit var button: Button

    lateinit var possibilitiesList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numPicker = findViewById(R.id.numPicker)

        possibilitiesList = arrayOf(
            "1.Buttons",
            "2.RecyclerView list",
            "3.Clickable list in 2 lang",
            "4.Playing sounds",
            "5.Saving Preferences",
            "6.Images(slider)",
            "7.Web Pages",
            "8.SMS"
        )

        numPicker.displayedValues = possibilitiesList
        numPicker.minValue = 0
        numPicker.maxValue = possibilitiesList.size - 1

        button = findViewById(R.id.btnOk)
        button.setOnClickListener { navigate() }

        findViewById<Button>(R.id.btnAbout).setOnClickListener {
            val url = "https://github.com/gorshmeister"
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply { startActivity(this) }
        }
    }

    private fun navigate() {

        when (numPicker.value) {
            0 -> {
                Intent(this, ButtonsActivity::class.java).apply {
                    putExtra("title", possibilitiesList[0])
                    startActivity(this)
                }
            }
            1 -> {
                Intent(this, ListActivity::class.java).apply {
                    putExtra("title", possibilitiesList[1])
                    startActivity(this)
                }
            }
            2 -> {
                Intent(this, ClickableListActivity::class.java).apply {
                    putExtra("title", possibilitiesList[2])
                    startActivity(this)
                }
            }
            3 -> {
                Intent(this, PlayingSoundActivity::class.java).apply {
                    putExtra("title", possibilitiesList[3])
                    startActivity(this)
                }
            }
            4 -> {
                Intent(this, SavingPreferencesActivity::class.java).apply {
                    putExtra("title", possibilitiesList[4])
                    startActivity(this)
                }
            }
            5 -> {
                Intent(this, ImagesActivity::class.java).apply {
                    putExtra("title", possibilitiesList[5])
                    startActivity(this)
                }
            }
            6 -> {
                Intent(this, WebPagesActivity::class.java).apply {
                    putExtra("title", possibilitiesList[6])
                    startActivity(this)
                }
            }
            7 -> {
                Intent(this, SmsActivity::class.java).apply {
                    putExtra("title", possibilitiesList[7])
                    startActivity(this)
                }
            }
        }
    }
}