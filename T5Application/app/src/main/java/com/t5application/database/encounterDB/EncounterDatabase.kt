package com.t5application.database.encounterDB

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.t5application.dm_classes.Encounter

@Database(entities = [Encounter::class], version = 1, exportSchema = false)
@TypeConverters(EncounterClassConverters::class)
abstract class EncounterDatabase : RoomDatabase(){

    abstract fun encounterDao(): EncounterDao

}