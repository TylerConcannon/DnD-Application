package com.t5application.pages.player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.t5application.R
import com.t5application.character_classes.Character
import kotlinx.android.synthetic.main.character_sheet.*

class CharacterSheet : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var levelTextView: TextView
    private lateinit var classTextView: TextView
    private lateinit var raceTextView: TextView

    private lateinit var strNumTextView: TextView
    private lateinit var dexNumTextView: TextView
    private lateinit var constNumTextView: TextView
    private lateinit var intNumTextView: TextView
    private lateinit var wisNumTextView: TextView
    private lateinit var charNumTextView: TextView

    private lateinit var strModTextView: TextView
    private lateinit var dexModTextView: TextView
    private lateinit var constModTextView: TextView
    private lateinit var intModTextView: TextView
    private lateinit var wisModTextView: TextView
    private lateinit var charModTextView: TextView

    private lateinit var profListTextView: TextView
    private lateinit var weaponsListTextView: TextView
    private lateinit var featsListTextView: TextView

    private lateinit var character: Character

    private val characterDetailViewModel: CharacterDetailViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        character = Character()
        val charID = characterDetailViewModel.idOfNavigation
        characterDetailViewModel.loadCharacter(charID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.character_sheet, container, false)

        nameTextView = view.findViewById(R.id.nameTextView)
        levelTextView = view.findViewById(R.id.levelTextView)
        classTextView = view.findViewById(R.id.classTextView)
        raceTextView = view.findViewById(R.id.raceTextView)

        strNumTextView = view.findViewById(R.id.strNum)
        dexNumTextView = view.findViewById(R.id.dexNum)
        constNumTextView = view.findViewById(R.id.conNum)
        intNumTextView = view.findViewById(R.id.intNum)
        wisNumTextView = view.findViewById(R.id.wisNum)
        charNumTextView = view.findViewById(R.id.chaNum)

        strModTextView = view.findViewById(R.id.strMod)
        dexModTextView = view.findViewById(R.id.dexMod)
        constModTextView = view.findViewById(R.id.conMod)
        intModTextView = view.findViewById(R.id.intMod)
        wisModTextView = view.findViewById(R.id.wisMod)
        charModTextView = view.findViewById(R.id.chaMod)

        profListTextView = view.findViewById(R.id.profList)
        weaponsListTextView = view.findViewById(R.id.weaList)
        featsListTextView = view.findViewById(R.id.featList)

        activity?.title =  "Character Sheet"

        return view
    }

    private fun updateUI(){

        nameTextView.text = character.name
        levelTextView.text = character.level.toString()
        classTextView.text = character._class.toString()
        raceTextView.text = character.race.toString()

        strNumTextView.text = character.strAS.toString()
        dexNumTextView.text = character.dexAS.toString()
        constNumTextView.text = character.constAS.toString()
        intNumTextView.text = character.intAS.toString()
        wisNumTextView.text = character.wisAS.toString()
        charNumTextView.text = character.charAS.toString()

        if(character.strAS > 11){
            strModTextView.text = "+${character.strength.toString()}"
        }
        else {
            strModTextView.text = character.strength.toString()
        }

        if(character.dexAS > 11){
            dexModTextView.text = "+${character.dexterity.toString()}"
        }
        else {
            dexModTextView.text = character.dexterity.toString()
        }

        if(character.constAS > 11){
            constModTextView.text = "+${character.constitution.toString()}"
        }
        else {
            constModTextView.text = character.constitution.toString()
        }

        if(character.intAS > 11){
            intModTextView.text = "+${character.intelligence.toString()}"
        }
        else {
            intModTextView.text = character.intelligence.toString()
        }

        if(character.wisAS > 11){
            wisModTextView.text = "+${character.wisdom.toString()}"
        }
        else {
            wisModTextView.text = character.wisdom.toString()
        }

        if(character.charAS > 11){
            charModTextView.text = "+${character.charisma.toString()}"
        }
        else {
            charModTextView.text = character.charisma.toString()
        }

        profListTextView.text = "${character._class.proficiencies[0]} \n"
        for(i in 1 until character._class.proficiencies.size){
            profListTextView.text = "${profListTextView.text}${character._class.proficiencies[i]} \n"
        }

        weaponsListTextView.text = "${character.attacks[0]} \n"
        for(i in 1 until character.attacks.size){
            weaponsListTextView.text = "${weaponsListTextView.text}${character.attacks[i]} \n"
        }

        /*featsListTextView.text = "${character.race.features[0][0] + character.race.features[0][1]} \n"
        for(i in 1 until character.race.features.size){
            featsListTextView.text = "${featsListTextView.text}${character.race.features[i][0] + character.race.features[i][1]} \n"
        }*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterDetailViewModel.characterLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                character -> character?.let {
                this.character = character
                updateUI()
            }
            }
        )
    }

}
