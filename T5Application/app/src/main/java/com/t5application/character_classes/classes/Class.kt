package com.t5application.character_classes.classes

abstract class Class{

    open var level: Int = 1
    get() = level
    private var profBonus: Int = 0
    private var features: MutableList<String> = mutableListOf() //TODO dependant on level
    private var baseHP: Int = 0;
    var proficiencies: MutableList<String> = mutableListOf()
    private var equipment: MutableList<MutableList<String>> = mutableListOf(mutableListOf()) // TODO choice
    private var spells: MutableList<MutableList<String>> = mutableListOf(mutableListOf()) // TODO choice
    private var cantrips: MutableList<MutableList<String>> = mutableListOf(mutableListOf()) // TODO choice
    private var spellSlots: MutableList<Int> = mutableListOf()
    private var spellSaveDC: String = "" //TODO with player input on dice roll
    private var spellAttMod: String = "" //TODO with player input on dice roll



}