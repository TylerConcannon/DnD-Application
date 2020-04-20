package com.t5application.pages.dm.content.encounter

import androidx.lifecycle.ViewModel
import com.t5application.database.encounterDB.EncounterRepository
import com.t5application.dm_classes.Encounter

class EncounterListViewModel : ViewModel() {

    private val encounterRepository = EncounterRepository.get()
    val encounterListLiveData = encounterRepository.getEncounters()
    var encounters = mutableListOf<Encounter>()

    fun addEncounter(encounter: Encounter){
        encounterRepository.addEncounter(encounter)
    }

}