package com.t5application.database.encounterDB

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.t5application.dm_classes.Encounter
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "encounter_database"

class EncounterRepository private constructor(context: Context){

    private val database: EncounterDatabase = Room.databaseBuilder(
        context.applicationContext,
        EncounterDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val encounterDao = database.encounterDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getEncounters(): LiveData<List<Encounter>> = encounterDao.getAllEncounters()

    fun getEncounter(id: UUID): LiveData<Encounter> = encounterDao.getEncounterById(id)

    fun deleteEncounter(encounter: Encounter){
        executor.execute {
            encounterDao.deleteEncounter(encounter)
        }
    }

    fun updateEncounter(encounter: Encounter){
        executor.execute {
            encounterDao.updateEncounter(encounter)
        }
    }

    fun addEncounter(encounter: Encounter){
        executor.execute {
            encounterDao.insertEncounter(encounter)
        }
    }

    companion object{
        private var INSTANCE: EncounterRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = EncounterRepository(context)
            }
        }

        fun get(): EncounterRepository {
            return INSTANCE ?: throw IllegalStateException("Encounter Database must be initialized")
        }

    }

}