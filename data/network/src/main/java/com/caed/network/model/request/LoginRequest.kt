package com.caed.network.model.request

data class LoginRequest(
    private val userName: String,
    private val password: String)