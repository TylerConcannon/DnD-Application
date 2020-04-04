package com.t5application.pages.dm.content.encounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.findNavController

import com.t5application.R

class CreateEncounter : Fragment() {

    //Buttons
    private lateinit var generate: Button

    //Spinners
    private lateinit var terrainSpinner: Spinner
    private lateinit var enemyNumberSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_encounter, container, false)

        activity?.title =  "Create Encounter"

        terrainSpinner = view.findViewById(R.id.terrainSpinner)
        enemyNumberSpinner = view.findViewById(R.id.enemyNumberSpinner)

        val terrains = resources.getStringArray(R.array.terrains)
        terrainSpinner(terrains)

        val enemyNumbers = resources.getStringArray(R.array.enemyNumber)
        enemyNumberSpinner(enemyNumbers)

        generate = view.findViewById(R.id.confirmEncounterButton)

        generate.setOnClickListener {
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
