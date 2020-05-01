package com.t5application.pages.dm.content.adventure

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.t5application.R
import com.t5application.dm_classes.Adventure
import com.t5application.dm_classes.Encounter
import com.t5application.dm_classes.Town

class AdventureViewer : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var lengthTextView: TextView
    private lateinit var typeTextView: TextView

    private lateinit var townNames: TextView
    private lateinit var enemyList: TextView
    private lateinit var enemyWeapons: TextView

    private lateinit var doneButton: Button
    private lateinit var deleteButton: Button

    private lateinit var adventure: Adventure

    private lateinit var encounters: ArrayList<Encounter>
    private lateinit var towns: ArrayList<Town>

    private val adventureDetailViewModel: AdventureDetailViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adventure = Adventure()
        val advID = adventureDetailViewModel.idOfNavigation
        adventureDetailViewModel.loadAdventure(advID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.adventure_viewer, container, false)

        nameTextView = view.findViewById(R.id.adventureNameTextView)
        lengthTextView = view.findViewById(R.id.adventureLengthTextView)
        typeTextView = view.findViewById(R.id.adventureTypeTextView)

        townNames = view.findViewById(R.id.townNamesList)

        enemyList = view.findViewById(R.id.monsterNameTextView)
        enemyList.movementMethod = ScrollingMovementMethod()
        enemyWeapons = view.findViewById(R.id.monsterWeaponTextView)
        enemyWeapons.movementMethod = ScrollingMovementMethod()

        doneButton = view.findViewById(R.id.adventureDoneViewingButton)
        deleteButton = view.findViewById(R.id.deleteAdventureButton)

        activity?.title =  "Adventure"

        doneButton.setOnClickListener{
            view.findNavController().navigate(R.id.AdventureViewerToAdventureRecyclerView)
        }

        deleteButton.setOnClickListener{
            adventureDetailViewModel.deleteAdventure(adventure)
            view.findNavController().navigate(R.id.encounterViewToEncounterRecyclerView)
        }

        return view
    }


    private fun updateUI(){ //TODO
        nameTextView.text = adventure.name
        lengthTextView.text = adventure.length
        typeTextView.text = adventure.questType

        for (i in adventure.encounterNames.indices){

            var encounter = Encounter()
            encounter.encMonsters = adventure.encounterNames[i].split("~~")
            encounter.monsterWeapons = adventure.encounterWeapons[i].split("~~")
            encounters.add(encounter)
        }

        for (i in adventure.townNames.indices){
            var town = Town()
            town.townName = adventure.townNames[i]
            towns.add(town)
        }

        townNames.text = "${towns[0]} \n"
        for(i in 1 until towns.size){
            townNames.text = "${townNames.text}${towns[i]} \n"
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adventureDetailViewModel.adventureLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                    adventure -> adventure?.let {
                this.adventure = adventure
                updateUI()
            }
            }
        )

    }

}
