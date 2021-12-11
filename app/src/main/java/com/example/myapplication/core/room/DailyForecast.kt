package com.example.myapplication.core.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_forecast")
data class DailyForecast(
    @ColumnInfo(name = "last_date") var lastDate: String,
    @ColumnInfo(name = "key") var key: Int,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "link") var link: String,
    @ColumnInfo(name = "unit") var unit: String,
    @ColumnInfo(name = "min_temp") var minimumTemperature: String,
    @ColumnInfo(name = "max_temp") var maximumTemperature: String,
    @ColumnInfo(name = "day_icon") var dayIcon: Int,
    @ColumnInfo(name = "day_type") var dayType: String,
    @ColumnInfo(name = "day_intensity") var dayIntensity: String,
    @ColumnInfo(name = "night_icon") var nightIcon: Int,
    @ColumnInfo(name = "night_type") var nightType: String,
    @ColumnInfo(name = "night_intensity") var nightIntensity: String

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id = 0
}
