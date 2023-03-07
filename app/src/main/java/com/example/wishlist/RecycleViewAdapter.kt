package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapter(private val data: MutableList<WishlishtData>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_display : TextView
        val price_display : TextView
        val link_display : TextView

        init {
            item_display = itemView.findViewById(R.id.tv_item_display)
            price_display = itemView.findViewById(R.id.tv_price_display)
            link_display = itemView.findViewById(R.id.tv_link_display)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_layout,parent,false)
        return ViewHolder(contactView)
    }

    public fun addToList(newData : WishlishtData) {
        data.add(newData)
        notifyItemInserted(data.size-1)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = data.get(position)
        holder.item_display.text = list.item
        holder.price_display.text = list.price
        holder.link_display.text = list.link
    }

    override fun getItemCount(): Int {
        return data.size
    }


}