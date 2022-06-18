package ru.gorshenev.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    private val animalsAdapter: AnimalsAdapter = AnimalsAdapter()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = intent.getStringExtra("title")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }

        animalsAdapter.updateItems(setInitialData())

        recyclerView = findViewById<RecyclerView>(R.id.rvItems).apply {
            adapter = animalsAdapter
            addItemDecoration(DividerItemDecoration(context,
                (layoutManager as LinearLayoutManager).orientation))
        }

    }

    private fun setInitialData(): List<Animals> {
        return listOf<Animals>(
            Animals("cat", R.drawable.catcat_ccexpress),
            Animals("cow", R.drawable.cow_ccexpress),
            Animals("dog", R.drawable.dog_ccexpress),
            Animals("duck", R.drawable.duck_ccexpress),
            Animals("sheep", R.drawable.sheep_ccexpress),
        )
    }
}