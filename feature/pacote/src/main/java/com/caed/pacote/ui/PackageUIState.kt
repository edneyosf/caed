package com.caed.pacote.ui

import com.caed.core.UIState

internal sealed class  PackageUIState : UIState {
    data object Success : PackageUIState()
    data object Info : PackageUIState()
    data class Error(val message: String?) : PackageUIState()
    data object Loading : PackageUIState()
}