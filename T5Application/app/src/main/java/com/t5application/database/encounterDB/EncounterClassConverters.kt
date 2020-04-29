package com.t5application.database.encounterDB

import androidx.room.TypeConverter
import java.util.*

class EncounterClassConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID?{
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String?{
        return uuid?.toString()
    }

    @TypeConverter
    fun fromString(string: String): List<String> {
        return string.split("::").map { it }
    }

    @TypeConverter
    fun fromList(list: List<String>): String{
        return list.joinToString(separator = "::")
    }

}