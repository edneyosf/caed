package com.caed.login.ui

import com.caed.core.BaseEvent

interface LoginEvent : BaseEvent {
    fun onSubmit(userName: String, password: String)
}