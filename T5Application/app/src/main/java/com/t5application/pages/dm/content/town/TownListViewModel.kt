package com.t5application.pages.dm.content.town

import androidx.lifecycle.ViewModel
import com.t5application.database.townDB.TownRepository
import com.t5application.dm_classes.Town

class TownListViewModel : ViewModel() {

    private val townRepository = TownRepository.get()
    val townListLiveData = townRepository.getTowns()
    //private val town1 = Town(0, "TestingTown", "Large", "rocky", "lots")
    //private val town2 = Town(1, "Tylerville", "Medium", "smooth af", "eh")
    var towns = mutableListOf<Town>()

    fun addTown(town: Town){
        townRepository.addTown(town)
    }

}