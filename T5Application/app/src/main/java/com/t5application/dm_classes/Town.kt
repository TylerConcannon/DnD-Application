package com.t5application.dm_classes

class Town(var townName: String, var townSize: String, var townTerrain: String, var townBuildings: MutableList<String>, var townPolitics: String) {

    fun getName(): String {
        return townName;
    }

    fun getSize(): String {
        return townSize;
    }

    fun getTerrain(): String {
        return townTerrain;
    }

    fun getBuildings(): MutableList<String> {
        return townBuildings;
    }

    fun getPolitics(): String {
        return townPolitics;
    }
}