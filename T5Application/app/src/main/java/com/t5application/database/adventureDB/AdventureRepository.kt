package com.t5application.database.adventureDB

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.t5application.dm_classes.Adventure
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "adventure_database"

class AdventureRepository private constructor(context: Context){

    private val database: AdventureDatabase = Room.databaseBuilder(
        context.applicationContext,
        AdventureDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val adventureDao = database.adventureDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getAdventures(): LiveData<List<Adventure>> = adventureDao.getAllAdventures()

    fun getAdventure(id: UUID): LiveData<Adventure> = adventureDao.getAdventureById(id)

    fun deleteAdventure(adventure: Adventure){
        executor.execute {
            adventureDao.deleteAdventure(adventure)
        }
    }

    fun updateAdventure(adventure: Adventure){
        executor.execute {
            adventureDao.updateAdventure(adventure)
        }
    }

    fun addAdventure(adventure: Adventure){
        executor.execute {
            adventureDao.insertAdventure(adventure)
        }
    }

    companion object{
        private var INSTANCE: AdventureRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = AdventureRepository(context)
            }
        }

        fun get(): AdventureRepository {
            return INSTANCE ?: throw IllegalStateException("Adventure Database must be initialized")
        }

    }

}