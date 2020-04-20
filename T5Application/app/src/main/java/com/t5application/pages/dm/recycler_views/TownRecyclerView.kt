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
import com.t5application.dm_classes.Town
import com.t5application.pages.dm.content.town.TownDetailViewModel
import com.t5application.pages.dm.content.town.TownListViewModel

class TownRecyclerView : Fragment() {

    private lateinit var AddContent: ImageView

    private lateinit var townRecyclerView: RecyclerView
    private var adapter: TownAdapter? = TownAdapter(emptyList())

    private val townListViewModel: TownListViewModel by activityViewModels()

    private val townDetailViewModel: TownDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.town_recycler_view, container, false)

        activity?.title =  "Content List"

        AddContent = view.findViewById(R.id.AddContentButton)

        AddContent.setOnClickListener {
            view.findNavController().navigate(R.id.DMRecyclerViewToCreateContent)
        }

        println("Current town count: ${adapter?.itemCount}")

        townRecyclerView = view.findViewById(R.id.TownRecyclerView) as RecyclerView
        townRecyclerView.layoutManager = LinearLayoutManager(context)
        townRecyclerView.adapter = adapter

        townListViewModel.townListLiveData.observe(
            viewLifecycleOwner,
            Observer { towns ->
                towns?.let{
                    updateUI(towns)
                }
            }
        )
        //updateUI(townListViewModel.towns)
        return view
    }

    private fun updateUI(towns: List<Town>){
        townRecyclerView.adapter = TownAdapter(towns)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        townListViewModel.townListLiveData.observe(
            viewLifecycleOwner,
            Observer { towns ->
                towns?.let {
                    Log.i("DMRECVIEW", "Got all towns")
                    println("Town at first index: ${townListViewModel.townListLiveData.value.toString()}")
                    updateUI(towns)
                }
            }
        )
    }

    private inner class TownHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener{
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val sizeTextView: TextView = itemView.findViewById(R.id.sizeTextView)
        private val terrainTextView: TextView = itemView.findViewById(R.id.terrainTextView)
        private val politicsTextView: TextView = itemView.findViewById(R.id.politicsTextView)
        private lateinit var town: Town

        init{
            itemView.setOnClickListener(this)
        }

        fun bind(town: Town){
            this.town = town
            nameTextView.text = this.town.townName
            sizeTextView.text = this.town.townSize
            terrainTextView.text = this.town.townTerrain
            politicsTextView.text = this.town.townPolitics
        }

        override fun onClick(v: View?) {
            townDetailViewModel.idOfNavigation = town.id
            v?.findNavController()?.navigate(R.id.TownRecyclerViewToTownView)
        }
    }

    private inner class TownAdapter(var towns: List<Town>) : RecyclerView.Adapter<TownHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TownHolder {
            val view = layoutInflater.inflate(R.layout.town_list_view, parent, false)
            return TownHolder(view)
        }

        override fun getItemCount(): Int {
            return towns.size
        }

        override fun onBindViewHolder(holder: TownHolder, position: Int) {
            val town = towns[position]
            holder.bind(town)
        }
    }

    companion object{
        fun newInstance(): TownRecyclerView {
            return TownRecyclerView()
        }
    }

}
