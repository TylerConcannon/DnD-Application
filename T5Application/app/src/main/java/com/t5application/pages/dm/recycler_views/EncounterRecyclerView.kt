package com.t5application.pages.dm.recycler_views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.t5application.R
import com.t5application.dm_classes.Encounter
import com.t5application.pages.dm.content.encounter.EncounterDetailViewModel
import com.t5application.pages.dm.content.encounter.EncounterListViewModel

class EncounterRecyclerView : Fragment() {

    private lateinit var AddContent: ImageView

    private lateinit var encounterRecyclerView: RecyclerView
    private var adapter: EncounterAdapter? = EncounterAdapter(emptyList())

    private val encounterListViewModel: EncounterListViewModel by activityViewModels()

    private val encounterDetailViewModel: EncounterDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //CHANGE RECYCLER VIEW LAYOUT XML///////////////////////////////////

        val view = inflater.inflate(R.layout.encounter_recycler_view, container, false)

        activity?.title =  "Content List"

        AddContent = view.findViewById(R.id.AddContentButtonENC)

        AddContent.setOnClickListener {
            view.findNavController().navigate(R.id.EncounterRecyclerViewToCreateEncounter)
        }

        println("Current town count: ${adapter?.itemCount}")

        encounterRecyclerView = view.findViewById(R.id.EncounterRecyclerView) as RecyclerView
        encounterRecyclerView.layoutManager = LinearLayoutManager(context)
        encounterRecyclerView.adapter = adapter

        encounterListViewModel.encounterListLiveData.observe(
            viewLifecycleOwner,
            Observer { encs ->
                encs?.let{
                    updateUI(encs)
                }
            }
        )
        //updateUI(townListViewModel.towns)
        return view
    }

    private fun updateUI(encs: List<Encounter>){
        encounterRecyclerView.adapter = EncounterAdapter(encs)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        encounterListViewModel.encounterListLiveData.observe(
            viewLifecycleOwner,
            Observer { encs ->
                encs?.let {
                    Log.i("ENCRECVIEW", "Got all encounters")
                    println("NPC at first index: ${encounterListViewModel.encounterListLiveData.value.toString()}")
                    updateUI(encs)
                }
            }
        )
    }

    private inner class EncounterHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener{
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextViewENC)
        private val combatRatingTextView: TextView = itemView.findViewById(R.id.combatRatingTextView)
        private val monsterNumberTextView: TextView = itemView.findViewById(R.id.monsterNumberTextView)
        private val monstersTextView: TextView = itemView.findViewById(R.id.monstersTextView)
        private lateinit var encounter: Encounter

        init{
            itemView.setOnClickListener(this)
        }

        fun bind(encounter: Encounter){
            this.encounter = encounter
            nameTextView.text = this.encounter.encName
            combatRatingTextView.text = this.encounter.encCR.toString()
            monsterNumberTextView.text = this.encounter.encMonsterNumber.toString()
            monstersTextView.text = this.encounter.encMonsters[0]
        }

        override fun onClick(v: View?) {
            encounterDetailViewModel.idOfNavigation = encounter.id
                                    // ADD NPC RECYCLER VIEW -> NPC VIEW ////////////////
            v?.findNavController()?.navigate(R.id.EncounterRecyclerViewToEncounterView)
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

    companion object{
        fun newInstance(): EncounterRecyclerView {
            return EncounterRecyclerView()
        }
    }

}
