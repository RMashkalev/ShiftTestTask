package com.example.shifttesttask.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shifttesttask.R
import com.example.shifttesttask.common.GreetingDialogFragment
import com.example.shifttesttask.databinding.FragmentMainBinding
import com.example.shifttesttask.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var fragmentBinding : FragmentMainBinding

    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentMainBinding.inflate(layoutInflater)

        fragmentBinding.greetingButton.setOnClickListener {
            val userGreetingData = vm.loadGreetingUserData()
            val myDialogFragment = GreetingDialogFragment(userGreetingData = userGreetingData)
            val manager = parentFragmentManager
            myDialogFragment.show(manager, "greeting")
        }

        fragmentBinding.backButton.setOnClickListener {
            fragmentBinding.root.findNavController().navigate(R.id.action_mainFragment_to_startFragment)
        }

        return fragmentBinding.root
    }


}