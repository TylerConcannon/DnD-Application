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
import com.t5application.dm_classes.NPC
import com.t5application.dm_classes.Town
import com.t5application.pages.dm.content.npc.NPCDetailViewModel
import com.t5application.pages.dm.content.npc.NPCListViewModel
import com.t5application.pages.dm.content.town.TownDetailViewModel
import com.t5application.pages.dm.content.town.TownListViewModel

class NPCRecyclerView : Fragment() {

    private lateinit var AddContent: ImageView

    private lateinit var npcRecyclerView: RecyclerView
    private var adapter: NPCAdapter? = NPCAdapter(emptyList())

    private val npcListViewModel: NPCListViewModel by activityViewModels()

    private val npcDetailViewModel: NPCDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

                                //CHANGE RECYCLER VIEW LAYOUT XML///////////////////////////////////

        val view = inflater.inflate(R.layout.npc_recycler_view, container, false)

        activity?.title =  "Content List"

        AddContent = view.findViewById(R.id.AddContentButtonNPC)

        AddContent.setOnClickListener {
            view.findNavController().navigate(R.id.NPCRecyclerViewToCreateNPC)
        }

        println("Current town count: ${adapter?.itemCount}")

        npcRecyclerView = view.findViewById(R.id.NPCRecyclerView) as RecyclerView
        npcRecyclerView.layoutManager = LinearLayoutManager(context)
        npcRecyclerView.adapter = adapter

        npcListViewModel.npcListLiveData.observe(
            viewLifecycleOwner,
            Observer { npcs ->
                npcs?.let{
                    updateUI(npcs)
                }
            }
        )
        //updateUI(townListViewModel.towns)
        return view
    }

    private fun updateUI(npcs: List<NPC>){
        npcRecyclerView.adapter = NPCAdapter(npcs)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        npcListViewModel.npcListLiveData.observe(
            viewLifecycleOwner,
            Observer { npcs ->
                npcs?.let {
                    Log.i("NPCRECVIEW", "Got all towns")
                    println("NPC at first index: ${npcListViewModel.npcListLiveData.value.toString()}")
                    updateUI(npcs)
                }
            }
        )
    }

    private inner class NPCHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener{
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextViewNPC)
        private val raceTextView: TextView = itemView.findViewById(R.id.raceTextViewNPC)
        private val occupationTextView: TextView = itemView.findViewById(R.id.raceTextViewNPC)
        private lateinit var npc: NPC

        init{
            itemView.setOnClickListener(this)
        }

        fun bind(npc: NPC){
            this.npc = npc
            nameTextView.text = this.npc.npcName
            raceTextView.text = this.npc.npcRace
            occupationTextView.text = this.npc.npcOccupation
        }

        override fun onClick(v: View?) {
            npcDetailViewModel.idOfNavigation = npc.id
                                                // ADD NPC RECYCLER VIEW -> NPC VIEW ////////////////
            v?.findNavController()?.navigate(R.id.NPCRecyclerViewToNPCViewer)
        }
    }

    private inner class NPCAdapter(var npcs: List<NPC>) : RecyclerView.Adapter<NPCHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NPCHolder {
            val view = layoutInflater.inflate(R.layout.npc_list_view, parent, false)
            return NPCHolder(view)
        }

        override fun getItemCount(): Int {
            return npcs.size
        }

        override fun onBindViewHolder(holder: NPCHolder, position: Int) {
            val npc = npcs[position]
            holder.bind(npc)
        }
    }

    companion object{
        fun newInstance(): NPCRecyclerView {
            return NPCRecyclerView()
        }
    }

}
