package com.caed.pacote.ui

import com.caed.core.UIEvent
import com.caed.network.model.Package

internal interface PackageUIEvent : UIEvent {
    fun onDismissAlert()
    fun onShowInfo(item: Package)
    fun onBack()
    fun onBackInfo()
}