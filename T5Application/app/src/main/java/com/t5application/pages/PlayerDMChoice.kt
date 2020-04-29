package com.t5application.pages

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.t5application.R

class PlayerDMChoice : Fragment() {

    private lateinit var PlayerButton: Button
    private lateinit var DMButton: Button
    private lateinit var musicOffImage: ImageView
    private lateinit var musicOnImage: ImageView
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
        mediaPlayer = MediaPlayer.create(context, R.raw.sound_file)
        musicOffImage = view.findViewById(R.id.musicMuteImage)
        musicOnImage = view.findViewById(R.id.musicPlayImage)
        mediaPlayer.isLooping = true
        playing = false

        PlayerButton.setOnClickListener {
            view.findNavController().navigate(R.id.PlayerDMChoiceToPlayerRecyclerView)
        }

        DMButton.setOnClickListener {
            view.findNavController().navigate(R.id.playerDMChoiceToSelectRecyclerView)
        }

        musicOnImage.setOnClickListener {
            playing = true
            mediaPlayer.start()
            musicOffImage.isVisible = true
            musicOnImage.isVisible = false
        }


        musicOffImage.setOnClickListener {
            playing = false
            mediaPlayer.pause()
            musicOffImage.isVisible = false
            musicOnImage.isVisible = true
        }

        return view
        }
    }
