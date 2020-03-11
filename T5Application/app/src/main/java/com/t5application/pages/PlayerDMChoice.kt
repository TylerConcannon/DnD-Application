package com.t5application.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.t5application.R

class PlayerDMChoice : Fragment() {

    private lateinit var PlayerButton: Button
    private lateinit var DMButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.player_dm_choice, container, false)

        PlayerButton = view.findViewById(R.id.PlayerButton)
        DMButton = view.findViewById(R.id.DMButton)

        PlayerButton.setOnClickListener {
            view.findNavController().navigate(R.id.PlayerDMChoiceToPlayerRecyclerView)
        }

        DMButton.setOnClickListener {

        }

        return view
        }
    }
