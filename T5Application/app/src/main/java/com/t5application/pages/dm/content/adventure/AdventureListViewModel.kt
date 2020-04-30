package com.t5application.pages.dm.content.adventure

import androidx.lifecycle.ViewModel
import com.t5application.database.adventureDB.AdventureRepository
import com.t5application.dm_classes.Adventure

class AdventureListViewModel : ViewModel() {

    private val adventureRepository = AdventureRepository.get()
    val adventureListLiveData = adventureRepository.getAdventures()
    var adventures = mutableListOf<Adventure>()

    fun addEncounter(adventure: Adventure){
        adventureRepository.addAdventure(adventure)
    }

}