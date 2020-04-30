package com.t5application.pages.dm.content.adventure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.t5application.database.encounterDB.EncounterRepository
import com.t5application.dm_classes.Encounter
import java.util.*

class AdventureDetailViewModel : ViewModel() {

    private val adventureRepository = EncounterRepository.get()
    private val adventureIdLiveData = MutableLiveData<UUID>()
    lateinit var idOfNavigation: UUID

    var encounterLiveData: LiveData<Encounter> =
        Transformations.switchMap(adventureIdLiveData){
                encounterId -> adventureRepository.getEncounter(encounterId)
        }

    fun loadEncounter(id: UUID){
        adventureIdLiveData.value = id
    }

    fun saveEncounter(encounter: Encounter){
        adventureRepository.addEncounter(encounter)
    }

    fun deleteEncounter(encounter: Encounter){
        adventureRepository.deleteEncounter(encounter)
    }
}