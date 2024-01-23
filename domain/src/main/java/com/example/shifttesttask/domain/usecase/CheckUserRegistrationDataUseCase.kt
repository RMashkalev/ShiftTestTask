package com.example.shifttesttask.domain.usecase

import java.text.SimpleDateFormat
import java.time.Duration
import java.util.Date
import java.util.Locale

private const val NAME_CHECK = 0
private const val SURNAME_CHECK = 1
private const val PASSWORD_CHECK = 2
private const val SECOND_PASSWORD_CHECK = 3
private const val BIRTHDAY_CHECK = 4

private const val DAYS_IN_18_YEARS = 6574

class CheckUserRegistrationDataUseCase() {

    fun execute(data: String, id: Int, firstPassword: String): Boolean {
        return when (id) {
            NAME_CHECK, SURNAME_CHECK -> nameCheck(data = data)
            PASSWORD_CHECK -> passwordCheck(data = data)
            SECOND_PASSWORD_CHECK -> secondPasswordCheck(data = data, firstPassword = firstPassword)
            BIRTHDAY_CHECK -> birthdayCheck(data = data)
            else -> {
                false
            }
        }
    }

    private fun nameCheck(data: String): Boolean {
        return data.length >= 2
    }

    private fun passwordCheck(data: String): Boolean {
        if (data.length < 8) return false
        if (data.firstOrNull { it.isDigit() } == null) return false
        if (data.filter { it.isLetter() }.firstOrNull { it.isUpperCase() } == null) return false
        if (data.filter { it.isLetter() }.firstOrNull { it.isLowerCase() } == null) return false
        if (data.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true
    }

    private fun secondPasswordCheck(data: String, firstPassword: String): Boolean {
        return data == firstPassword
    }

    private fun birthdayCheck(data: String): Boolean {
        if (data == "") return false

        val userFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val userBirthday = userFormatter.parse(data)

        val currentFormatter = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
        val currentDateTime = currentFormatter.parse(Date().toString())

        val duration = Duration.between(userBirthday.toInstant(), currentDateTime.toInstant())

        return duration.toDays() >= DAYS_IN_18_YEARS
    }
}