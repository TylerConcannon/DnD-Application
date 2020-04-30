package com.t5application.database.adventureDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.t5application.dm_classes.Adventure

@Database(entities = [Adventure::class], version = 1, exportSchema = false)
//Type converters if needed
abstract class AdventureDatabase : RoomDatabase(){

    abstract fun adventureDao(): AdventureDao

}