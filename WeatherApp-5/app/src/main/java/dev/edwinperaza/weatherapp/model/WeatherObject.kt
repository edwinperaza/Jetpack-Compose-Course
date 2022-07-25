package dev.edwinperaza.weatherapp.model

data class WeatherObject(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)