package com.t5application.database.encounterDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.t5application.dm_classes.Encounter
import java.util.*

@Dao
interface EncounterDao {

    @Query("SELECT * FROM encounter_database")
    fun getAllEncounters(): LiveData<List<Encounter>>

    @Query("SELECT * FROM encounter_database WHERE id=(:encounterId)")
    fun getEncounterById(encounterId: UUID): LiveData<Encounter>

    @Update
    fun updateEncounter(encounter: Encounter)

    @Insert
    fun insertEncounter(encounter: Encounter)

    @Delete
    fun deleteEncounter(encounter: Encounter)

}