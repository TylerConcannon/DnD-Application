package com.t5application.character_classes.backgrounds

class FolkHero: Background() {

    var localProficiencies = mutableListOf<String>("Animal Handling", "Survival", "Artisan's Tools", "Land Vehicles")
    var localEquipment = mutableListOf<MutableList<String>>(
        mutableListOf("Set of Artisan's Tools", ""),
        mutableListOf("Shovel", ""),
        mutableListOf("Iron Pot", ""),
        mutableListOf("Common Clothes", "")
    )
    var localMoney = 10
    var localFeats = mutableListOf<MutableList<String>>(
        mutableListOf("Rustic Hospitality", "Since you come from the ranks of the common folk, you" +
                " fit in among them with ease. You can find a place to hide," +
                " rest, or recuperate among other commoners, unless you" +
                " have shown yourself to be a danger to them. They will" +
                " shield you from the law or anyone else searching for you," +
                " though they will not risk their lives for you.")
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
        return "Folk Hero"
    }

}