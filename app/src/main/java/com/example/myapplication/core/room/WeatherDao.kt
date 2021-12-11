package com.example.myapplication.core.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {

    @Query("select * from places order by name asc")
    fun allPlaces(): List<Place>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPlace(place: Place)
}