package com.t5application.pages.player

import androidx.lifecycle.ViewModel
import com.t5application.character_classes.Character
import com.t5application.database.characterDB.CharacterRepository

class CharacterListViewModel : ViewModel() {

    private val characterRepository = CharacterRepository.get()
    val characterListLiveData = characterRepository.getCharacters()
    var characters = mutableListOf<Character>()

    fun addCharacter(character: Character){
        characterRepository.addCharacter(character)
    }

}