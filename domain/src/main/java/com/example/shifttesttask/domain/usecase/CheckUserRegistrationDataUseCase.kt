package com.example.shifttesttask.domain.usecase

private const val NAME_CHECK = 0
private const val SURNAME_CHECK = 1
private const val PASSWORD_CHECK = 2
private const val SECOND_PASSWORD_CHECK = 3

class CheckUserRegistrationDataUseCase() {

    fun execute(data: String, id: Int, firstPassword: String): Boolean {
        return when (id) {
            NAME_CHECK, SURNAME_CHECK -> nameCheck(data = data)
            PASSWORD_CHECK -> passwordCheck(data = data)
            SECOND_PASSWORD_CHECK -> secondPasswordCheck(data = data, firstPassword = firstPassword)
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

}