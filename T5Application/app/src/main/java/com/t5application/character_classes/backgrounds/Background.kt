package com.t5application.character_classes.backgrounds

abstract class Background {
    open var toolProficiencies: MutableList<String> = mutableListOf()
    open var equipment: MutableList<String> = mutableListOf()
    open var languages: MutableList<String> = mutableListOf()
    open var gold: Int = 0
    open var strMod: Int = 0
    open var dexMod: Int = 0
    open var constMod: Int = 0
    open var widMod: Int = 0
    open var intMod: Int = 0
    open var charMod: Int = 0

    open var INSIGHT = false
    open var RELIGION = false
    open var ANIMAL_HANDLING = false
    open var SURVIVAL = false
    open var HISTORY = false
    open var PERSUASION = false
    open var ARCANA = false
    open var ATHLETICS = false
    open var INTIMIDATION = false
    open var DECEPTION = false
    open var STEALTH = false

}