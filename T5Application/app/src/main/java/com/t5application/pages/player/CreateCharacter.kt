package com.t5application.pages.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.t5application.R
import com.t5application.character_classes.Character
import com.t5application.character_classes.backgrounds.*
import com.t5application.character_classes.classes.*
import com.t5application.character_classes.races.*
import kotlin.math.floor


class CreateCharacter : Fragment() {

    //Buttons
    private lateinit var createCharacter: Button

    //Spinners
    private lateinit var raceSpinner: Spinner
    private lateinit var classSpinner: Spinner
    private lateinit var backgroundSpinner: Spinner
    private lateinit var levelSpinner: Spinner

    //TextBoxes
    private lateinit var nameText: EditText

    private val characterDetailViewModel: CharacterDetailViewModel by activityViewModels()
    private val characterListViewModel: CharacterListViewModel by activityViewModels()

    private var character: Character = Character()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_character, container, false)

        activity?.title =  "Create Character"

        nameText = view.findViewById(R.id.CharacterName)
        raceSpinner = view.findViewById(R.id.RaceSpinner)
        classSpinner = view.findViewById(R.id.ClassSpinner)
        backgroundSpinner = view.findViewById(R.id.BackgroundSpinner)
        levelSpinner = view.findViewById(R.id.LevelsSpinner)
        createCharacter = view.findViewById(R.id.ConfirmCharatcerButton)

        val races = resources.getStringArray(R.array.races)
        raceSpinner(races)

        val classes = resources.getStringArray(R.array.classes)
        classSpinner(classes)

        val backgrounds = resources.getStringArray(R.array.backgrounds)
        backgroundSpinner(backgrounds)

        val levels = resources.getStringArray(R.array.levels)
        levelSpinner(levels)

        createCharacter.setOnClickListener {

            character.name = nameText.text.toString()
            character.race = getRace(raceSpinner.selectedItemPosition+1)
            character._class = getClass(classSpinner.selectedItemPosition+1)
            character.background = getBackground(backgroundSpinner.selectedItemPosition+1)
            character.level = levelSpinner.selectedItemPosition+1
            character.strAS = rollDice()
            character.dexAS = rollDice()
            character.constAS = rollDice()
            character.wisAS = rollDice()
            character.intAS = rollDice()
            character.charAS = rollDice()

            var weapons: ArrayList<String> = ArrayList()
            for(i in 0 until 2){
                var ran = floor(Math.random() * 4)
                weapons.add(resources.getStringArray(R.array.weapons)[ran.toInt()])
            }
            character.attacks = weapons

            characterDetailViewModel.saveCharacter(character)
            characterListViewModel.characters.add(character)
            characterDetailViewModel.idOfNavigation = character.id
            view.findNavController().navigate(R.id.CreateCharacterToCharacterSheet)
        }

        return view
    }

    private fun raceSpinner(races: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, races)

        raceSpinner.adapter = adapter
    }

    private fun classSpinner(classes: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, classes)

        classSpinner.adapter = adapter
    }

    private fun backgroundSpinner(backgrounds: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, backgrounds)

        backgroundSpinner.adapter = adapter
    }

    private fun levelSpinner(levels: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, levels)

        levelSpinner.adapter = adapter
    }

    private fun getRace(raceInt: Int): Race{
        return when (raceInt) {
            1 -> Dwarf()
            2 -> Elf()
            3 -> Halfling()
            4 -> Human()
            else -> Dwarf()
        }
    }

    private fun getClass(classInt: Int): Class{
        return when (classInt) {
            1 -> Cleric()
            2 -> Fighter()
            3 -> Rogue()
            4 -> Wizard()
            else -> Cleric()
        }
    }

    private fun getBackground(bgInt: Int): Background {
        return when (bgInt){
            1 -> Acolyte()
            2 -> Criminal()
            3-> FolkHero()
            4-> Noble()
            5-> Sage()
            else -> Soldier()
        }
    }

    private fun rollDice(): Int{
        val d1 = floor(Math.random() * 5 + 1)
        val d2 = floor(Math.random() * 5 + 1)
        val d3 = floor(Math.random() * 5 + 1)
        val d4 = floor(Math.random() * 5 + 1)
        val rolls = mutableListOf<Int>(d1.toInt(), d2.toInt(), d3.toInt(), d4.toInt())
        rolls.removeAt(rolls.indexOf(rolls.min()))
        var total = 0
        for(i in 0 until 3){
            total += rolls[i]
        }
        return total
    }
}
