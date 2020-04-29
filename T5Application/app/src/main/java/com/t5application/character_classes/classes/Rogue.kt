package com.t5application.character_classes.classes

class Rogue: Class(){

    var localProficiencies = mutableListOf<String>(
        "Light Armor",
        "Simple Weapons", "Hand Crossbows", "Longswords", "Rapiers", "Shortswords",
        "Thieves' Tools",
        "DexST", "IntST"
    )
    var Class.proficiencies: MutableList<String>
        get() = localProficiencies
        set(value) = TODO()
    var Class.baseHP: Int
        get() = 8
        set(value) = TODO()
    var Class.profBonus: Int
        get(){
            return when{
                level < 5 -> 2
                level < 9 -> 3
                level < 13 -> 4
                level < 17 -> 5
                else -> 6
            }
        }
        set(value) = TODO()

    var sneakAttackDice: String = "1d6"
        get(){
            return when{
                level < 3 -> "1d6"
                level < 5 -> "2d6"
                level < 7 -> "3d6"
                level < 9 -> "4d6"
                level < 11 -> "5d6"
                level < 13 -> "6d6"
                level < 15 -> "7d6"
                level < 17 -> "8d6"
                level < 19 -> "9d6"
                else -> "10d6"
            }
        }

    override fun toString(): String {
        return "Rogue"
    }
}