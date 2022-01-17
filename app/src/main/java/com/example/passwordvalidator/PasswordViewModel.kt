package com.example.passwordvalidator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PasswordViewModel : ViewModel() {

    private var _isValid: MutableLiveData<ValidPassword> = MutableLiveData(ValidPassword())
    val isValid: LiveData<ValidPassword> = _isValid

    fun isInputValid(input: String) {
        val meetsCharacterLength = input.length >= 8 && input.length <= 20
        val hasCapital: Boolean = input.matches(Regex(".*[A-Z].*"))
        val hasNumber: Boolean = input.matches(Regex(".*[0-9].*"))
        val noSpaces = !input.contains(" ")

        val isValidPassword = ValidPassword(
            validLength = meetsCharacterLength,
            hasCapital = hasCapital,
            hasNumber = hasNumber,
            noSpaces = noSpaces
        )

        _isValid.value = isValidPassword
    }

}
