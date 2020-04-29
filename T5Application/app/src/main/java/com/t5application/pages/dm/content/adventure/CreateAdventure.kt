package com.t5application.pages.dm.content.adventure

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

class CreateAdventure : Fragment() {

    //Buttons
    private lateinit var generate: Button

    //Spinners
    private lateinit var lengthSpinner: Spinner
    private lateinit var typeSpinner: Spinner
    private lateinit var encounterNumberSpinner: Spinner

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

        generate.setOnClickListener {
            view.findNavController().navigate(R.id.CreateAdventureToAdventureViewer)
        }

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
}
