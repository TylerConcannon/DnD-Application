package com.t5application.character_classes.backgrounds

class Noble: Background() {

    var localProficiencies = mutableListOf<String>("History", "Persuasion", "Gaming Set")
    var localEquipment = mutableListOf<MutableList<String>>(
        mutableListOf("Fine Clothes", ""),
        mutableListOf("Signet Ring", ""),
        mutableListOf("Scroll of Pedigree", "")
    )
    var localMoney = 25
    var localFeats = mutableListOf<MutableList<String>>(
        mutableListOf("Position of Privilege", "Thanks to your noble birth, people are inclined to think" +
                " the best of you. You are welcome in high society, and" +
                " people assume you have the right to be wherever you are." +
                " The common folk make every effort to accommodate you" +
                " and avoid your displeasure, and other people of high birth" +
                " treat you as a member of the same social sphere. You can" +
                " secure an audience with a local noble if you need to.")
    )

    var Background.features: MutableList<MutableList<String>>
        get() = localFeats
        set(value) = TODO()
    var Background.gold: Int
        get() = localMoney
        set(value) = TODO()
    var Background.equipment: MutableList<MutableList<String>>
        get() = localEquipment
        set(value) = TODO()
    var Background.proficiencies: MutableList<String>
        get() = localProficiencies
        set(value) = TODO()

}