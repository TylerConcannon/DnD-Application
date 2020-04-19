package com.t5application.pages.dm.content.town

import androidx.lifecycle.ViewModel
import com.t5application.database.TownRepository
import com.t5application.dm_classes.Town

class TownListViewModel : ViewModel() {

    private val townRepository = TownRepository.get()
    val townListLiveData = townRepository.getTowns()

    fun addTown(town: Town){
        townRepository.addTown(town)
    }

}