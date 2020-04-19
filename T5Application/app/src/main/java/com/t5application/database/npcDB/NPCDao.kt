package com.t5application.database.npcDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.t5application.dm_classes.NPC
import java.util.*

@Dao
interface NPCDao {

    @Query("SELECT * FROM npc_database")
    fun getAllNPCs(): LiveData<List<NPC>>

    @Query("SELECT * FROM npc_database WHERE id=(:npcId)")
    fun getNPCById(npcId: UUID): LiveData<NPC>

    @Update
    fun updateNPC(npc: NPC)

    @Insert
    fun insertNPC(npc: NPC)

    @Delete
    fun deleteNPC(npc: NPC)

}