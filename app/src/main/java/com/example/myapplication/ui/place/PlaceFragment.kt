package com.example.myapplication.ui.place

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.core.adapter.PlaceListAdapter
import com.example.myapplication.core.interfaces.OnPlaceListener
import com.example.myapplication.core.model.AutoCompleteSearch
import com.example.myapplication.core.model.FiveDailyForecast
import com.example.myapplication.core.model.IconData
import com.example.myapplication.core.room.Place
import com.example.myapplication.databinding.PlaceFragmentBinding

class PlaceFragment(var location: Place? = null) : Fragment(), OnPlaceListener {

    private lateinit var binding: PlaceFragmentBinding
    private var adapter = PlaceListAdapter(this)
    private lateinit var place: AutoCompleteSearch.AutoCompleteSearchItem
    private lateinit var query: String

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: PlaceViewModel by viewModels()

        if (location != null) {
            changePage()
            viewModel.sendRequestFiveDailyForecast(location!!.key)
        }

        binding.apply {

            placeModel = viewModel

            checkPlace.setOnClickListener {
                when (viewModel.isSelect.value) {
                    true -> {
//                        Toast.makeText(requireContext(), place.localizedName, Toast.LENGTH_SHORT)
//                            .show()

                        viewModel.insertPlace(place)
                        viewModel.sendRequestFiveDailyForecast(place.key)
                    }
                    else -> {
                        if (query.isNotEmpty()) {
                            viewModel.sendRequestAutoSearch(query)
                        }
                    }
                }

            }

            placeList.adapter = adapter

            inputPlace.addTextChangedListener { newText ->
                query = newText.toString().trim()
                if (newText.toString().isEmpty()) {
                    viewModel.isSelect.value = false
                    adapter.clearData()
                }
            }
        }

        viewModel.responseAutoSearch.observe(viewLifecycleOwner, { data ->
            adapter.uploadData(data)
        })

        viewModel.responseFiveDailyForecast.observe(viewLifecycleOwner, { fiveDailyForecast ->
            changePage()
            createPlacePage(fiveDailyForecast)
        })

        viewModel.isSelect.observe(viewLifecycleOwner, { select ->
            if (select) {
                binding.checkPlace.text = "Create page"
            } else {
                binding.checkPlace.text = "Check place"
            }
        })

        viewModel.responseFailure.observe(viewLifecycleOwner, { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.place_fragment, container, false)
        return binding.root
    }

    override fun click(item: AutoCompleteSearch.AutoCompleteSearchItem) {
        binding.placeModel!!.isSelect.value = true
        place = item
    }

    private fun changePage() {
        binding.apply {
            addPage.visibility = View.GONE
            placePage.visibility = View.VISIBLE
        }
    }

    @SuppressLint("SetTextI18n")
    private fun createPlacePage(forecast: FiveDailyForecast) {
        binding.dailyInfo.text = forecast.headline.text
        binding.temperature.text =
            "${forecast.dailyForecasts[0].temperature.maximum.value} ${forecast.dailyForecasts[0].temperature.maximum.unit}/${forecast.dailyForecasts[0].temperature.minimum.value} ${forecast.dailyForecasts[0].temperature.minimum.unit}"
        val dayIcon = IconData().icon(forecast.dailyForecasts[0].day.icon)
        binding.dayIcon.setImageResource(dayIcon.icon)
        binding.dayInfo.text = dayIcon.text
        val nightIcon = IconData().icon(forecast.dailyForecasts[0].night.icon)
        binding.nightIcon.setImageResource(nightIcon.icon)
        binding.nightInfo.text = nightIcon.text
    }
}