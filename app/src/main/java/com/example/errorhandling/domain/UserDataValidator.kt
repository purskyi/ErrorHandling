package com.example.errorhandling.domain

import androidx.core.text.isDigitsOnly
import kotlin.Result

class UserDataValidator {
    fun validatePassword(password: String): MineResult<Unit, PasswordError> {
        if (password.length < 9) {
            return MineResult.Error(PasswordError.TOO_SHORT)
        }

        val hasUpperCaseChar = password.any { it.isUpperCase() }
        if (!hasUpperCaseChar) {
            return MineResult.Error(PasswordError.NO_UPPERCASE)
        }
        val hasAtLeast1Digit = password.any { it.isDigit() }
        if (!hasAtLeast1Digit){
            return MineResult.Error(PasswordError.NO_DOGIT)
        }

        return MineResult.Success(Unit)
    }
}

enum class PasswordError: Error {
    TOO_SHORT,
    NO_UPPERCASE,
    NO_DOGIT
}