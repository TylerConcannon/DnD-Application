package com.t5application.character_classes.backgrounds

class Sage: Background() {
    override var ARCANA: Boolean
        get() = true
        set(value) {}
    override var HISTORY: Boolean
        get() = true
        set(value) {}

    override var equipment: MutableList<String>
        get() = mutableListOf(
            "Bottle of Black Ink",
            "Quill",
            "Small Knife",
            "Letter from Dead Colleague",
            "Set of Common Clothes",
            "Pouch"
        )
        set(value) {}
    override var gold: Int
        get() = 10
        set(value) {}
}