package dev.edwinperaza.weatherapp.repository

import dev.edwinperaza.weatherapp.data.UnitDao
import dev.edwinperaza.weatherapp.data.WeatherDao
import dev.edwinperaza.weatherapp.model.Favorite
import dev.edwinperaza.weatherapp.model.Unit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnitDBRepository @Inject constructor(
    private val unitDao: UnitDao
) {

    fun getUnits(): Flow<List<Unit>> = unitDao.getUnits()

    suspend fun insertUnit(unit: Unit) = unitDao.insertUnit(unit)

    suspend fun updateUnit(unit: Unit) = unitDao.updateUnit(unit)

    suspend fun deleteAllUnits() = unitDao.deleteAllUnits()

    suspend fun deleteUnit(unit: Unit) = unitDao.deleteUnit(unit)

    suspend fun getUnitById(unit: String) = unitDao.getUnitById(unit)
}