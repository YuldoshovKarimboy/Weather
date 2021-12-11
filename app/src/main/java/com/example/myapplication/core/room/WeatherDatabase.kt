package com.example.myapplication.core.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Place::class], version = 1, exportSchema = false)
public abstract class WeatherDatabase : RoomDatabase() {

    abstract fun dao(): WeatherDao

    companion object {

        private var instance: WeatherDatabase? = null

        fun instance(context: Context): WeatherDatabase = Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java,
            "weather.db"
        ).allowMainThreadQueries().build()
    }
}