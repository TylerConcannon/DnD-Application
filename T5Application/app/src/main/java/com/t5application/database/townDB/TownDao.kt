package com.t5application.database.townDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.t5application.dm_classes.Town
import java.util.*

@Dao
interface TownDao {
    @Query("SELECT * FROM town_database")
    fun getAllTowns(): LiveData<List<Town>>

    @Query("SELECT * FROM town_database WHERE id=(:townId)")
    fun getTownById(townId: UUID): LiveData<Town>

    @Update
    fun updateTown(town: Town)

    @Insert
    fun insertTown(town: Town)

    @Delete
    fun deleteTown(town: Town)
}