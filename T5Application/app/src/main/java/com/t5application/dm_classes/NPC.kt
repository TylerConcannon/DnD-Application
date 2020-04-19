package com.t5application.dm_classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "npc_database")
class NPC(@PrimaryKey val id: UUID = UUID.randomUUID(),
          var npcName: String = "NPC_NAME",
          var npcRace: String = "NPC_RACE",
          var npcOccupation: String = "NPC_OCCUPATION") {

    fun getID(): UUID{
        return id
    }

    fun getName(): String {
        return npcName
    }

    fun getRace(): String {
        return npcRace
    }

    fun getOccupation(): String {
        return npcOccupation
    }

    fun printNPC(){
        println("Name: $npcName Race: $npcRace Occupation: $npcOccupation ID: ${id.toString()}")
    }
}