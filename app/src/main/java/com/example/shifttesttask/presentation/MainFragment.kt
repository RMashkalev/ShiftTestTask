package com.example.shifttesttask.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shifttesttask.R
import com.example.shifttesttask.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var fragmentBinding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentMainBinding.inflate(layoutInflater)

        fragmentBinding.backButton.setOnClickListener {
            fragmentBinding.root.findNavController().navigate(R.id.action_mainFragment_to_startFragment)
        }

        return fragmentBinding.root
    }


}