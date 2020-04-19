package com.t5application.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.t5application.dm_classes.Town

@Dao
interface TownDao {
    @Query("SELECT * FROM town_database")
    fun getAllTowns(): LiveData<List<Town>>

    @Query("SELECT * FROM town_database WHERE id=(:townId)")
    fun getTownById(townId: Int): LiveData<Town>

    @Update
    fun updateTown(town: Town)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTown(town: Town)

    @Delete
    fun deleteTown(town:Town)
}