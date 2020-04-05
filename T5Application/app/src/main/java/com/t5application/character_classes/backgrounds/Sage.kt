package com.t5application.character_classes.backgrounds

class Sage: Background() {
    var localProficiencies = mutableListOf<String>("History", "Arcana", "Gaming Set")
    var localEquipment = mutableListOf<MutableList<String>>(
        mutableListOf("Bottle of Black Ink", ""),
        mutableListOf("A Quill", ""),
        mutableListOf("Small Knife", ""),
        mutableListOf("Letter from a Dead Colleague", ""),
        mutableListOf("Common Clothes", "")
    )
    var localMoney = 10
    var localFeats = mutableListOf<MutableList<String>>(
        mutableListOf("Researcher", "When you attempt to learn or recall a piece of lore, if you" +
                " do not know that information, you often know where and" +
                " from whom you can obtain it. Usually, this information" +
                " comes from a library, scriptorium, university, or a sage" +
                " or other learned person or creature. Your DM might rule" +
                " that the knowledge you seek is secreted away in an almost inaccessible place, or that it simply cannot be found." +
                " Unearthing the deepest secrets of the multiverse can require an adventure or even a whole campaign.")
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