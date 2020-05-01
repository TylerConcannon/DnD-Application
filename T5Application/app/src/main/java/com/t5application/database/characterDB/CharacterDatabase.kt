package com.t5application.database.characterDB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.t5application.character_classes.Character

@Database(entities = [Character::class], version = 1, exportSchema = false)
@TypeConverters(CharacterTypeConverters::class)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

}