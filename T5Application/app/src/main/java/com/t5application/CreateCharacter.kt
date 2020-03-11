package com.t5application

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import java.util.logging.Level


class CreateCharacter : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_character, container, false)

        raceSpinner(view)
        classSpinner(view)
        backgroundSpinner(view)
        levelSpinner(view)

        return view
    }

    fun raceSpinner(view: View){
        val RaceSpinner = view.findViewById<Spinner>(R.id.RaceSpinner)
        var list = resources.getStringArray(R.array.races)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        RaceSpinner.adapter = adapter
    }

    fun classSpinner(view: View){
        val ClassSpinner = view.findViewById<Spinner>(R.id.ClassSpinner)
        var list = resources.getStringArray(R.array.classes)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        ClassSpinner.adapter = adapter
    }

    fun backgroundSpinner(view: View){
        val BackgroundSpinner = view.findViewById<Spinner>(R.id.BackgroundSpinner)
        var list = resources.getStringArray(R.array.backgrounds)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        BackgroundSpinner.adapter = adapter
    }

    fun levelSpinner(view: View){
        val LevelSpinner = view.findViewById<Spinner>(R.id.LevelsSpinner)
        var list = resources.getStringArray(R.array.levels)

        val adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_spinner_item, list)

        LevelSpinner.adapter = adapter
    }
}
