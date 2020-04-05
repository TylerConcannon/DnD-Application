package com.t5application.character_classes.races

class Dwarf: Race(){

    var Race.abilityScoreBonus: MutableList<Int>
        get() = mutableListOf(0, 0, 2, 0, 0, 0)
        set(value) = TODO()

    var Race.speed: Int
        get() = 25
        set(value) = TODO()

    var Race.features: MutableList<MutableList<String>>
        get() = mutableListOf(
            mutableListOf("Darkvision", "You can see 30 feet further in dim light and can see in dark light as if it were dim, but with no color"),
            mutableListOf("Dwarven Resilience", ""),
            mutableListOf("Dwarven Combat Training", ""),
            mutableListOf("Stonecunning", "")
        )
        set(value) = TODO()

    var Race.languages: MutableList<String>
        get() = mutableListOf("Common", "Dwarvish")
        set(value) = TODO()

}