package com.t5application.character_classes

import com.t5application.character_classes.classes.Class
import com.t5application.character_classes.races.Race

abstract class Character(var name: String, var level: Int = 1, var experience: Int = 0, var charRace: Race, var charClass: Class,
                         var strAS: Int, var dexAS: Int, var constAS: Int, var intAS: Int, var wisAS: Int, var charAS: Int){

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