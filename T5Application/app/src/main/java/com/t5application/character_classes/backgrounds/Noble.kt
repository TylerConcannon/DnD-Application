package com.t5application.character_classes.backgrounds

class Noble: Background() {

    override var HISTORY: Boolean
        get() = true
        set(value) {}
    override var PERSUASION: Boolean
        get() = true
        set(value) {}

    override var gold: Int
        get() = 25
        set(value) {}

    override var equipment: MutableList<String>
        get() = mutableListOf("Set of Fine Clothes", "Signet Ring", "Scroll of Pedigree", "Purse")
        set(value) {}
}