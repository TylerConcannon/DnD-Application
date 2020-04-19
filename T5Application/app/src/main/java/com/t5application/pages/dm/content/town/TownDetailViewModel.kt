package com.t5application.pages.dm.content.town

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.t5application.database.townDB.TownRepository
import com.t5application.dm_classes.Town
import java.util.*

class TownDetailViewModel() : ViewModel() {

    private val townRepository = TownRepository.get()
    private val townIdLiveData = MutableLiveData<UUID>()
    lateinit var idOfNavigation: UUID

    var townLiveData: LiveData<Town> =
        Transformations.switchMap(townIdLiveData){
            townId -> townRepository.getTown(townId)
        }

    fun loadTown(townId: UUID){
        townIdLiveData.value = townId
    }

    fun saveTown(town: Town){
        townRepository.addTown(town)
    }

    fun deleteTown(town: Town){
        townRepository.deleteTown(town)
    }

}