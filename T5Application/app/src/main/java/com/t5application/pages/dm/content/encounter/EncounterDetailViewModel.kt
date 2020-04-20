package com.t5application.pages.dm.content.encounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.t5application.database.encounterDB.EncounterRepository
import com.t5application.dm_classes.Encounter
import java.util.*

class EncounterDetailViewModel : ViewModel() {

    private val encounterRepository = EncounterRepository.get()
    private val encounterIdLiveData = MutableLiveData<UUID>()
    lateinit var idOfNavigation: UUID

    var encounterLiveData: LiveData<Encounter> =
        Transformations.switchMap(encounterIdLiveData){
            encounterId -> encounterRepository.getEncounter(encounterId)
        }

    fun loadEncounter(id: UUID){
        encounterIdLiveData.value = id
    }

    fun saveEncounter(encounter: Encounter){
        encounterRepository.addEncounter(encounter)
    }

    fun deleteEncounter(encounter: Encounter){
        encounterRepository.deleteEncounter(encounter)
    }

}