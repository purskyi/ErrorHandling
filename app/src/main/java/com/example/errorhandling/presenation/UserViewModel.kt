package com.example.errorhandling.presenation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.errorhandling.domain.AuthRepository
import com.example.errorhandling.domain.DataError
import com.example.errorhandling.domain.MineResult
import com.example.errorhandling.domain.PasswordError
import com.example.errorhandling.domain.UserDataValidator
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class UserViewModel(
    private val userDataValidator: UserDataValidator,
    private val repository: AuthRepository): ViewModel() {

    private val eventChannel = Channel<UserEvent>()
    val events = eventChannel.receiveAsFlow()

    fun onRegisterClick(password: String) {
        when (val result = userDataValidator.validatePassword(password)) {
            is MineResult.Error -> {
                when (result.error) {
                    PasswordError.TOO_SHORT -> TODO()
                    PasswordError.NO_UPPERCASE -> TODO()
                    PasswordError.NO_DOGIT -> TODO()
                }
            }

            is MineResult.Success -> {

            }
        }
        viewModelScope.launch {
            when (val result = repository.register(password)) {
                is MineResult.Error -> {
                    val errorMessage = result.error.asUiText()
                    eventChannel.send(UserEvent.Error(errorMessage))
                }

                is MineResult.Success -> {
                    result.data
                }
            }
        }
    }
}

sealed interface UserEvent {
    data class Error(val error: UiText): UserEvent
}