package com.t5application.character_classes.backgrounds

class Criminal: Background() {

    var localProficiencies = mutableListOf<String>("Deception", "Stealth", "One Type of Gaming Set", "Thieves' Tools")
    var localEquipment = mutableListOf<MutableList<String>>(
        mutableListOf("Crowbar", ""),
        mutableListOf("Dark Common Clothes", "")
    )
    var localMoney = 15
    var localFeats = mutableListOf<MutableList<String>>(
        mutableListOf("Criminal Contact", "You have a reliable and trustworthy contact who acts as" +
                " your liaison to a network of other criminals. You know" +
                " how to get messages to and from your contact, even over" +
                " great distances; specifically, you know the local messengers, corrupt caravan masters, and seedy sailors who can" +
                " deliver messages for you.")
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
    //No languages provided by criminal background
    var Background.proficiencies: MutableList<String>
        get() = localProficiencies
        set(value) = TODO()

    override fun toString(): String {
        return "Criminal"
    }
}