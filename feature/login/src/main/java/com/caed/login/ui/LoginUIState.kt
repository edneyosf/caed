package com.caed.login.ui

import com.caed.core.UIState

sealed class  LoginUIState : UIState {
    data object Default : LoginUIState()
    data object Success : LoginUIState()
    data class Error(val message: String?) : LoginUIState()
    data object Loading : LoginUIState()
}