package com.t5application.database.adventureDB

import androidx.room.TypeConverter
import java.util.*

class AdventureTypeConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID?{
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String?{
        return uuid?.toString()
    }

    @TypeConverter
    fun fromString(string: String): List<String> { //AKA toList
        return string.split("::").map { it }
    }

    @TypeConverter
    fun fromList(list: List<String>): String{ //AKA toString
        return list.joinToString(separator = "::")
    }

}