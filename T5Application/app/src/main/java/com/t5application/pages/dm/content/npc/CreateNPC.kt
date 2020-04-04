package com.t5application.pages.dm.content.npc

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

class CreateNPC : Fragment() {

    //Buttons
    private lateinit var generate: Button

    //Spinners
    private lateinit var raceSpinner: Spinner
    private lateinit var occupationSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_npc, container, false)

        activity?.title =  "Create NPC"

        raceSpinner = view.findViewById(R.id.raceSpinner)
        occupationSpinner = view.findViewById(R.id.occupationSpinner)

        val races = resources.getStringArray(R.array.races)
        raceSpinner(races)

        val occupations = resources.getStringArray(R.array.occupations)
        occupationSpinner(occupations)

        generate = view.findViewById(R.id.confirmNPCButton)

        generate.setOnClickListener {
            view.findNavController().navigate(R.id.CreateNPCToNPCViewer)
        }

        return view
    }

    private fun raceSpinner(races: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, races)

        raceSpinner.adapter = adapter
    }

    private fun occupationSpinner(occupations: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, occupations)

        occupationSpinner.adapter = adapter
    }

}
