package dev.edwinperaza.weatherapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.edwinperaza.weatherapp.model.Favorite
import dev.edwinperaza.weatherapp.model.Unit

@Database(entities = [Favorite::class, Unit::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    abstract fun unitDao(): UnitDao
}