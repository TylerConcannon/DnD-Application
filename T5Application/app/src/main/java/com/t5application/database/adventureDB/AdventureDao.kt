package com.t5application.database.adventureDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.t5application.dm_classes.Adventure
import java.util.*

@Dao
interface AdventureDao {

    @Query("SELECT * FROM adventure_database")
    fun getAllAdventures(): LiveData<List<Adventure>>

    @Query("SELECT * FROM adventure_database WHERE id=(:adventureID)")
    fun getAdventureById(adventureID: UUID): LiveData<Adventure>

    @Update
    fun updateAdventure(adventure: Adventure)

    @Insert
    fun insertAdventure(adventure: Adventure)

    @Delete
    fun deleteAdventure(adventure: Adventure)

}