package com.example.shifttesttask.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shifttesttask.domain.models.UserDataModel
import com.example.shifttesttask.domain.usecase.BIRTHDAY_CHECK
import com.example.shifttesttask.domain.usecase.CheckRememberUserDataUseCase
import com.example.shifttesttask.domain.usecase.CheckUserRegistrationDataUseCase
import com.example.shifttesttask.domain.usecase.NAME_CHECK
import com.example.shifttesttask.domain.usecase.PASSWORD_CHECK
import com.example.shifttesttask.domain.usecase.SECOND_PASSWORD_CHECK
import com.example.shifttesttask.domain.usecase.SURNAME_CHECK
import com.example.shifttesttask.domain.usecase.UserRegistrationUseCase

private const val NEUTRAL_STATUS = 0
private const val NEGATIVE_STATUS = -1
private const val POSITIVE_STATUS = 1

private const val BOOL_NEGATIVE_STATUS = false
private const val BOOL_POSITIVE_STATUS = true


class RegistrationViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase,
    private val checkRememberUserDataUseCase: CheckRememberUserDataUseCase,
    private val checkUserRegistrationDataUseCase: CheckUserRegistrationDataUseCase
) : ViewModel() {
    val dataSaved = MutableLiveData<Boolean>(BOOL_NEGATIVE_STATUS)

    val nameInputStatus = MutableLiveData<Int>(NEUTRAL_STATUS)
    val surnameInputStatus = MutableLiveData<Int>(NEUTRAL_STATUS)
    val passwordInputStatus = MutableLiveData<Int>(NEUTRAL_STATUS)
    val secondPasswordInputStatus = MutableLiveData<Int>(NEUTRAL_STATUS)
    val birthdayInputStatus = MutableLiveData<Int>(NEUTRAL_STATUS)

    val allChecksPassed = MutableLiveData<Boolean>(BOOL_NEGATIVE_STATUS)
    var nameErrorMessage = MutableLiveData<Boolean>(BOOL_POSITIVE_STATUS)
    var surnameErrorMessage = MutableLiveData<Boolean>(BOOL_POSITIVE_STATUS)
    var passwordErrorMessage = MutableLiveData<Boolean>(BOOL_POSITIVE_STATUS)
    var secondPasswordErrorMessage = MutableLiveData<Boolean>(BOOL_POSITIVE_STATUS)
    var birthdayErrorMessage = MutableLiveData<Boolean>(BOOL_POSITIVE_STATUS)

    var userBirthday = MutableLiveData<String>("")
    private val fieldsCheck = Array<Boolean>(5) { false }
    private var firstPassword = ""
    private var secondPassword = ""

    fun saveUserData(userData: UserDataModel) {
        userRegistrationUseCase.execute(userData = userData)
    }

    fun checkRememberUserData() {
        dataSaved.value = checkRememberUserDataUseCase.execute()
    }

    fun checkInputUserData(data: String, id: Int) {
        val result =
            checkUserRegistrationDataUseCase.execute(
                data = data,
                id = id,
                firstPassword = firstPassword
            )
        if (result) {
            when (id) {
                NAME_CHECK -> {
                    nameInputStatus.value = POSITIVE_STATUS
                    nameErrorMessage.value = BOOL_POSITIVE_STATUS
                    fieldsCheck[NAME_CHECK] = true
                }

                SURNAME_CHECK -> {
                    surnameInputStatus.value = POSITIVE_STATUS
                    surnameErrorMessage.value = BOOL_POSITIVE_STATUS
                    fieldsCheck[SURNAME_CHECK] = true
                }

                PASSWORD_CHECK -> {
                    passwordInputStatus.value = POSITIVE_STATUS
                    passwordErrorMessage.value = BOOL_POSITIVE_STATUS
                    firstPassword = data
                    checkInputUserData(data = secondPassword, id = SECOND_PASSWORD_CHECK)
                    fieldsCheck[PASSWORD_CHECK] = true
                }

                SECOND_PASSWORD_CHECK -> {
                    secondPasswordInputStatus.value = POSITIVE_STATUS
                    secondPasswordErrorMessage.value = BOOL_POSITIVE_STATUS
                    secondPassword = data
                    fieldsCheck[SECOND_PASSWORD_CHECK] = true
                }
            }
        } else {
            when (id) {
                NAME_CHECK -> {
                    nameInputStatus.value = NEGATIVE_STATUS
                    nameErrorMessage.value = BOOL_NEGATIVE_STATUS
                    fieldsCheck[NAME_CHECK] = false
                }

                SURNAME_CHECK -> {
                    surnameInputStatus.value = NEGATIVE_STATUS
                    surnameErrorMessage.value = BOOL_NEGATIVE_STATUS
                    fieldsCheck[SURNAME_CHECK] = false
                }

                PASSWORD_CHECK -> {
                    passwordInputStatus.value = NEGATIVE_STATUS
                    passwordErrorMessage.value = BOOL_NEGATIVE_STATUS
                    firstPassword = data
                    checkInputUserData(data = secondPassword, id = SECOND_PASSWORD_CHECK)
                    fieldsCheck[PASSWORD_CHECK] = false
                }

                SECOND_PASSWORD_CHECK -> {
                    secondPasswordInputStatus.value = NEGATIVE_STATUS
                    secondPasswordErrorMessage.value = BOOL_NEGATIVE_STATUS
                    fieldsCheck[SECOND_PASSWORD_CHECK] = false
                }
            }
        }

    }

    fun resultCheck() {
        var result = true
        for (i in fieldsCheck) {
            result = result && i
        }
        allChecksPassed.value = result
    }

    fun saveBirthday(formattedDate: String) {
        userBirthday.value = formattedDate
    }

    fun checkBirthday(birthday: String) {
        val result =
            checkUserRegistrationDataUseCase.execute(
                data = birthday,
                id = BIRTHDAY_CHECK,
                firstPassword = firstPassword
            )
        if (result) {
            birthdayInputStatus.value = POSITIVE_STATUS
            birthdayErrorMessage.value = BOOL_POSITIVE_STATUS
            fieldsCheck[BIRTHDAY_CHECK] = true
        } else {
            birthdayInputStatus.value = NEGATIVE_STATUS
            birthdayErrorMessage.value = BOOL_NEGATIVE_STATUS
            fieldsCheck[BIRTHDAY_CHECK] = false
        }
    }
}