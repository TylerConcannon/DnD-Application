package com.t5application.pages.dm.content.npc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.t5application.R
import com.t5application.dm_classes.NPC

class NPCViewer : Fragment() {

    private lateinit var doneViewingNPC: Button
    private lateinit var deleteButton: Button

    private lateinit var nameTextView: TextView
    private lateinit var raceTextView: TextView
    private lateinit var occupationTextView: TextView
    private lateinit var npc: NPC

    private val npcDetailViewModel: NPCDetailViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        npc = NPC()
        val npcID = npcDetailViewModel.idOfNavigation
        npcDetailViewModel.loadNPC(npcID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.npc_viewer, container, false)

        nameTextView = view.findViewById(R.id.nameTextViewNPC) as TextView
        raceTextView = view.findViewById(R.id.raceTextViewNPC) as TextView
        occupationTextView = view.findViewById(R.id.occupationTextViewNPC) as TextView

        doneViewingNPC = view.findViewById(R.id.doneNPCButton) as Button
        deleteButton = view.findViewById(R.id.npcViewDeleteButton) as Button

        activity?.title =  "NPC"

        doneViewingNPC.setOnClickListener {
            view.findNavController().navigate(R.id.NPCViewerToNPCRecyclerView)
        }

        deleteButton.setOnClickListener{
            npcDetailViewModel.deleteNPC(npc)
            view.findNavController().navigate(R.id.NPCViewerToNPCRecyclerView)
        }

        return view;
    }

    private fun updateUI(){

        nameTextView.text = npc.npcName
        raceTextView.text = npc.npcRace
        occupationTextView.text = npc.npcOccupation


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        npcDetailViewModel.npcLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                npc -> npc?.let {
                this.npc = npc
                updateUI()
            }
            }
        )

    }
}
