package com.example.diffutil

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter:RecyclerView.Adapter<adapter.noteViewHolder>() {

    private var noteItem =listOf<mynote>()

    inner class noteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val id: TextView = itemView.findViewById(R.id.id)
        val text:TextView  = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {
        val viewholder = noteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
        return viewholder
    }
    override fun getItemCount(): Int {
        return noteItem.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateitem(newList:List<mynote>){
        //noteItem.clear()
        //noteItem.addAll(newList)
        noteItem = newList
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
        val currentItem = noteItem[position]
        holder.id.text = currentItem.id.toString()
        holder.text.text = currentItem.text
    }
}