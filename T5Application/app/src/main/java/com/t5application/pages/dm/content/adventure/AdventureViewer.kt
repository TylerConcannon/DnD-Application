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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    private lateinit var encounterRecyclerView: RecyclerView

    private lateinit var adventure: Adventure

    private var encounters: ArrayList<Encounter> = ArrayList()
    private var towns: ArrayList<Town> = ArrayList()

    private var adapter: EncounterAdapter? = EncounterAdapter(emptyList())

    private val adventureDetailViewModel: AdventureDetailViewModel by activityViewModels()
    private val adventureListViewModel: AdventureListViewModel by activityViewModels()

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

        encounterRecyclerView = view.findViewById(R.id.encounterRecyclerViewADV)
        encounterRecyclerView.layoutManager = LinearLayoutManager(context)
        encounterRecyclerView.adapter = adapter

        activity?.title =  "Adventure"

        encounterRecyclerView.adapter = EncounterAdapter(encounters)

        doneButton.setOnClickListener{
            view.findNavController().navigate(R.id.AdventureViewerToAdventureRecyclerView)
        }

        deleteButton.setOnClickListener{
            adventureDetailViewModel.deleteAdventure(adventure)
            view.findNavController().navigate(R.id.AdventureViewerToAdventureRecyclerView)
        }

        return view
    }


    private fun updateUI(){
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

        townNames.text = "${towns[0].townName} \n"
        for(i in 1 until towns.size){
            townNames.text = "${townNames.text}${towns[i].townName} \n"
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
                encounterRecyclerView.adapter = EncounterAdapter(encounters)
            }
            }
        )

    }

    private inner class EncounterHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        private val combatRatingTextView: TextView = itemView.findViewById(R.id.combatRatingTextView)
        private val monsterNumberTextView: TextView = itemView.findViewById(R.id.monsterNumberTextView)
        private val monstersTextView: TextView = itemView.findViewById(R.id.monstersTextView)
        private lateinit var encounter: Encounter

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(encounter: Encounter){
            this.encounter = encounter
            combatRatingTextView.text = ""
            monsterNumberTextView.text = ""
            monstersTextView.text = this.encounter.encMonsters[0]
        }

        override fun onClick(v: View?) {
            enemyList.text = "${encounter.encMonsters[0]} \n"
            for(i in 1 until encounter.encMonsters.size){
                enemyList.text = "${enemyList.text}${encounter.encMonsters[i]} \n"
            }
            enemyWeapons.text = "${encounter.monsterWeapons[0]} \n"
            for(i in 1 until encounter.monsterWeapons.size){
                enemyWeapons.text = "${enemyWeapons.text}${encounter.monsterWeapons[i]} \n"
            }
        }
    }

    private inner class EncounterAdapter(var encs: List<Encounter>) : RecyclerView.Adapter<EncounterHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EncounterHolder {
            val view = layoutInflater.inflate(R.layout.encounter_list_view, parent, false)
            return EncounterHolder(view)
        }

        override fun getItemCount(): Int {
            return encs.size
        }

        override fun onBindViewHolder(holder: EncounterHolder, position: Int) {
            val enc = encs[position]
            holder.bind(enc)
        }
    }

}
