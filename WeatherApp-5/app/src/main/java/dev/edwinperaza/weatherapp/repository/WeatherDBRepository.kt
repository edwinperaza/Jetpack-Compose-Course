package dev.edwinperaza.weatherapp.repository

import dev.edwinperaza.weatherapp.data.WeatherDao
import dev.edwinperaza.weatherapp.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDBRepository @Inject constructor(
    private val weatherDao: WeatherDao
) {

    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavorites()

    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)

    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavorite(favorite)

    suspend fun deleteAllFavorites() = weatherDao.deleteAllFavorites()

    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavorite(favorite)

    suspend fun getFavById(city: String) = weatherDao.getFavById(city)
}