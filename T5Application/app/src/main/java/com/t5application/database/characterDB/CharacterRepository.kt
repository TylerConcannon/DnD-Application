package com.t5application.database.characterDB

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.t5application.character_classes.Character
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "character_database"

class CharacterRepository private constructor(context: Context){

    private val database: CharacterDatabase = Room.databaseBuilder(
        context.applicationContext,
        CharacterDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val characterDao = database.characterDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getCharacters(): LiveData<List<Character>> = characterDao.getAllCharacters()
    fun getCharacter(id: UUID): LiveData<Character> = characterDao.getCharacterById(id)

    fun deleteCharacter(character: Character){
        executor.execute {
            characterDao.deleteCharacter(character)
        }
    }

    fun updateCharacter(character: Character){
        executor.execute {
            characterDao.updateCharacter(character)
        }
    }

    fun addCharacter(character: Character){
        executor.execute {
            characterDao.insertCharacter(character)
        }
    }

    companion object{
        private var INSTANCE: CharacterRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = CharacterRepository(context)
            }
        }

        fun get(): CharacterRepository{
            return INSTANCE ?: throw IllegalStateException("Character Database not initialized")
        }

    }

}

