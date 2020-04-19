package com.t5application.pages.dm.content.town

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.t5application.R
import com.t5application.dm_classes.Town
import kotlin.math.floor

class CreateTown : Fragment() {

    //Buttons
    private lateinit var generate: Button

    //Spinners
    private lateinit var nameEditText: EditText
    private lateinit var sizeSpinner: Spinner
    private lateinit var terrainSpinner: Spinner
    private lateinit var buildingSpinner: Spinner
    private lateinit var politicsSpinner: Spinner
    private lateinit var town: Town

    private val townDetailViewModel: TownDetailViewModel by lazy {
        ViewModelProviders.of(this).get(TownDetailViewModel::class.java)
    }

    private val townListViewModel : TownListViewModel by lazy {
        ViewModelProviders.of(this).get(TownListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        town = Town()
        val townId : Int = (Math.random()*1000000).toInt()
        townDetailViewModel.loadTown(townId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.create_town, container, false)

        activity?.title =  "Create Town"

        nameEditText = view.findViewById(R.id.nameTextBox)
        sizeSpinner = view.findViewById(R.id.sizeSpinner)
        terrainSpinner = view.findViewById(R.id.terrainSpinner)
        buildingSpinner = view.findViewById(R.id.buildingSpinner)
        politicsSpinner = view.findViewById(R.id.politicsSpinner)

        val sizes = resources.getStringArray(R.array.townSizes)
        sizeSpinner(sizes)

        val terrains = resources.getStringArray(R.array.terrains)
        terrainSpinner(terrains)

        val buildings = resources.getStringArray(R.array.buildings)
        buildingSpinner(buildings)

        val politics = resources.getStringArray(R.array.politics)
        politicsSpinner(politics)

        generate = view.findViewById(R.id.confirmTownButton)

        generate.setOnClickListener {
            town.townName = nameEditText.text.toString()
            town.townSize = sizes[sizeSpinner.selectedItemPosition]
            town.townTerrain = terrains[terrainSpinner.selectedItemPosition]
            town.townBuildings = buildings[buildingSpinner.selectedItemPosition]
            town.townPolitics = politics[politicsSpinner.selectedItemPosition]
            townDetailViewModel.saveTown(town)
            view.findNavController().navigate(R.id.CreateTownToTownViewer)
        }

        return view
    }

    private fun sizeSpinner(sizes: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, sizes)

        sizeSpinner.adapter = adapter
    }

    private fun terrainSpinner(terrains: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, terrains)

        terrainSpinner.adapter = adapter
    }

    private fun buildingSpinner(buildings: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, buildings)

        buildingSpinner.adapter = adapter
    }

    private fun politicsSpinner(politics: Array<String>){
        val adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_selectable_list_item, politics)

        politicsSpinner.adapter = adapter
    }

}
