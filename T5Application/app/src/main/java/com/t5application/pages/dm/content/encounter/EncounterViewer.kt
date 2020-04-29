package com.t5application.pages.dm.content.encounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.t5application.R
import com.t5application.dm_classes.Encounter

class EncounterViewer : Fragment() {

    private lateinit var crTextView: TextView
    private lateinit var terrainTextView: TextView

    private lateinit var doneButton: Button
    private lateinit var deleteButton: Button

    private lateinit var encounter: Encounter

    private val encounterDetailViewModel: EncounterDetailViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        encounter = Encounter()
        val encID = encounterDetailViewModel.idOfNavigation
        encounterDetailViewModel.loadEncounter(encID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.encounter_viewer, container, false)

        crTextView = view.findViewById(R.id.crTextView)
        terrainTextView = view.findViewById(R.id.encTerrainTextView)
        //doneButton = view.findViewById(R.id.doneEncounterButton)
        //deleteButton = view.findViewById(R.id.deleteEncounterButton)
        activity?.title =  "Encounter"

        return view;
    }

    private fun updateUI(){
        crTextView.text = encounter.encCR.toString()
        terrainTextView.text = encounter.encTerrain
        // TODO the stuff for scroll view with the monsters
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        encounterDetailViewModel.encounterLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                enc -> enc?.let {
                this.encounter = enc
                updateUI()
            }
            }
        )

    }
}
