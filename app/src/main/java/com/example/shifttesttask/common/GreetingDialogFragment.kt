package com.example.shifttesttask.common

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.shifttesttask.R
import com.example.shifttesttask.domain.models.GreetingUserDataModel

class GreetingDialogFragment(private val userGreetingData : GreetingUserDataModel) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle(R.string.greetingTitle)
            .setMessage("${getString(R.string.greetingBody)} ${userGreetingData.userName} ${userGreetingData.userSurname}")
            .create()
    }
}