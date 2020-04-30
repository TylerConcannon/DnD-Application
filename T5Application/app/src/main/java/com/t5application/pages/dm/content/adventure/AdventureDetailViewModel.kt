package com.t5application.pages.dm.content.adventure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.t5application.database.adventureDB.AdventureRepository
import com.t5application.database.encounterDB.EncounterRepository
import com.t5application.dm_classes.Adventure
import com.t5application.dm_classes.Encounter
import java.util.*

class AdventureDetailViewModel : ViewModel() {

    private val adventureRepository = AdventureRepository.get()
    private val adventureIdLiveData = MutableLiveData<UUID>()
    lateinit var idOfNavigation: UUID

    var adventureLiveData: LiveData<Adventure> =
        Transformations.switchMap(adventureIdLiveData){
            adventureId -> adventureRepository.getAdventure(adventureId)
        }

    fun loadAdventure(id: UUID){
        adventureIdLiveData.value = id
    }

    fun saveAdventure(adventure: Adventure){
        adventureRepository.addAdventure(adventure)
    }

    fun deleteAdventure(adventure: Adventure){
        adventureRepository.deleteAdventure(adventure)
    }
}