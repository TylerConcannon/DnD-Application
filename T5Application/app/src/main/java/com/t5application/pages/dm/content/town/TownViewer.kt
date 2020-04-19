package com.t5application.pages.dm.content.town

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

import com.t5application.R

class TownViewer : Fragment() {

    private lateinit var doneViewingTown: Button

    private lateinit var nameTextView: TextView
    private lateinit var sizeTextView: TextView
    private lateinit var terrainTextView: TextView
    private lateinit var buildingsTextView: TextView
    private lateinit var politicsTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.town_viewer, container, false)

        nameTextView = view.findViewById(R.id.nameTextView)
        sizeTextView = view.findViewById(R.id.sizeTextView)
        terrainTextView = view.findViewById(R.id.terrainTextView)
        buildingsTextView = view.findViewById(R.id.buildingTextView)
        politicsTextView = view.findViewById(R.id.politicsTextView)

        doneViewingTown = view.findViewById(R.id.doneTownButton)

        activity?.title = "Town Viewer"

        doneViewingTown.setOnClickListener {
            view.findNavController().navigate(R.id.TownViewerToDMRecyclerView)
        }

        return view;
    }
}
