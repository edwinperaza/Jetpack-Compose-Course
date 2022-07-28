package dev.edwinperaza.weatherapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "settings_tbl")
data class Unit(
    @NotNull
    @PrimaryKey
    @ColumnInfo
    val unit: String
)
