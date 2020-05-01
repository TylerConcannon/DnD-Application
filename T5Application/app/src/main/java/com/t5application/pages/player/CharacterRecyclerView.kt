package com.t5application.pages.player

import android.os.Bundle
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
import com.t5application.character_classes.Character

class CharacterRecyclerView : Fragment() {

    private lateinit var AddCharacter: ImageView

    private lateinit var characterRecyclerView: RecyclerView
    private var adapter: CharacterAdapter? = CharacterAdapter(emptyList())

    private val characterListViewModel: CharacterListViewModel by activityViewModels()
    private val characterDetailViewModel: CharacterDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.character_recycler_view, container, false)

        activity?.title =  "Character List"

        AddCharacter = view.findViewById(R.id.AddCharacterButton)

        AddCharacter.setOnClickListener {
            view.findNavController().navigate(R.id.CharacterRecyclerViewToCreateCharacter)
        }

        characterRecyclerView = view.findViewById(R.id.CharacterRecyclerView)
        characterRecyclerView.layoutManager = LinearLayoutManager(context)
        characterRecyclerView.adapter = adapter

        characterListViewModel.characterListLiveData.observe(
            viewLifecycleOwner,
            Observer { chars ->
                chars?.let {
                    updateUI(chars)
                }
            }
        )

        return view
    }

    private fun updateUI(chars: List<Character>){
        characterRecyclerView.adapter = CharacterAdapter(chars)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterListViewModel.characterListLiveData.observe(
            viewLifecycleOwner,
            Observer { chars ->
                chars?.let {
                    updateUI(chars)
                }
            }
        )
    }

    private inner class CharacterHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextViewCharacter)
        private val classTextView: TextView = itemView.findViewById(R.id.classTextViewCharacter)
        private val raceTextView: TextView = itemView.findViewById(R.id.raceTextViewCharacter)
        private val backgroundTextView: TextView = itemView.findViewById(R.id.backgroundTextViewCharacter)
        private val levelTextView: TextView = itemView.findViewById(R.id.levelTextViewCharacter)
        private lateinit var character: Character

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(character: Character){
            this.character = character
            nameTextView.text = character.name
            classTextView.text = character._class.toString()
            raceTextView.text = character.race.toString()
            backgroundTextView.text = character.background.toString()
            levelTextView.text = character.level.toString()

        }

        override fun onClick(v: View?) {
            characterDetailViewModel.idOfNavigation = character.id
            v?.findNavController()?.navigate(R.id.characterRecyclerViewToCharacterSheet)
        }
    }

    private inner class CharacterAdapter(var chars: List<Character>) : RecyclerView.Adapter<CharacterHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
            val view = layoutInflater.inflate(R.layout.character_list_view, parent, false)
            return CharacterHolder(view)
        }

        override fun getItemCount(): Int {
            return chars.size
        }

        override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
            val char = chars[position]
            holder.bind(char)
        }
    }

}
