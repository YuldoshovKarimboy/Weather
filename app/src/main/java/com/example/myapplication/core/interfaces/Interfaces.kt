package com.example.myapplication.core.interfaces

import androidx.fragment.app.Fragment
import com.example.myapplication.core.model.AutoCompleteSearch

interface AddPlaceListener {

    fun addPlace(fragment: Fragment)
}

interface OnPlaceListener{

    fun click(item: AutoCompleteSearch.AutoCompleteSearchItem)

}