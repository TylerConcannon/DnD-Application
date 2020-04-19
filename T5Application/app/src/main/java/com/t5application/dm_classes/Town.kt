package com.t5application.dm_classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "town_database")
data class Town(@PrimaryKey val id: UUID = UUID.randomUUID(),
                var townName: String = "TOWN_NAME",
                var townSize: String = "TOWN_SIZE",
                var townTerrain: String = "TOWN_TERRAIN",
                var townBuildings: String = "TOWN_BUILDINGS",
                var townPolitics: String = "TOWN_POLITICS"){

    fun getID(): UUID{
        return id;
    }

    fun getName(): String {
        return townName;
    }

    fun getSize(): String {
        return townSize;
    }

    fun getTerrain(): String {
        return townTerrain;
    }

    fun getBuildings(): String {
        return townBuildings;
    }

    fun getPolitics(): String {
        return townPolitics;
    }

    fun printTown(){
        println("Name: $townName Size: $townSize Terrain: $townTerrain Buildings: $townBuildings Politics: $townPolitics")
    }
}