package com.t5application.character_classes.classes

class Wizard: Class(){

    var localProficiencies = mutableListOf<String>(
        "Daggers", "Darts", "Slings", "Light Crossbows",
        "Quarter Staffs", "WisST", "IntST"
    )
    var Class.proficiencies: MutableList<String>
        get() = localProficiencies
        set(value) = TODO()
    var Class.baseHP: Int
        get() = 6
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
    var Class.spellSlots: MutableList<Int>
        get(){
            return when (level) {
                1 -> mutableListOf<Int>(2, 0, 0, 0, 0, 0, 0, 0, 0)
                2 -> mutableListOf<Int>(3, 0, 0, 0, 0, 0, 0, 0, 0)
                3 -> mutableListOf<Int>(4, 2, 0, 0, 0, 0, 0, 0, 0)
                4 -> mutableListOf<Int>(4, 3, 0, 0, 0, 0, 0, 0, 0)
                5 -> mutableListOf<Int>(4, 3, 2, 0, 0, 0, 0, 0, 0)
                6 -> mutableListOf<Int>(4, 3, 3, 0, 0, 0, 0, 0, 0)
                7 -> mutableListOf<Int>(4, 3, 3, 1, 0, 0, 0, 0, 0)
                8 -> mutableListOf<Int>(4, 3, 3, 2, 0, 0, 0, 0, 0)
                9 -> mutableListOf<Int>(4, 3, 3, 3, 1, 0, 0, 0, 0)
                10 -> mutableListOf<Int>(4, 3, 3, 3, 2, 0, 0, 0, 0)
                11 -> mutableListOf<Int>(4, 3, 3, 3, 2, 1, 0, 0, 0)
                12 -> mutableListOf<Int>(4, 3, 3, 3, 2, 1, 0, 0, 0)
                13 -> mutableListOf<Int>(4, 3, 3, 3, 2, 1, 1, 0, 0)
                14 -> mutableListOf<Int>(4, 3, 3, 3, 2, 1, 1, 0, 0)
                15 -> mutableListOf<Int>(4, 3, 3, 3, 2, 1, 1, 1, 0)
                16 -> mutableListOf<Int>(4, 3, 3, 3, 2, 1, 1, 1, 0)
                17 -> mutableListOf<Int>(4, 3, 3, 3, 2, 1, 1, 1, 1)
                18 -> mutableListOf<Int>(4, 3, 3, 3, 3, 1, 1, 1, 1)
                19 -> mutableListOf<Int>(4, 3, 3, 3, 3, 2, 1, 1, 1)
                else -> mutableListOf<Int>(4, 3, 3, 3, 3, 2, 2, 1, 1)
            }
        }
        set(value) = TODO()


}