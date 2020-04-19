package com.t5application.database.townDB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.t5application.database.townDB.TownClassConverters
import com.t5application.database.townDB.TownDao
import com.t5application.dm_classes.Town

@Database(entities = [Town::class], version = 1, exportSchema = false)
@TypeConverters(TownClassConverters::class)
abstract class TownDatabase : RoomDatabase(){

    abstract fun townDao(): TownDao

}