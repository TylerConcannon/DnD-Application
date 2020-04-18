package com.t5application.dm_classes

class NPC(var npcName: String, var npcRace: String, var npcOccupation: String) {

    fun getName(): String {
        return npcName;
    }

    fun getRace(): String {
        return npcRace;
    }

    fun getOccupation(): String {
        return npcOccupation;
    }
}