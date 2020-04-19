package com.t5application.database.npcDB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.t5application.dm_classes.NPC

@Database(entities = [NPC::class], version = 1, exportSchema = false)
@TypeConverters(NPCClassConverters::class)
abstract class NPCDatabase : RoomDatabase(){

    abstract fun npcDao(): NPCDao

}