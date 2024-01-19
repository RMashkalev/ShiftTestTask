package com.example.shifttesttask.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shifttesttask.R
import com.example.shifttesttask.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var fragmentBinding : FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentStartBinding.inflate(layoutInflater)

        fragmentBinding.applyButton.setOnClickListener {
            fragmentBinding.root.findNavController().navigate(R.id.action_startFragment_to_mainFragment)
        }

        return fragmentBinding.root
    }
}