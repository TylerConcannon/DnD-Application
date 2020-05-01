package com.t5application.pages.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.t5application.character_classes.Character
import com.t5application.database.characterDB.CharacterRepository
import java.util.*

class CharacterDetailViewModel : ViewModel() {

    private val characterRepository = CharacterRepository.get()
    private val characterIdLiveData = MutableLiveData<UUID>()
    lateinit var idOfNavigation: UUID

    var characterLiveData: LiveData<Character> =
        Transformations.switchMap(characterIdLiveData){
            characterId -> characterRepository.getCharacter(characterId)
        }

    fun loadCharacter(id: UUID){
        characterIdLiveData.value = id
    }

    fun saveCharacter(character: Character){
        characterRepository.addCharacter(character)
    }

    fun deleteCharacter(character: Character){
        characterRepository.deleteCharacter(character)
    }

}