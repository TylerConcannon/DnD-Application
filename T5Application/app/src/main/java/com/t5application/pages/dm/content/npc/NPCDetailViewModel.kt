package com.t5application.pages.dm.content.npc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.t5application.database.npcDB.NPCRepository
import com.t5application.dm_classes.NPC
import java.util.*

class NPCDetailViewModel : ViewModel() {

    private val npcRepository = NPCRepository.get()
    private val npcIdLiveData = MutableLiveData<UUID>()
    lateinit var idOfNavigation: UUID

    var npcLiveData: LiveData<NPC> =
        Transformations.switchMap(npcIdLiveData){
            npcId -> npcRepository.getNPC(npcId)
        }

    fun loadNPC(id: UUID){
        npcIdLiveData.value = id
    }

    fun saveNPC(npc: NPC){
        npcRepository.addNPC(npc)
    }

    fun deleteNPC(npc: NPC){
        npcRepository.deleteNPC(npc)
    }

}