package com.t5application.database.npcDB

import androidx.room.TypeConverter
import java.util.*

class NPCClassConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID?{
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String?{
        return uuid?.toString()
    }

}