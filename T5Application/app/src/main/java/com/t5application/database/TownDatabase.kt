package com.t5application.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.t5application.dm_classes.Town

@Database(entities = [Town::class], version = 1, exportSchema = false)
abstract class TownDatabase : RoomDatabase(){

    abstract fun townDao():TownDao

}