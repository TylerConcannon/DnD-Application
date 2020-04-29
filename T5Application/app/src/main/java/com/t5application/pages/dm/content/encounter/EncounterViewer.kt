package com.t5application.pages.dm.content.encounter

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
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
import kotlinx.android.synthetic.main.encounter_list_view.*

class EncounterViewer : Fragment() {

    private lateinit var crTextView: TextView
    private lateinit var terrainTextView: TextView

    private lateinit var enemyList: TextView
    private lateinit var enemyWeapons: TextView

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

        enemyList = view.findViewById(R.id.enemyNameList)
        enemyList.movementMethod = ScrollingMovementMethod()
        enemyWeapons = view.findViewById(R.id.enemyWeaponList)
        enemyWeapons.movementMethod = ScrollingMovementMethod()

        doneButton = view.findViewById(R.id.doneEncounterButton)
        deleteButton = view.findViewById(R.id.encounterViewDeleteButton)

        activity?.title =  "Encounter"

        doneButton.setOnClickListener{
            view.findNavController().navigate(R.id.encounterViewToEncounterRecyclerView)
        }

        deleteButton.setOnClickListener{
            encounterDetailViewModel.deleteEncounter(encounter)
            view.findNavController().navigate(R.id.encounterViewToEncounterRecyclerView)
        }

        return view;
    }

    private fun updateUI(){
        crTextView.text = encounter.encCR.toString()
        terrainTextView.text = encounter.encTerrain

        enemyList.text = "${encounter.encMonsters[0]} \n"
        for(i in 1 until encounter.encMonsters.size){
            enemyList.text = "${enemyList.text}${encounter.encMonsters[i]} \n"
        }
        enemyWeapons.text = "${encounter.monsterWeapons[0]} \n"
        for(i in 1 until encounter.monsterWeapons.size){
            enemyWeapons.text = "${enemyWeapons.text}${encounter.monsterWeapons[i]} \n"
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        encounterDetailViewModel.encounterLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                    encounter -> encounter?.let {
                this.encounter = encounter
                updateUI()
            }
            }
        )

    }
}
