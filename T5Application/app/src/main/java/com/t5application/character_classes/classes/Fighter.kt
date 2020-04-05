package com.t5application.character_classes.classes

class Fighter: Class(){

    var localProficiencies = mutableListOf<String>(
        "All Armor", "Shields",
        "Simple Weapons", "Martial Weapons",
        "WisST", "CharST"
    )
    var Class.proficiencies: MutableList<String>
        get() = localProficiencies
        set(value) = TODO()
    var Class.baseHP: Int
        get() = 10
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

}