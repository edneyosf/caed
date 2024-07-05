package com.caed.login.ui

import com.caed.core.UIEvent

interface LoginUIEvent : UIEvent {
    fun onSubmit(userName: String, password: String)
    fun onDismissAlert()
}