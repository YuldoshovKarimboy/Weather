package com.example.myapplication.ui.place

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.core.api_key
import com.example.myapplication.core.model.AutoCompleteSearch
import com.example.myapplication.core.model.FiveDailyForecast
import com.example.myapplication.core.network.WeatherRetrofit
import com.example.myapplication.core.room.Place
import com.example.myapplication.core.room.WeatherDao
import com.example.myapplication.core.room.WeatherDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceViewModel(mApplication: Application) : AndroidViewModel(mApplication) {

    private val api = WeatherRetrofit().api()

    var responseAutoSearch = MutableLiveData<AutoCompleteSearch>()
    var responseFiveDailyForecast = MutableLiveData<FiveDailyForecast>()
    var responseFailure = MutableLiveData<String>()
    var isSelect = MutableLiveData<Boolean>()
    var dao: WeatherDao = WeatherDatabase.instance(mApplication.applicationContext).dao()

    init {
        isSelect.value = false
    }

    fun sendRequestAutoSearch(query: String) {
        api.autocompleteSearch(api_key, query).enqueue(object : Callback<AutoCompleteSearch> {
            override fun onResponse(
                call: Call<AutoCompleteSearch>,
                response: Response<AutoCompleteSearch>
            ) {
                if (response.isSuccessful) {
                    responseAutoSearch.value = response.body()
                }
            }

            override fun onFailure(call: Call<AutoCompleteSearch>, t: Throwable) {
                responseFailure.value = t.localizedMessage
            }

        })
    }

    fun insertPlace(item: AutoCompleteSearch.AutoCompleteSearchItem) {
        val place = Place(item.localizedName, item.key, item.country.localizedName)
        dao.insertPlace(place)
    }

    fun sendRequestFiveDailyForecast(locationKey: String) {
        api.fiveDayForecast(locationKey, api_key).enqueue(object : Callback<FiveDailyForecast> {
            override fun onResponse(
                call: Call<FiveDailyForecast>,
                response: Response<FiveDailyForecast>
            ) {
                if (response.isSuccessful) {
                    responseFiveDailyForecast.value = response.body()
                }
            }

            override fun onFailure(call: Call<FiveDailyForecast>, t: Throwable) {
                responseFailure.value = t.localizedMessage
            }
        })
    }

    fun convertRoomModel(item: AutoCompleteSearch.AutoCompleteSearchItem): Place =
        Place(item.localizedName, item.key, item.country.localizedName)

}