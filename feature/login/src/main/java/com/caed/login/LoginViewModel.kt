package com.caed.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caed.domain.LoginUseCase
import com.caed.login.ui.LoginUIState
import com.caed.network.model.Data
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _state = mutableStateOf<LoginUIState>(LoginUIState.Default)
    val state: State<LoginUIState> = _state

    fun setState(newState: LoginUIState){
        _state.value = newState
    }

    fun login(userName: String, password: String) = viewModelScope.launch {
        _state.value = LoginUIState.Loading
        val data = loginUseCase(userName, password)

        if(data is Data.Success){
            _state.value = LoginUIState.Success
        }
        else if(data is Data.Error){
            val message = data.cause?.message

            _state.value = LoginUIState.Error(message)
        }
    }
}