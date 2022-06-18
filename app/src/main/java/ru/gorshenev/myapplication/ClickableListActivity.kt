package ru.gorshenev.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ClickableListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clickable_list)

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        title = intent.getStringExtra("title")

        val lvAnimals = findViewById<ListView>(R.id.lvItems)
        val adapterAnimals = ArrayAdapter.createFromResource(
            this, R.array.animals, android.R.layout.simple_list_item_1
        )
        lvAnimals.adapter = adapterAnimals

        lvAnimals.setOnItemClickListener { _, _, position, _ ->
            val message = "${getString(R.string.choise)} ${adapterAnimals.getItem(position)}"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }


    }
}