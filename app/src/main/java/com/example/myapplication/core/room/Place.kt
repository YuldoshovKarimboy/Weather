package com.example.myapplication.core.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class Place(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "key") var key: String,
    @ColumnInfo(name = "country") var country: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
