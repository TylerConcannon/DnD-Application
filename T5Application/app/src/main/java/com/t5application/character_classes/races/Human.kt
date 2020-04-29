package com.t5application.character_classes.races

class Human: Race(){

    var Race.abilityScoreBonus: MutableList<Int>
        get() = mutableListOf(1, 1, 1, 1, 1, 1)
        set(value) = TODO()

    var Race.speed: Int
        get() = 30
        set(value) = TODO()

    var Race.languages: MutableList<String>
        get() = mutableListOf("Common")
        set(value) = TODO()

    override fun toString(): String {
        return "Human"
    }
}