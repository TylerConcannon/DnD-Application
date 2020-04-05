package com.t5application.character_classes.backgrounds

class Soldier: Background() {
    var localProficiencies = mutableListOf<String>("Athletics", "Intimidation", "Gaming Set", "Land Vehicles")
    var localEquipment = mutableListOf<MutableList<String>>(
        mutableListOf("Insignia of Rank", ""),
        mutableListOf("Trophy from Fallen Enemy", ""),
        mutableListOf("Gaming Set", ""),
        mutableListOf("Common Clothes", "")
    )
    var localMoney = 10
    var localFeats = mutableListOf<MutableList<String>>(
        mutableListOf("Military Rank", "You have a military rank from your career as a soldier." +
                " Soldiers loyal to your former military organization still" +
                " recognize your authority and influence, and they defer to" +
                " you if they are of a lower rank. You can invoke your rank" +
                " to exert influence over other soldiers and requisition simple equipment or horses for temporary use. You can also" +
                " usually gain access to friendly military encampments and" +
                " fortresses where your rank is recognized.")
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