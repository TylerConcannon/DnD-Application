package com.t5application.database.characterDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.t5application.character_classes.Character
import java.util.*

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_database")
    fun getAllCharacters(): LiveData<List<Character>>

    @Query("SELECT * FROM character_database WHERE id=(:charID)")
    fun getCharacterById(charID: UUID): LiveData<Character>

    @Update
    fun updateCharacter(character: Character)

    @Insert
    fun insertCharacter(character: Character)

    @Delete
    fun deleteCharacter(character: Character)

}