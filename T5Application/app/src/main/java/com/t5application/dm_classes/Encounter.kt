package com.t5application.dm_classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "encounter_database")
class Encounter(@PrimaryKey val id: UUID = UUID.randomUUID(),
                var encName: String = "ENCOUNTER",
                var encCR: Int = -1,
                var encMonsterNumber: Int = -1,
                var encMonsters: List<String> = listOf(),
                var monsterWeapons: List<String> = listOf(),
                var encTerrain: String = "DEFAULT") {

    fun getID(): UUID{
        return id;
    }

    fun getName(): String {
        return encName;
    }

    fun getCR(): Int {
        return encCR;
    }

    fun getMonsterNumber(): Int {
        return encMonsterNumber;
    }

    fun getMonsters(): List<String> {
        return encMonsters;
    }

    fun printEncounter(){
        println("Name: $encName CR: $encCR Monster Number: $encMonsterNumber")
    }

}