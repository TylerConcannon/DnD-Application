package com.t5application.pages.dm.recycler_views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.t5application.R
import com.t5application.dm_classes.Adventure
import com.t5application.pages.dm.content.adventure.AdventureDetailViewModel
import com.t5application.pages.dm.content.adventure.AdventureListViewModel

/**
 * A simple [Fragment] subclass.
 */
class AdventureRecyclerView : Fragment() {

    private lateinit var AddContent: ImageView

    private lateinit var adventureRecyclerView: RecyclerView
    private var adapter: AdventureAdapter? = AdventureAdapter(emptyList())

    private val adventureListViewModel: AdventureListViewModel by activityViewModels()
    private val adventureDetailViewModel: AdventureDetailViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.adventure_recycler_view, container, false)

        activity?.title = "Encounter List"

        AddContent = view.findViewById(R.id.AddContentButtonADV)

        AddContent.setOnClickListener{
            view.findNavController().navigate(R.id.AdventureRecyclerViewToCreateAdventure)
        }

        adventureRecyclerView = view.findViewById(R.id.AdventureRecyclerView) as RecyclerView
        adventureRecyclerView.layoutManager = LinearLayoutManager(context)
        adventureRecyclerView.adapter = adapter

        adventureListViewModel.adventureListLiveData.observe(
            viewLifecycleOwner,
            Observer { advs ->
                advs?.let {
                    updateUI(advs)
                }
            }
        )


        return view
    }

    private fun updateUI(adventures: List<Adventure>){
        adventureRecyclerView.adapter = AdventureAdapter(adventures)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adventureListViewModel.adventureListLiveData.observe(
            viewLifecycleOwner,
            Observer { advs ->
                advs?.let {
                    Log.i("ADVRECVIEW", "Got all adventures")
                    updateUI(advs)
                }
            }
        )
    }

    private inner class AdventureHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        private val nameTextView: TextView = itemView.findViewById(R.id.adventureNameTextView)
        private val lengthTextView: TextView = itemView.findViewById(R.id.lengthTextView)
        private val typeTextView: TextView = itemView.findViewById(R.id.typeTextView)
        private val encTextView: TextView = itemView.findViewById(R.id.encounterNumberTextView)

        private lateinit var adventure: Adventure

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(adventure: Adventure){
            this.adventure = adventure
            nameTextView.text = adventure.name
            lengthTextView.text = adventure.length
            typeTextView.text = adventure.questType
            encTextView.text = (adventure.encounterNames.size - 1).toString()
        }

        override fun onClick(v: View?) {
            adventureDetailViewModel.idOfNavigation = adventure.id
            v?.findNavController()?.navigate(R.id.AdventureRecyclerViewToAdventureViewer)
        }
    }

    private inner class AdventureAdapter(var adventures: List<Adventure>): RecyclerView.Adapter<AdventureHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdventureHolder {
            val view = layoutInflater.inflate(R.layout.adventure_list_view, parent, false)
            return AdventureHolder(view)
        }

        override fun getItemCount(): Int {
            return adventures.size
        }

        override fun onBindViewHolder(holder: AdventureHolder, position: Int) {
            val adventure = adventures[position]
            holder.bind(adventure)
        }

    }

    companion object{
        fun newInstance(): AdventureRecyclerView{
            return AdventureRecyclerView()
        }
    }

}
