package com.t5application

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.findNavController

class CharacterRecyclerView : Fragment() {

    private lateinit var AddCharacter: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.character_recycler_view, container, false)

        AddCharacter = view.findViewById(R.id.AddCharacterButton)

        AddCharacter.setOnClickListener {
            view.findNavController().navigate(R.id.CharacterRecyclerViewToCreateCharacter)
        }

        return view
    }

}
