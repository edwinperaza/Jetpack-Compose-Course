package dev.edwinperaza.weatherapp.repository

import dev.edwinperaza.weatherapp.data.DataOrException
import dev.edwinperaza.weatherapp.model.Weather
import dev.edwinperaza.weatherapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {
    suspend fun getWeather(
        cityQuery: String,
        units: String = ""
    ): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery, units = units)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }


}