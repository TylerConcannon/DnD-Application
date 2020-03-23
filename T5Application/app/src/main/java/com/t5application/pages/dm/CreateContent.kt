package com.t5application.pages.dm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.t5application.R

class CreateContent : Fragment() {

    private lateinit var npcButton: Button
    private lateinit var townButton: Button
    private lateinit var adventureButton: Button
    private lateinit var encounterButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_content, container, false)

        activity?.title =  "Create Content"

        npcButton = view.findViewById(R.id.randomNPC)
        townButton = view.findViewById(R.id.randomTown)
        adventureButton = view.findViewById(R.id.randomAdventure)
        encounterButton = view.findViewById(R.id.randomEncounter)

        npcButton.setOnClickListener {
            view.findNavController().navigate(R.id.CreateContentToCreateNPC)
        }

        townButton.setOnClickListener {
            view.findNavController().navigate(R.id.CreateContentToCreateTown)
        }

        adventureButton.setOnClickListener {
            view.findNavController().navigate(R.id.CreateContentToCreateAdventure)
        }

        encounterButton.setOnClickListener {
            view.findNavController().navigate(R.id.CreateContentToCreateEncounter)
        }

        return view
        }
    }
