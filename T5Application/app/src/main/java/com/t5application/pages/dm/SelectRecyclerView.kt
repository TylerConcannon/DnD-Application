package com.t5application.pages.dm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.t5application.R
import com.t5application.dm_classes.Encounter
import com.t5application.pages.dm.content.adventure.AdventureViewer

class SelectRecyclerView : Fragment() {

    private lateinit var npcButton: Button
    private lateinit var townButton: Button
    private lateinit var adventureButton: Button
    private lateinit var encounterButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.select_recycler_view, container, false)

        activity?.title = "Choose List To View"

        npcButton = view.findViewById(R.id.randomNPCA)
        townButton = view.findViewById(R.id.randomTownA)
        adventureButton = view.findViewById(R.id.randomAdventureA)
        encounterButton = view.findViewById(R.id.randomEncounterA)

        npcButton.setOnClickListener {
            view.findNavController().navigate(R.id.SelectRecyclerViewToNPCRecyclerView)
        }

        townButton.setOnClickListener {
            view.findNavController().navigate(R.id.SelectRecyclerViewToTownRecyclerView)
        }

        adventureButton.setOnClickListener {
            //view.findNavController().navigate(R.id.SelectRecyclerViewToAdventureRecyclerView)
        }

        encounterButton.setOnClickListener {
            view.findNavController().navigate(R.id.SelectRecyclerViewToEncounterRecyclerView)
        }

        return view

    }

}