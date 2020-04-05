package com.t5application.character_classes

import com.t5application.character_classes.backgrounds.Acolyte
import com.t5application.character_classes.backgrounds.Background
import com.t5application.character_classes.backgrounds.Criminal
import com.t5application.character_classes.classes.Class
import com.t5application.character_classes.classes.Cleric
import com.t5application.character_classes.races.Dwarf
import com.t5application.character_classes.races.Race

class Character(var name: String = "EMPTY_NAME", var race: Race = Dwarf(), var _class: Class = Cleric(), var background: Background = Acolyte(),
                var level: Int = 1, var playerName: String = "EMPTY_PLAYER_NAME", var alignment: String = "NN", var experience: Int = 0,
                var strAS: Int = 10, var dexAS: Int = 10, var constAS: Int = 10, var intAS: Int = 10, var wisAS: Int = 10, var charAS: Int = 10,
                var inspiration: Int = 0, var profBonus: Int = 0, var passivePerception: Int = 0,
                var strST: Int = 0, var dexST: Int = 0, var constST: Int = 0, var intST: Int = 0, var wisST: Int = 0, var charST: Int = 0,
                var armorClass: Int = 10, var initiative: Int = 0, var speed: Int = 30, val maxHP: Int = 5, var hitDice: String = "1d6",
                var deathSaveSuccesses: Int = 0, var deathSaveFailures: Int = 0,
                var attacks: MutableList<MutableList<String>> = mutableListOf(mutableListOf("")), var spells: MutableList<MutableList<String>> = mutableListOf(mutableListOf("")),
                var languages: MutableList<String> = mutableListOf(""), var proficiencies: MutableList<String> = mutableListOf(""),
                var equipment: MutableList<MutableList<String>> = mutableListOf(mutableListOf("")), var gold: Int = 0,
                var features: MutableList<MutableList<String>> = mutableListOf(mutableListOf(""))){




    var strength: Int = -6
        get() {
            when(strAS){
                1 -> return -5
                2, 3 -> return -4
                4, 5 -> return -3
                6, 7 -> return -2
                8, 9 -> return -1
                10, 11 -> return 0
                12, 13 -> return 1
                14, 15 -> return 2
                16, 17 -> return 3
                18, 19 -> return 4
                20, 21 -> return 5
                22, 23 -> return 6
                24, 25 -> return 7
                26, 27 -> return 8
                28, 29 -> return 9
                30 -> return 10
                else -> println("Error: No strength could be assigned")
            }
            return -6
        }
    var dexterity: Int = -6
        get() {
            when(dexAS){
                1 -> return -5
                2, 3 -> return -4
                4, 5 -> return -3
                6, 7 -> return -2
                8, 9 -> return -1
                10, 11 -> return 0
                12, 13 -> return 1
                14, 15 -> return 2
                16, 17 -> return 3
                18, 19 -> return 4
                20, 21 -> return 5
                22, 23 -> return 6
                24, 25 -> return 7
                26, 27 -> return 8
                28, 29 -> return 9
                30 -> return 10
                else -> println("Error: No dexterity could be assigned")
            }
            return -6
        }
    var constitution: Int = -6
        get() {
            when(constAS){
                1 -> return -5
                2, 3 -> return -4
                4, 5 -> return -3
                6, 7 -> return -2
                8, 9 -> return -1
                10, 11 -> return 0
                12, 13 -> return 1
                14, 15 -> return 2
                16, 17 -> return 3
                18, 19 -> return 4
                20, 21 -> return 5
                22, 23 -> return 6
                24, 25 -> return 7
                26, 27 -> return 8
                28, 29 -> return 9
                30 -> return 10
                else -> println("Error: No constitution could be assigned")
            }
            return -6
        }
    var intelligence: Int = -6
        get() {
            when(intAS){
                1 -> return -5
                2, 3 -> return -4
                4, 5 -> return -3
                6, 7 -> return -2
                8, 9 -> return -1
                10, 11 -> return 0
                12, 13 -> return 1
                14, 15 -> return 2
                16, 17 -> return 3
                18, 19 -> return 4
                20, 21 -> return 5
                22, 23 -> return 6
                24, 25 -> return 7
                26, 27 -> return 8
                28, 29 -> return 9
                30 -> return 10
                else -> println("Error: No intelligence could be assigned")
            }
            return -6
        }
    var wisdom: Int = -6
        get() {
            when(wisAS){
                1 -> return -5
                2, 3 -> return -4
                4, 5 -> return -3
                6, 7 -> return -2
                8, 9 -> return -1
                10, 11 -> return 0
                12, 13 -> return 1
                14, 15 -> return 2
                16, 17 -> return 3
                18, 19 -> return 4
                20, 21 -> return 5
                22, 23 -> return 6
                24, 25 -> return 7
                26, 27 -> return 8
                28, 29 -> return 9
                30 -> return 10
                else -> println("Error: No wisdom could be assigned")
            }
            return -6
        }
    var charisma: Int = -6
        get() {
            when(charAS){
                1 -> return -5
                2, 3 -> return -4
                4, 5 -> return -3
                6, 7 -> return -2
                8, 9 -> return -1
                10, 11 -> return 0
                12, 13 -> return 1
                14, 15 -> return 2
                16, 17 -> return 3
                18, 19 -> return 4
                20, 21 -> return 5
                22, 23 -> return 6
                24, 25 -> return 7
                26, 27 -> return 8
                28, 29 -> return 9
                30 -> return 10
                else -> println("Error: No charisma could be assigned")
            }
            return -6
        }

}