package com.t5application.character_classes.backgrounds

class Acolyte : Background() {

    var localProficiencies = mutableListOf<String>("Insight", "Religion")
    var localEquipment = mutableListOf<MutableList<String>>(
        mutableListOf("Holy Symbol", ""),
        mutableListOf("Prayer Book/Wheel", ""),
        mutableListOf("5 Sticks of Incense", ""),
        mutableListOf("Vestments", ""),
        mutableListOf("Common Clothes", "")
    )
    var localMoney = 15
    var localFeats = mutableListOf<MutableList<String>>(
        mutableListOf("Shelter of the Faithful", "As an acolyte, you command the respect of those who" +
                " share your faith, and you can perform the religious" +
                " ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at" +
                " a temple, shrine, or other established presence of your" +
                " faith, though you must provide any material components" +
                " needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle." +
                " You might also have ties to a specific temple dedicated" +
                " to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to" +
                " serve, if you remain on good terms with it, or a temple" +
                " where you have found a new home. While near your temple, you can call upon the priests for assistance, provided" +
                " the assistance you ask for is not hazardous and you remain in good standing with your temple.")
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

    override fun toString(): String {
        return "Acolyte"
    }
}