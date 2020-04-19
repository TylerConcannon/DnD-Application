package com.t5application.database.townDB

import androidx.room.TypeConverter
import java.util.*

class TownClassConverters {

    @TypeConverter
    fun toUUID(uuid: String?):UUID?{
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String?{
        return uuid?.toString()
    }

}