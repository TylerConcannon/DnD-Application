package com.t5application.character_classes.races

abstract class Race{

    private var abilityScoreBonus: MutableList<Int> = mutableListOf()
    private var speed: Int = 30
    private var features: MutableList<MutableList<String>> = mutableListOf(mutableListOf())
    private var proficiencies: MutableList<String> = mutableListOf()
    private var languages: MutableList<String> = mutableListOf()


}