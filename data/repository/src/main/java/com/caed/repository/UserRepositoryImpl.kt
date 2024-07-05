package com.caed.repository

import com.caed.network.ApiService
import com.caed.network.handleRequest
import com.caed.network.model.request.LoginRequest

internal class UserRepositoryImpl(private val api: ApiService) : BaseRepository(api), UserRepository {

    override suspend fun login(request: LoginRequest) = handleRequest{ api.login(request) }
}