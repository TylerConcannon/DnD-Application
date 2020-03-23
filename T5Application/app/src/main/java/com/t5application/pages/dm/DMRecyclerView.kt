package com.t5application.pages.dm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import com.t5application.R

class DMRecyclerView : Fragment() {

    private lateinit var AddContent: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.dm_recycler_view, container, false)

        AddContent = view.findViewById(R.id.AddContentButton)

        AddContent.setOnClickListener {
            view.findNavController().navigate(R.id.DMRecyclerViewToCreateContent)
        }

        return view
    }

}
