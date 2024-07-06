package com.caed.repository

import com.caed.network.model.Data
import com.caed.network.model.request.LoginRequest
import com.caed.network.model.response.LoginResponse

interface UserRepository {
    suspend fun login(request: LoginRequest) : Data<LoginResponse>
}