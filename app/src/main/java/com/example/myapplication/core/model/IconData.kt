package com.example.myapplication.core.model

import com.example.myapplication.R

class IconData {

    private var data: ArrayList<Icon> = ArrayList()

    init {
        data.add(Icon(1, R.drawable.s_01, "Sunny"))
        data.add(Icon(2, R.drawable.s_02, "Mostly Sunny"))
        data.add(Icon(3, R.drawable.s_03, "Partly Sunny"))
        data.add(Icon(4, R.drawable.s_04, "Intermittent Clouds"))
        data.add(Icon(5, R.drawable.s_05, "Hazy Sunshine"))
        data.add(Icon(6, R.drawable.s_06, "Mostly Cloudy"))
        data.add(Icon(7, R.drawable.s_07, "Cloudy"))
        data.add(Icon(8, R.drawable.s_08, "Dreary (Overcast)"))
        data.add(Icon(11, R.drawable.s_11, "Fog"))
        data.add(Icon(12, R.drawable.s_12, "Showers"))
        data.add(Icon(13, R.drawable.s_13, "Mostly Cloudy and Showers"))
        data.add(Icon(14, R.drawable.s_14, "Partly Sunny and Showers"))
        data.add(Icon(15, R.drawable.s_15, "T-Storms"))
        data.add(Icon(16, R.drawable.s_16, "Mostly Cloudy and T-Storms"))
        data.add(Icon(17, R.drawable.s_17, "Partly Sunny and T-Storms"))
        data.add(Icon(18, R.drawable.s_18, "Rain"))
        data.add(Icon(19, R.drawable.s_19, "Flurries"))
        data.add(Icon(20, R.drawable.s_20, "Mostly Cloudy and Flurries"))
        data.add(Icon(21, R.drawable.s_21, "Partly Sunny and Flurries"))
        data.add(Icon(22, R.drawable.s_22, "Snow"))
        data.add(Icon(23, R.drawable.s_23, "Mostly Cloudy and Snow"))
        data.add(Icon(24, R.drawable.s_24, "Ice"))
        data.add(Icon(25, R.drawable.s_25, "Sleet"))
        data.add(Icon(26, R.drawable.s_26, "Freezing Rain"))
        data.add(Icon(29, R.drawable.s_29, "Rain and Snow"))
        data.add(Icon(30, R.drawable.s_30, "Hot"))
        data.add(Icon(31, R.drawable.s_31, "Cold"))
        data.add(Icon(32, R.drawable.s_32, "Windy"))
        data.add(Icon(33, R.drawable.s_33, "Clear"))
        data.add(Icon(34, R.drawable.s_34, "Mostly Clear"))
        data.add(Icon(35, R.drawable.s_35, "Partly Cloudy"))
        data.add(Icon(36, R.drawable.s_36, "Intermittent Clouds"))
        data.add(Icon(37, R.drawable.s_37, "Hazy Moonlight"))
        data.add(Icon(38, R.drawable.s_38, "Mostly Cloudy"))
        data.add(Icon(39, R.drawable.s_39, "Partly Cloudy and Showers"))
        data.add(Icon(40, R.drawable.s_40, "Mostly Cloudy and Showers"))
        data.add(Icon(41, R.drawable.s_41, "Partly Cloudy and T-Storms"))
        data.add(Icon(42, R.drawable.s_42, "Mostly Cloudy and T-Storms"))
        data.add(Icon(43, R.drawable.s_43, "Mostly Cloudy and Flurries"))
        data.add(Icon(44, R.drawable.s_44, "Mostly Cloudy and Snow"))

    }

    fun icon(id: Int): Icon = data.single { icon ->
        icon.id == id
    }
}