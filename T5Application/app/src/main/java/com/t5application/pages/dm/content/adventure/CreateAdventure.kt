package com.t5application.pages.dm.content.adventure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.t5application.R
import com.t5application.dm_classes.Adventure
import com.t5application.dm_classes.Encounter
import com.t5application.dm_classes.Town
import kotlinx.android.synthetic.main.create_encounter.*

class CreateAdventure : Fragment() {

    //Adventure
    private var adventure: Adventure = Adventure()

    //Buttons
    private lateinit var generate: Button

    //Spinners
    private lateinit var lengthSpinner: Spinner
    private lateinit var typeSpinner: Spinner
    private lateinit var encounterNumberSpinner: Spinner

    private val adventureDetailViewModel: AdventureDetailViewModel by activityViewModels()
    private val adventureListViewModel: AdventureListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_adventure, container, false)

        activity?.title =  "Create Adventure"

        lengthSpinner = view.findViewById(R.id.lengthSpinner)
        typeSpinner = view.findViewById(R.id.typeSpinner)
        encounterNumberSpinner = view.findViewById(R.id.encounterNumberSpinner)

        val lengths = resources.getStringArray(R.array.length)
        lengthSpinner(lengths)

        val types = resources.getStringArray(R.array.enemyNumber) // TODO Fix Later
        typeSpinner(types)

        val encounterNumber = resources.getStringArray(R.array.encounterNumber)
        encounterNumberSpinner(encounterNumber)

        generate = view.findViewById(R.id.confirmAdventureButton)


        //Logic
        adventure.length = resources.getStringArray(R.array.townSizes).get(lengthSpinner.selectedItemPosition.toInt())
        adventure.questType = resources.getStringArray(R.array.questType).get(typeSpinner.selectedItemPosition.toInt())

        var terrain: Int = (1..4).random()
        var cr: Int = (1..4).random()

        if(cr == 1) cr = 50
        else if(cr == 2) cr = 100
        else if(cr == 3) cr = 700
        else cr = 1000

        for(i in 0 until encounterNumberSpinner.selectedItemPosition.toInt()) {
            createEncounter((1..12).random(), terrain, cr)
        }

        for(i in 0..lengthSpinner.selectedItemPosition.toInt()){
            createTown(i)
        }
        //End Logic


        generate.setOnClickListener {
            view.findNavController().navigate(R.id.CreateAdventureToAdventureViewer)
        }

        adventureDetailViewModel.saveAdventure(adventure)
        adventureListViewModel.adventures.add(adventure)
        adventureDetailViewModel.idOfNavigation = adventure.id

        return view
    }

    private fun lengthSpinner(classes: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, classes)

        lengthSpinner.adapter = adapter
    }

    private fun typeSpinner(backgrounds: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, backgrounds)

        typeSpinner.adapter = adapter
    }

    private fun encounterNumberSpinner(levels: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, levels)

        encounterNumberSpinner.adapter = adapter
    }

    private fun createEncounter(enemyNumbers: Int, terrain: Int, cr: Int) {
        var encounter: Encounter = Encounter()
        for(i in 3 downTo 0){
            if(resources.getStringArray(R.array.cr)[i].toInt() != cr) {
                continue
            }
            else{
                var monsterNames= mutableListOf<String>()
                var monsterWeapons= mutableListOf<String>()

                if(terrain == 1){  //forest
                    println("Forest")
                    for(o in 0 until enemyNumbers) {
                        monsterNames.add(resources.getStringArray(R.array.forestEnemy)[i])
                        monsterWeapons.add(resources.getStringArray(R.array.forestWeapons)[i])
                    }
                }
                else if(terrain == 2){  //hills
                    for(o in 0 until enemyNumbers) {
                        monsterNames.add(resources.getStringArray(R.array.hillEnemy)[i])
                        monsterWeapons.add(resources.getStringArray(R.array.hillWeapons)[i])
                    }
                }
                else if(terrain == 3){  //mountains
                    for(o in 0 until enemyNumbers) {
                        monsterNames.add(resources.getStringArray(R.array.mountainEnemy)[i])
                        monsterWeapons.add(resources.getStringArray(R.array.mountainWeapons)[i])
                    }
                }
                else{
                    for(o in 0 until enemyNumbers) {    //swamp
                        monsterNames.add(resources.getStringArray(R.array.swampEnemy)[i])
                        monsterWeapons.add(resources.getStringArray(R.array.swampWeapons)[i])
                    }
                }

                encounter.encMonsters = monsterNames
                encounter.monsterWeapons = monsterWeapons

                var names: String = ""
                var weapons: String = ""

                for(k in 0 until monsterNames.size){
                    names += monsterNames[k] + "~~"
                    weapons += monsterWeapons[k] + "~~"
                }

                adventure.encounterNames += names + "::"
                adventure.encounterWeapons += weapons + "::"
            }
        }
    }

    private fun createTown(length: Int) {

        var name= resources.getStringArray(R.array.townNames)[length]

        adventure.townNames += name + "::"

    }
}
