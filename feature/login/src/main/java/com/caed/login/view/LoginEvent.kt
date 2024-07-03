package com.caed.login.view

import com.caed.core.BaseEvent

interface LoginEvent : BaseEvent {
    fun onSubmit(userName: String, password: String)
}