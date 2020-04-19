package com.t5application.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.t5application.dm_classes.Town
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors


private const val DATABASE_NAME = "town_database"

class TownRepository private constructor(context: Context) {

    private val database: TownDatabase = Room.databaseBuilder(
        context.applicationContext,
        TownDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val townDao = database.townDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getTowns():LiveData<List<Town>> = townDao.getAllTowns()

    fun getTown(id: UUID):LiveData<Town> = townDao.getTownById(id)

    fun deleteTown(town: Town){
        executor.execute {
            townDao.deleteTown(town)
        }
    }

    fun updateTown(town: Town){
        executor.execute {
            townDao.updateTown(town)
        }
    }

    fun addTown(town: Town){
        executor.execute {
            townDao.insertTown(town)
        }
    }

    companion object {
        private var INSTANCE: TownRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = TownRepository(context)
            }
        }

        fun get(): TownRepository{
            return INSTANCE ?: throw IllegalStateException("Town Database must be initialized")
        }

    }

}