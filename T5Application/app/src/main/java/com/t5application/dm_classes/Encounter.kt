package com.t5application.dm_classes

class Encounter(var encName: String, var encCR: Int, var encMonsterNumber: Int, var encMonsters: MutableList<String>) {

    fun getName(): String {
        return encName;
    }

    fun getCR(): Int {
        return encCR;
    }

    fun getMonsterNumber(): Int {
        return encMonsterNumber;
    }

    fun getMonsters(): MutableList<String> {
        return encMonsters;
    }
}