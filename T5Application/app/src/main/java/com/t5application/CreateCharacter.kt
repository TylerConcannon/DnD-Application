package com.t5application

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import java.util.logging.Level


class CreateCharacter : Fragment() {

    //Buttons
    private lateinit var createCharacter: Button

    //Spinners
    private lateinit var raceSpinner: Spinner
    private lateinit var classSpinner: Spinner
    private lateinit var backgroundSpinner: Spinner
    private lateinit var levelSpinner: Spinner

    //TextBoxes
    private lateinit var nameText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_character, container, false)

        nameText = view.findViewById(R.id.CharacterName)
        raceSpinner = view.findViewById(R.id.RaceSpinner)
        classSpinner = view.findViewById(R.id.ClassSpinner)
        backgroundSpinner = view.findViewById(R.id.BackgroundSpinner)
        levelSpinner = view.findViewById(R.id.LevelsSpinner)
        createCharacter = view.findViewById(R.id.ConfirmCharatcerButton)

        raceSpinner()
        classSpinner()
        backgroundSpinner()
        levelSpinner()

        createCharacter.setOnClickListener {



            view.findNavController().navigate(R.id.CreateCharacterToCharacterSheet)
        }

        return view
    }

    fun raceSpinner(){
        val list = resources.getStringArray(R.array.races)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        raceSpinner.adapter = adapter
    }

    fun classSpinner(){
        val list = resources.getStringArray(R.array.classes)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        classSpinner.adapter = adapter
    }

    fun backgroundSpinner(){
        val list = resources.getStringArray(R.array.backgrounds)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        backgroundSpinner.adapter = adapter
    }

    fun levelSpinner(){
        val list = resources.getStringArray(R.array.levels)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        levelSpinner.adapter = adapter
    }
}
