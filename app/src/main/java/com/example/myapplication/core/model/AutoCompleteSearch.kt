package com.example.myapplication.core.model

import com.google.gson.annotations.SerializedName

class AutoCompleteSearch : ArrayList<AutoCompleteSearch.AutoCompleteSearchItem>() {
    data class AutoCompleteSearchItem(
        @SerializedName("Version")
        val version: Int, // 1
        @SerializedName("Key")
        val key: String, // 66400
        @SerializedName("Type")
        val type: String, // City
        @SerializedName("Rank")
        val rank: Int, // 55
        @SerializedName("LocalizedName")
        val localizedName: String, // Tashi Town
        @SerializedName("Country")
        val country: Country,
        @SerializedName("AdministrativeArea")
        val administrativeArea: AdministrativeArea
    ) {
        data class Country(
            @SerializedName("ID")
            val iD: String, // CN
            @SerializedName("LocalizedName")
            val localizedName: String // China
        )

        data class AdministrativeArea(
            @SerializedName("ID")
            val iD: String, // ZJ
            @SerializedName("LocalizedName")
            val localizedName: String // Zhejiang
        )
    }
}