package com.t5application.character_classes.backgrounds

abstract class Background {

    var skillProficiencies: MutableList<Boolean> = mutableListOf()
    var skillProficienciesKey: MutableList<String> = mutableListOf()
    var toolProficiencies: MutableList<String> = mutableListOf()
    var equipment: MutableList<String> = mutableListOf()
    var strMod: Int = 0
    var dexMod: Int = 0
    var constMod: Int = 0
    var widMod: Int = 0
    var intMod: Int = 0
    var charMod: Int = 0

}