package dev.edwinperaza.weatherapp.data

import androidx.room.*
import dev.edwinperaza.weatherapp.model.Unit
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitDao {

    @Query("Select * from settings_tbl")
    fun getUnits(): Flow<List<Unit>>

    @Query("Select * from settings_tbl where unit =:unit")
    suspend fun getUnitById(unit: String): Unit

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnit(unit: Unit)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUnit(unit: Unit)

    @Query("Delete from settings_tbl")
    suspend fun deleteAllUnits()

    @Delete
    suspend fun deleteUnit(unit: Unit)
}