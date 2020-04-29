package com.t5application.character_classes.races

class Elf: Race(){

    var Race.abilityScoreBonus: MutableList<Int>
        get() = mutableListOf(0, 2, 0, 0, 0, 0)
        set(value) = TODO()

    var Race.speed: Int
        get() = 30
        set(value) = TODO()

    var Race.features: MutableList<MutableList<String>>
        get() = mutableListOf(
            mutableListOf("Darkvision", "You can see 30 feet further in dim light and can see in dark light as if it were dim, but with no color"),
            mutableListOf("Keen Senses", ""),
            mutableListOf("Fey Ancestry", ""),
            mutableListOf("Trance", "")
        )
        set(value) = TODO()

    var Race.languages: MutableList<String>
        get() = mutableListOf("Common", "Elvish")
        set(value) = TODO()

    override fun toString(): String {
        return "Elf"
    }
}