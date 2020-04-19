package com.t5application.pages.dm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.*
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.t5application.R
import com.t5application.dm_classes.Town
import com.t5application.pages.dm.content.town.TownListViewModel

class DMRecyclerView : Fragment() {

    private lateinit var AddContent: ImageView
    private lateinit var townRecyclerView: RecyclerView
    private var adapter: TownAdapter? = TownAdapter(emptyList())
    private val townListViewModel: TownListViewModel by lazy {
        ViewModelProviders.of(this).get(TownListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.dm_recycler_view, container, false)

        activity?.title =  "Content List"

        AddContent = view.findViewById(R.id.AddContentButton)

        AddContent.setOnClickListener {
            view.findNavController().navigate(R.id.DMRecyclerViewToCreateContent)
        }
        townRecyclerView = view.findViewById(R.id.DMRecyclerView)
        townRecyclerView.layoutManager = LinearLayoutManager(context)
        townRecyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        townListViewModel.townListLiveData.observe(
            viewLifecycleOwner,
            Observer { towns ->
                towns?.let {
                    Log.i("DMRECVIEW", "Got all towns")
                    townRecyclerView.adapter = TownAdapter(towns)
                }
            }
        )
    }

    private inner class TownHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener{
        private val nameEditText: EditText = itemView.findViewById(R.id.nameTextBox)
        private lateinit var town: Town

        init{
            itemView.setOnClickListener(this)
        }

        fun bind(town: Town){
            this.town = town
            nameEditText.setText(this.town.townName)
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    private inner class TownAdapter(var towns: List<Town>) : RecyclerView.Adapter<TownHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TownHolder {
            val view = layoutInflater.inflate(R.id.DMRecyclerView, parent, false)
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
        fun newInstance(): DMRecyclerView{
            return DMRecyclerView()
        }
    }

}
