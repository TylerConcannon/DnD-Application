package com.t5application.pages.dm.content.adventure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

import com.t5application.R

class CreateAdventure : Fragment() {

    private lateinit var generate: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_adventure, container, false)

        activity?.title =  "Create Adventure"

        generate = view.findViewById(R.id.confirmAdventureButton)

        generate.setOnClickListener {
            view.findNavController().navigate(R.id.CreateAdventureToAdventureViewer)
        }

        return view
    }
}
