package com.example.shifttesttask.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shifttesttask.R
import com.example.shifttesttask.databinding.FragmentStartBinding
import com.example.shifttesttask.domain.models.UserDataModel
import com.example.shifttesttask.viewmodels.RegistrationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartFragment : Fragment() {

    private lateinit var fragmentBinding : FragmentStartBinding

    private val vm: RegistrationViewModel by viewModel<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentStartBinding.inflate(layoutInflater, container, false)

        fragmentBinding.applyButton.setOnClickListener {
            val userData = UserDataModel(
                userName = fragmentBinding.inputName.text.toString(),
                userSurname = fragmentBinding.inputSurname.text.toString(),
                userPassword = fragmentBinding.inputFirstPassword.text.toString())
            vm.saveUserData(userData)

            fragmentBinding.root.findNavController().navigate(R.id.action_startFragment_to_mainFragment)
        }

        return fragmentBinding.root
    }
}