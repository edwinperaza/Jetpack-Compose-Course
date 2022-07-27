package dev.edwinperaza.weatherapp.data

import androidx.room.*
import dev.edwinperaza.weatherapp.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("Select * from fav_tbl")
    fun getFavorites(): Flow<List<Favorite>>

    @Query("Select * from fav_tbl where city =:city")
    suspend fun getFavById(city: String): Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favorite: Favorite)

    @Query("Delete from fav_tbl")
    suspend fun deleteAllFavorites()

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}