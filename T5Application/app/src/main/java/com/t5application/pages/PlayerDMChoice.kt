package com.t5application.pages

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.t5application.R
import kotlinx.android.synthetic.main.player_dm_choice.*

class PlayerDMChoice : Fragment() {

    private lateinit var PlayerButton: Button
    private lateinit var DMButton: Button
    private lateinit var MusicButton: Button
    private lateinit var mediaPlayer: MediaPlayer
    private var playing: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.player_dm_choice, container, false)

        activity?.title =  "Main Menu"

        PlayerButton = view.findViewById(R.id.PlayerButton)
        DMButton = view.findViewById(R.id.DMButton)
        MusicButton = view.findViewById(R.id.playMusicButton)
        mediaPlayer = MediaPlayer.create(context, R.raw.sound_file)
        mediaPlayer.isLooping = true
        playing = false

        PlayerButton.setOnClickListener {
            view.findNavController().navigate(R.id.PlayerDMChoiceToPlayerRecyclerView)
        }

        DMButton.setOnClickListener {
            view.findNavController().navigate(R.id.playerDMChoiceToSelectRecyclerView)
        }

        MusicButton.setOnClickListener{


            mediaPlayer?.isPlaying
            playing = if(!playing){
                mediaPlayer?.start()
                true
            } else {
                mediaPlayer?.pause()
                false
            }
        }

        return view
        }
    }
