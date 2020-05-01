package com.t5application.database.characterDB

import android.util.Half
import androidx.room.TypeConverter
import com.t5application.character_classes.backgrounds.*
import com.t5application.character_classes.classes.*
import com.t5application.character_classes.races.*
import java.util.*

class CharacterTypeConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID?{
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String?{
        return uuid?.toString()
    }

    @TypeConverter
    fun fromString(string: String): List<String> {
        return string.split("::").map { it }
    }

    @TypeConverter
    fun fromList(list: List<String>): String{
        return list.joinToString(separator = "::")
    }

    @TypeConverter
    fun fromListList(list: List<List<String>>): String{
        var retval = ""
        for(i in list.indices){
            if(i != 0){
                retval += ";;;;"
            }
            for(j in list[i].indices){
                retval += list[i].joinToString(separator = "::::")
            }
        }
        return retval;
    }

    @TypeConverter
    fun toListList(string: String): List<List<String>>{
        var hold = string.split(";;;;").map { it }
        var retval : MutableList<List<String>> = mutableListOf(listOf(""))

        for(i in 0 until hold.size){
            retval[i] = hold[i].split("::::").map { it }
        }
        return retval
    }

    @TypeConverter
    fun fromRace(race: Race): String{
        return race.toString()
    }

    @TypeConverter
    fun fromRaceString(string: String): Race{
        return when(string){
            "Dwarf" -> Dwarf()
            "Elf" -> Elf()
            "Halfling" -> Halfling()
            else -> Human()
        }
    }

    @TypeConverter
    fun fromBackground(background: Background): String{
        return background.toString()
    }

    @TypeConverter
    fun fromBackgroundString(string: String): Background{
        return when(string){
            "Acolyte" -> Acolyte()
            "Criminal" -> Criminal()
            "Folk Hero" -> FolkHero()
            "Noble" -> Noble()
            "Sage" -> Sage()
            else -> Soldier()
        }
    }

    @TypeConverter
    fun fromClass(_class: Class): String{
        return _class.toString()
    }

    @TypeConverter
    fun fromClassString(string: String): Class{
        return when(string){
            "Cleric" -> Cleric()
            "Fighter" -> Fighter()
            "Rogue" -> Rogue()
            else -> Wizard()
        }
    }

}