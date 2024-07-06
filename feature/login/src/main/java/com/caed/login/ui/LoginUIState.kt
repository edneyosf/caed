package com.caed.login.ui

import com.caed.core.UIState

internal sealed class  LoginUIState : UIState {
    data object Default : LoginUIState()
    data object Success : LoginUIState()
    data class Error(val message: String?) : LoginUIState()
    data object Loading : LoginUIState()
}