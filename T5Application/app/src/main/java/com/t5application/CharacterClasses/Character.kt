package com.t5application

abstract class Character(var strAS: Int, var dexAS: Int, var constAS: Int, var intAS: Int, var wisAS: Int, var charAS: Int){

    var strength
        get() {
            when(strAS){
                1 -> -5
                2, 3 -> -4
                4, 5 -> -3
                6, 7 -> -2
                8, 9 -> -1
                10, 11 -> 0
                12, 13 -> 1
                14, 15 -> 2
                16, 17 -> 3
                18, 19 -> 4
                20, 21 -> 5
                22, 23 -> 6
                24, 25 -> 7
                26, 27 -> 8
                28, 29 -> 9
                30 -> 10
                else -> println("Error: No strength could be assigned")
            }
        }
    var dexterity
        get() {
            when(dexAS){
                1 -> -5
                2, 3 -> -4
                4, 5 -> -3
                6, 7 -> -2
                8, 9 -> -1
                10, 11 -> 0
                12, 13 -> 1
                14, 15 -> 2
                16, 17 -> 3
                18, 19 -> 4
                20, 21 -> 5
                22, 23 -> 6
                24, 25 -> 7
                26, 27 -> 8
                28, 29 -> 9
                30 -> 10
                else -> println("Error: No dexterity could be assigned")
            }
        }
    var constitution
        get() {
            when(constAS){
                1 -> -5
                2, 3 -> -4
                4, 5 -> -3
                6, 7 -> -2
                8, 9 -> -1
                10, 11 -> 0
                12, 13 -> 1
                14, 15 -> 2
                16, 17 -> 3
                18, 19 -> 4
                20, 21 -> 5
                22, 23 -> 6
                24, 25 -> 7
                26, 27 -> 8
                28, 29 -> 9
                30 -> 10
                else -> println("Error: No constitution could be assigned")
            }
        }
    var intelligence
        get() {
            when(intAS){
                1 -> -5
                2, 3 -> -4
                4, 5 -> -3
                6, 7 -> -2
                8, 9 -> -1
                10, 11 -> 0
                12, 13 -> 1
                14, 15 -> 2
                16, 17 -> 3
                18, 19 -> 4
                20, 21 -> 5
                22, 23 -> 6
                24, 25 -> 7
                26, 27 -> 8
                28, 29 -> 9
                30 -> 10
                else -> println("Error: No intelligence could be assigned")
            }
        }
    var wisdom
        get() {
            when(wisAS){
                1 -> -5
                2, 3 -> -4
                4, 5 -> -3
                6, 7 -> -2
                8, 9 -> -1
                10, 11 -> 0
                12, 13 -> 1
                14, 15 -> 2
                16, 17 -> 3
                18, 19 -> 4
                20, 21 -> 5
                22, 23 -> 6
                24, 25 -> 7
                26, 27 -> 8
                28, 29 -> 9
                30 -> 10
                else -> println("Error: No wisdom could be assigned")
            }
        }
    var charisma
        get() {
            when(charAS){
                1 -> -5
                2, 3 -> -4
                4, 5 -> -3
                6, 7 -> -2
                8, 9 -> -1
                10, 11 -> 0
                12, 13 -> 1
                14, 15 -> 2
                16, 17 -> 3
                18, 19 -> 4
                20, 21 -> 5
                22, 23 -> 6
                24, 25 -> 7
                26, 27 -> 8
                28, 29 -> 9
                30 -> 10
                else -> println("Error: No charisma could be assigned")
            }
        }
    var name: String
    var experience: Int
    var level: Int

}