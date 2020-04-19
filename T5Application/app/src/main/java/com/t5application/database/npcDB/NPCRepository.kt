package com.t5application.database.npcDB

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.t5application.dm_classes.NPC
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "npc_database"

class NPCRepository private constructor(context: Context){

    private val database: NPCDatabase = Room.databaseBuilder(
        context.applicationContext,
        NPCDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val npcDao = database.npcDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getNPCs(): LiveData<List<NPC>> = npcDao.getAllNPCs()

    fun getNPC(id: UUID): LiveData<NPC> = npcDao.getNPCById(id)

    fun deleteNPC(npc: NPC){
        executor.execute {
            npcDao.deleteNPC(npc)
        }
    }

    fun updateNPC(npc: NPC){
        executor.execute {
            npcDao.updateNPC(npc)
        }
    }

    fun addNPC(npc: NPC){
        executor.execute {
            npcDao.insertNPC(npc)
        }
    }

    companion object{
        private var INSTANCE: NPCRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = NPCRepository(context)
            }
        }

        fun get(): NPCRepository {
            return INSTANCE ?: throw IllegalStateException("NPC Database must be initialized")
        }

    }

}