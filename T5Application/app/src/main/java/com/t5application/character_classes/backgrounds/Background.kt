package com.t5application.character_classes.backgrounds

abstract class Background {
    private var equipment: MutableList<MutableList<String>> = mutableListOf()
    private var languages: MutableList<String> = mutableListOf()
    private var features: MutableList<MutableList<String>> = mutableListOf(mutableListOf())
    private var gold: Int = 0
    private var proficiencies: MutableList<String> = mutableListOf()

}