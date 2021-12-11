package com.example.myapplication.core.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.MainActivity

class PlacePageAdapter(mainActivity: MainActivity) :
    FragmentStateAdapter(mainActivity) {

    private var data = ArrayList<Fragment>()

    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment = data[position]

    @SuppressLint("NotifyDataSetChanged")
    fun data(data: ArrayList<Fragment>) {
        this.data = data
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPlace(fragment: Fragment) {
        data.add(fragment)
        notifyDataSetChanged()
    }
}