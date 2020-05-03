package com.t5application.character_classes.races

abstract class Race{

    private var abilityScoreBonus: MutableList<Int> = mutableListOf()
    private var speed: Int = 30
    var features: MutableList<MutableList<String>> = mutableListOf(mutableListOf())
    var proficiencies: MutableList<String> = mutableListOf()
    private var languages: MutableList<String> = mutableListOf()


}