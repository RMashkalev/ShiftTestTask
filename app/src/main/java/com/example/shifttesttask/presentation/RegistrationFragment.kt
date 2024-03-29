package com.example.shifttesttask.presentation

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.shifttesttask.R
import com.example.shifttesttask.databinding.FragmentRegistrationBinding
import com.example.shifttesttask.domain.models.UserDataModel
import com.example.shifttesttask.domain.usecase.NAME_CHECK
import com.example.shifttesttask.domain.usecase.PASSWORD_CHECK
import com.example.shifttesttask.domain.usecase.SECOND_PASSWORD_CHECK
import com.example.shifttesttask.domain.usecase.SURNAME_CHECK
import com.example.shifttesttask.viewmodels.RegistrationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Locale

class RegistrationFragment : Fragment() {

    private lateinit var fragmentBinding: FragmentRegistrationBinding
    private val vm: RegistrationViewModel by viewModel<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)

        vm.checkRememberUserData()
        vm.dataSaved.observe(viewLifecycleOwner) { dataSaved ->
            if (dataSaved) {
                val navController = NavHostFragment.findNavController(this)
                navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }

        setListener(editText = fragmentBinding.inputName, NAME_CHECK)
        setListener(editText = fragmentBinding.inputSurname, SURNAME_CHECK)
        setListener(editText = fragmentBinding.inputFirstPassword, PASSWORD_CHECK)
        setListener(editText = fragmentBinding.inputSecondPassword, SECOND_PASSWORD_CHECK)

        vm.nameInputStatus.observe(viewLifecycleOwner) {
            setInputStatus(fragmentBinding.inputName, it)
        }
        vm.surnameInputStatus.observe(viewLifecycleOwner) {
            setInputStatus(fragmentBinding.inputSurname, it)
        }
        vm.passwordInputStatus.observe(viewLifecycleOwner) {
            setInputStatus(fragmentBinding.inputFirstPassword, it)
        }
        vm.secondPasswordInputStatus.observe(viewLifecycleOwner) {
            setInputStatus(fragmentBinding.inputSecondPassword, it)
        }
        vm.birthdayInputStatus.observe(viewLifecycleOwner) {
            setInputStatus(fragmentBinding.inputBirthday, it)
        }


        vm.nameErrorMessage.observe(viewLifecycleOwner) {
            if (it) {
                fragmentBinding.nameErrorMessage.text = ""
            } else {
                fragmentBinding.nameErrorMessage.text = getString(R.string.nameErrorMessage)
            }
        }
        vm.surnameErrorMessage.observe(viewLifecycleOwner) {
            if (it) {
                fragmentBinding.surnameErrorMessage.text = ""
            } else {
                fragmentBinding.surnameErrorMessage.text = getString(R.string.nameErrorMessage)
            }
        }
        vm.passwordErrorMessage.observe(viewLifecycleOwner) {
            if (it) {
                fragmentBinding.firstPasswordErrorMessage.text = ""
            } else {
                fragmentBinding.firstPasswordErrorMessage.text =
                    getString(R.string.firstPasswordErrorMessage)
            }
        }
        vm.secondPasswordErrorMessage.observe(viewLifecycleOwner) {
            if (it) {
                fragmentBinding.secondPasswordErrorMessage.text = ""
            } else {
                fragmentBinding.secondPasswordErrorMessage.text =
                    getString(R.string.secondPasswordErrorMessage)
            }
        }
        vm.birthdayErrorMessage.observe(viewLifecycleOwner) {
            if (it) {
                fragmentBinding.birthdayErrorMessage.text = ""
            } else {
                fragmentBinding.birthdayErrorMessage.text =
                    getString(R.string.birthdayErrorMessage)
            }
        }

        fragmentBinding.inputBirthday.setOnClickListener {
            showDatePickerDialog()
        }

        vm.userBirthday.observe(viewLifecycleOwner) {
            fragmentBinding.inputBirthday.setText(it)
            if (it != "")
                vm.checkBirthday(birthday = it)
        }

        fragmentBinding.applyButton.setOnClickListener {
            vm.resultCheck()
            vm.allChecksPassed.observe(viewLifecycleOwner) { allChecksPassed ->
                if (allChecksPassed) {
                    val userData = UserDataModel(
                        userName = fragmentBinding.inputName.text.toString(),
                        userSurname = fragmentBinding.inputSurname.text.toString(),
                        userPassword = fragmentBinding.inputFirstPassword.text.toString(),
                        userBirthday = fragmentBinding.inputBirthday.text.toString()
                    )
                    vm.saveUserData(userData = userData)

                    fragmentBinding.root.findNavController()
                        .navigate(R.id.action_startFragment_to_mainFragment)
                }
            }
        }

        return fragmentBinding.root
    }

    private fun setListener(editText: EditText, id: Int) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val input = s.toString()
                vm.checkInputUserData(data = input, id = id)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun setInputStatus(editText: EditText, value: Int) {
        when (value) {
            1 -> editText.setBackgroundResource(R.drawable.positive_edit_text_theme)

            0 -> editText.setBackgroundResource(R.drawable.neutral_edit_text_theme)

            -1 -> editText.setBackgroundResource(R.drawable.negative_edit_text_theme)
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = activity?.let {
            DatePickerDialog(
                it,
                { _, year, monthOfYear, dayOfMonth ->
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, monthOfYear)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                    val formattedDate = dateFormat.format(calendar.time)
                    vm.saveBirthday(formattedDate = formattedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        }
        datePickerDialog?.show()
    }
}