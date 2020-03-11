package com.t5application.character_classes.backgrounds

class Soldier: Background() {
    override var ATHLETICS: Boolean
        get() = true
        set(value) {ATHLETICS = value}
    override var INTIMIDATION: Boolean
        get() = true
        set(value) {INTIMIDATION = value}

    override var equipment: MutableList<String>
        get() = mutableListOf(
            "Insignia of Rank",
            "Trophy Taken From Fallen Enemy",
            "Basic Game",
            "Common Clothes",
            "Pouch"
        )
        set(value) {equipment = value}
    override var gold: Int
        get() = 10
        set(value) {gold = value}
}