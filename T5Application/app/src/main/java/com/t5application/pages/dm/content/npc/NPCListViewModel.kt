package com.t5application.pages.dm.content.npc

import androidx.lifecycle.ViewModel
import com.t5application.database.npcDB.NPCRepository
import com.t5application.dm_classes.NPC

class NPCListViewModel : ViewModel() {

    private val npcRepository = NPCRepository.get()
    val npcListLiveData = npcRepository.getNPCs()
    var npcs = mutableListOf<NPC>()

    fun addNPC(npc: NPC){
        npcRepository.addNPC(npc)
    }

}