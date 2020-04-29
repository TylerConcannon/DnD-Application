package com.t5application.pages.dm.content.encounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.t5application.R
import com.t5application.dm_classes.Encounter
import kotlinx.android.synthetic.main.create_encounter.*

class CreateEncounter : Fragment() {

    //Buttons
    private lateinit var generate: Button

    //Spinners
    private lateinit var terrainSpinner: Spinner
    private lateinit var enemyNumberSpinner: Spinner

    private lateinit var combatRatingEditText: EditText
    private var encounter: Encounter = Encounter()

    private val encounterDetailViewModel: EncounterDetailViewModel by activityViewModels()
    private val encounterListViewModel: EncounterListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_encounter, container, false)

        activity?.title =  "Create Encounter"

        terrainSpinner = view.findViewById(R.id.terrainSpinner)
        enemyNumberSpinner = view.findViewById(R.id.enemyNumberSpinner)
        combatRatingEditText = view.findViewById(R.id.crEditText)

        val terrains = resources.getStringArray(R.array.terrains)
        terrainSpinner(terrains)

        val enemyNumbers = resources.getStringArray(R.array.enemyNumber)
        enemyNumberSpinner(enemyNumbers)

        generate = view.findViewById(R.id.confirmEncounterButton)

        generate.setOnClickListener {


            // Concannon's Code Start ------------------------------------------------------------------------------------------
            var monsterNames= mutableListOf<String>()
            var monsterWeapons= mutableListOf<String>()

            for(i in 3 downTo 0){
                println(resources.getStringArray(R.array.cr)[i].toInt())
                if(resources.getStringArray(R.array.cr)[i].toInt() > (crEditText.text.toString().toInt() / enemyNumbers[enemyNumberSpinner.selectedItemPosition].toInt())) {     //If(CR from string list > userCR/user#) continue; else (add same monster * user#)
                    println(resources.getStringArray(R.array.cr)[i] + "     " + (crEditText.text.toString().toInt() / enemyNumbers[enemyNumberSpinner.selectedItemPosition].toInt()))
                    continue
                }
                else{

                    if(terrains[terrainSpinner.selectedItemPosition] == "Forest"){
                        println("Forest")
                        for(o in 0..enemyNumbers[enemyNumberSpinner.selectedItemPosition].toInt()) {
                            monsterNames.add(resources.getStringArray(R.array.forestEnemy)[i])
                            monsterWeapons.add(resources.getStringArray(R.array.forestWeapons)[i])
                        }
                        break
                    }
                    else if(terrains[terrainSpinner.selectedItemPosition] == "Hills"){
                        for(o in 0..enemyNumbers[enemyNumberSpinner.selectedItemPosition].toInt()) {
                            monsterNames.add(resources.getStringArray(R.array.hillEnemy)[i])
                            monsterWeapons.add(resources.getStringArray(R.array.hillWeapons)[i])
                        }
                        break
                    }
                    else if(terrains[terrainSpinner.selectedItemPosition] == "Mountains"){
                        for(o in 0..enemyNumbers[enemyNumberSpinner.selectedItemPosition].toInt()) {
                            monsterNames.add(resources.getStringArray(R.array.mountainEnemy)[i])
                            monsterWeapons.add(resources.getStringArray(R.array.mountainWeapons)[i])
                        }
                        break
                    }
                    else{
                        for(o in 0..enemyNumbers[enemyNumberSpinner.selectedItemPosition].toInt()) {
                            monsterNames.add(resources.getStringArray(R.array.swampEnemy)[i])
                            monsterWeapons.add(resources.getStringArray(R.array.swampWeapons)[i])
                        }
                        break
                    }
                }
            }
            // Concannon's Code End ------------------------------------------------------------------------------------------

            encounter.monsterWeapons = monsterWeapons.toList()
            encounter.encMonsters = monsterNames.toList()
            encounter.encMonsterNumber = enemyNumbers[enemyNumberSpinner.selectedItemPosition].toInt()
            encounter.encCR = crEditText.text.toString().toInt()
            encounter.encTerrain = terrains[terrainSpinner.selectedItemPosition]

            encounterDetailViewModel.saveEncounter(encounter)
            encounterListViewModel.encounters.add(encounter)
            encounterDetailViewModel.idOfNavigation = encounter.id

            encounter.printEncounter()


            view.findNavController().navigate(R.id.CreateEncounterToEncounterViewer)
        }

        return view;
    }

    private fun terrainSpinner(terrains: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, terrains)

        terrainSpinner.adapter = adapter
    }

    private fun enemyNumberSpinner(enemyNumbers: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, enemyNumbers)

        enemyNumberSpinner.adapter = adapter
    }

}
