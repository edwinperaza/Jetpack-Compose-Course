package dev.edwinperaza.weatherapp.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.edwinperaza.weatherapp.data.DataOrException
import dev.edwinperaza.weatherapp.model.Weather
import dev.edwinperaza.weatherapp.repository.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    val data: MutableState<DataOrException<Weather, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    suspend fun getWeatherData(
        city: String,
        units: String
    ): DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(cityQuery = city, units = units)
    }
}