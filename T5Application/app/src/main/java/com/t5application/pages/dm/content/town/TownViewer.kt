package com.t5application.pages.dm.content.town

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.t5application.R
import com.t5application.dm_classes.Town
import java.util.*

class TownViewer : Fragment() {

    private lateinit var doneViewingTown: Button
    private lateinit var deleteButton: Button

    private lateinit var nameTextView: TextView
    private lateinit var sizeTextView: TextView
    private lateinit var terrainTextView: TextView
    private lateinit var buildingsTextView: TextView
    private lateinit var politicsTextView: TextView
    private lateinit var town: Town

    private val townDetailViewModel: TownDetailViewModel by activityViewModels()

    private val townListViewModel : TownListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        town = Town()
        val townId = townDetailViewModel.idOfNavigation
        println("ID of Town Navigated from: ${townDetailViewModel.idOfNavigation}")
        townDetailViewModel.loadTown(townId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.town_viewer, container, false)

        activity?.title = "Town"
        nameTextView = view.findViewById(R.id.nameTextView) as TextView
        sizeTextView = view.findViewById(R.id.sizeTextView) as TextView
        terrainTextView = view.findViewById(R.id.terrainTextView) as TextView
        buildingsTextView = view.findViewById(R.id.buildingTextView) as TextView
        politicsTextView = view.findViewById(R.id.politicsTextView) as TextView

        doneViewingTown = view.findViewById(R.id.doneTownButton) as Button
        deleteButton = view.findViewById(R.id.townViewDeleteButton) as Button

        activity?.title = "Town Viewer"

        doneViewingTown.setOnClickListener {
            view.findNavController().navigate(R.id.TownViewerToDMRecyclerView)
        }

        deleteButton.setOnClickListener{
            townDetailViewModel.deleteTown(town)
            view.findNavController().navigate(R.id.TownViewerToDMRecyclerView)
        }

        return view;
    }

    private fun updateUI(){
        nameTextView.text = town.townName
        sizeTextView.text = town.townSize
        terrainTextView.text = town.townTerrain
        buildingsTextView.text = town.townBuildings
        politicsTextView.text = town.townPolitics
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        townDetailViewModel.townLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                town -> town?.let {
                this.town = town
                updateUI()
            }
            }
        )
    }

}
