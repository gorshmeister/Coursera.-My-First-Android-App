package ru.gorshenev.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalsAdapter : RecyclerView.Adapter<AnimalsAdapter.ViewHolder>() {

    private var items: List<Animals> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Animals>) {
        items = newItems
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvName: TextView = view.findViewById(R.id.tvName)

        private val image: ImageView = view.findViewById(R.id.imageView)

        fun bind(item: Animals) {
            item.let {
                tvName.text = it.name
                image.setImageResource(it.image)
            }
        }
    }
}