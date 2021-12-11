package com.example.myapplication.core.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.core.interfaces.OnPlaceListener
import com.example.myapplication.core.model.AutoCompleteSearch
import com.google.android.material.textview.MaterialTextView

class PlaceListAdapter(var listener: OnPlaceListener) :
    RecyclerView.Adapter<PlaceListAdapter.Holder>() {

    private var data = AutoCompleteSearch()
    private var lastIndex = -1

    @SuppressLint("NotifyDataSetChanged")
    fun uploadData(data: AutoCompleteSearch) {
        this.data = data
        notifyDataSetChanged()
    }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    inner class Holder(var view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(item: AutoCompleteSearch.AutoCompleteSearchItem) {

            view.findViewById<MaterialTextView>(R.id.name).text = item.localizedName
            view.findViewById<ImageView>(R.id.img).visibility = View.GONE

            view.setOnClickListener {
                if (lastIndex != -1) {
                    notifyItemChanged(lastIndex)
                }
                lastIndex = adapterPosition
                view.findViewById<ImageView>(R.id.img).visibility = View.VISIBLE
                listener.click(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_place, parent, false
        )
    )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}