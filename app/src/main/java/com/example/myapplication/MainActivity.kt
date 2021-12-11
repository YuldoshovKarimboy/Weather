package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.core.adapter.PlacePageAdapter
import com.example.myapplication.core.interfaces.AddPlaceListener
import com.example.myapplication.core.room.Place
import com.example.myapplication.core.room.WeatherDao
import com.example.myapplication.core.room.WeatherDatabase
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.home.HomeFragment
import com.example.myapplication.ui.place.PlaceFragment

class MainActivity : AppCompatActivity(), AddPlaceListener {

    private lateinit var binding: ActivityMainBinding
    private var adapter = PlacePageAdapter(this)
    private var pageData = ArrayList<Fragment>()
    private lateinit var dao :WeatherDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dao = WeatherDatabase.instance(this).dao()

        initData()

        binding.apply {
            viewPager.adapter = adapter
        }

    }

    private fun initData() {
        donePlaceData()
        adapter.data(pageData)
    }

    override fun addPlace(fragment: Fragment) {
        adapter.addPlace(fragment)
        binding.viewPager.currentItem = adapter.itemCount - 1
    }

    private fun donePlaceData() {
        val db = readDB()
        pageData.add(HomeFragment(this))

        for (element in db) {
            pageData.add(PlaceFragment(element))
        }
    }

    private fun readDB(): List<Place> = dao.allPlaces()
}