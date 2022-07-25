package dev.edwinperaza.weatherapp.screens.main

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.edwinperaza.weatherapp.data.DataOrException
import dev.edwinperaza.weatherapp.model.Weather
import dev.edwinperaza.weatherapp.widgets.WeatherAppBar

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    val weatherData =
        produceState<DataOrException<Weather, Boolean, Exception>>(
            initialValue = DataOrException(
                loading = true
            )
        ) {
            value = viewModel.getWeatherData("Seattle", "")
        }.value
    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        weatherData.data?.let {
            MainScaffold(weather = it, navController)
        }
    }


}

@Composable
fun MainScaffold(weather: Weather, navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(
            title = weather.city.name + ", ${weather.city.country}",
            isMainScreen = true,
            elevation = 5.dp,
            navController = navController
        ) {
           Log.d("MainScaffold", "Button Clicked")
        }
    }) {
        MainContent(data = weather)
    }
}

@Composable
fun MainContent(data: Weather) {
    Text(text = "Value = ${data.city.name}")
}