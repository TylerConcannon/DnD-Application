package com.t5application.database.adventureDB

import androidx.room.*
import com.t5application.dm_classes.Adventure

@Database(entities = [Adventure::class], version = 1, exportSchema = false)
@TypeConverters(AdventureTypeConverters::class)
abstract class AdventureDatabase : RoomDatabase(){

    abstract fun adventureDao(): AdventureDao

}