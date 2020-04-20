package com.t5application.dm_classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "encounter_database")
class Encounter(@PrimaryKey val id: UUID = UUID.randomUUID(),
                var encName: String,
                var encCR: Int,
                var encMonsterNumber: Int,
                var encMonsters: String) {

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

    fun getMonsters(): String {
        return encMonsters;
    }

    fun printEncounter(){
        println("Name: $encName CR: $encCR Monster Number: $encMonsterNumber Monsters: $encMonsters")
    }

}