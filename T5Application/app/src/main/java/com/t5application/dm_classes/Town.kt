package com.t5application.dm_classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "town_database")
data class Town(@PrimaryKey val id: Int = 0,
                var townName: String = "NAME",
                var townSize: String = "SIZE",
                var townTerrain: String = "TERRAIN",
                var townBuildings: String = "BUILDINGS",
                var townPolitics: String = "POLITICS"){

    fun getID(): Int{
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