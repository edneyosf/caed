package com.caed.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caed.domain.usecase.LoginUseCase
import com.caed.login.ui.LoginUIState
import com.caed.network.model.Data
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _state = MutableStateFlow<LoginUIState>(LoginUIState.Default)
    val state = _state.asStateFlow()

    fun setState(newState: LoginUIState){
        _state.value = newState
    }

    fun login(userName: String, password: String) = viewModelScope.launch {
        _state.value = LoginUIState.Loading

        when(val data = loginUseCase(userName, password)){
            is Data.Success -> _state.value = LoginUIState.Success
            is Data.Error -> {
                val message = data.cause?.message

                _state.value = LoginUIState.Error(message)
            }
        }
    }
}