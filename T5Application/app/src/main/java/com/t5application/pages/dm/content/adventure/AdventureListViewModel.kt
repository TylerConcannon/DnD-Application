package com.t5application.pages.dm.content.adventure

import androidx.lifecycle.ViewModel
import com.t5application.dm_classes.Adventure

class AdventureListViewModel : ViewModel() {

    private val encounterRepository = AdventureRepository.get()
    val encounterListLiveData = encounterRepository.getEncounters()
    var encounters = mutableListOf<Adventure>()

    fun addEncounter(encounter: Adventure){
        encounterRepository.addEncounter(encounter)
    }

}