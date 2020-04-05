package com.t5application.character_classes.races

class Halfling: Race(){

    var Race.abilityScoreBonus: MutableList<Int>
        get() = mutableListOf(0, 2, 0, 0, 0, 0)
        set(value) = TODO()

    var Race.speed: Int
        get() = 25
        set(value) = TODO()

    var Race.features: MutableList<MutableList<String>>
        get() = mutableListOf(
            mutableListOf("Lucky", ""),
            mutableListOf("Brave", ""),
            mutableListOf("Halfling Nimbleness", "")
        )
        set(value) = TODO()

    var Race.languages: MutableList<String>
        get() = mutableListOf("Common", "Halfling")
        set(value) = TODO()

}