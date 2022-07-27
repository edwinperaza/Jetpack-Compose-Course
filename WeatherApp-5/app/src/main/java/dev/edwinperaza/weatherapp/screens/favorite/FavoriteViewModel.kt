package dev.edwinperaza.weatherapp.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.edwinperaza.weatherapp.model.Favorite
import dev.edwinperaza.weatherapp.repository.WeatherDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: WeatherDBRepository
) : ViewModel() {
    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFavorites().distinctUntilChanged().collect { listOfFavorites ->
                if (listOfFavorites.isEmpty()) {
                    Log.d("FavoriteViewModel", "Empty favorites")
                } else {
                    _favList.value = listOfFavorites
                    Log.d("FavoriteViewModel", "${favList.value}")
                }
            }
        }
    }

    fun insertFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.insertFavorite(favorite) }

    fun updateFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.updateFavorite(favorite) }

    fun deleteFavorite(favorite: Favorite) =
        viewModelScope.launch { repository.deleteFavorite(favorite) }

}