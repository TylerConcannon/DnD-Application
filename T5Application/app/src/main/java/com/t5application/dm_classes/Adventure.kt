package com.t5application.dm_classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "adventure_database")
class Adventure (@PrimaryKey val id: UUID = UUID.randomUUID(),
                 var length: String = "Short",
                 var questType: String = "Fetch") {

    lateinit var encounterNames: List<String>
    lateinit var encounterWeapons: List<String>
    lateinit var townNames: List<String>
}