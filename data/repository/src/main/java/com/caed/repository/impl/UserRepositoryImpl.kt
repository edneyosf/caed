package com.caed.repository.impl

import com.caed.network.ApiService
import com.caed.network.handleRequest
import com.caed.network.model.request.LoginRequest
import com.caed.repository.BaseRepository
import com.caed.repository.UserRepository

internal class UserRepositoryImpl(private val api: ApiService) : BaseRepository(api), UserRepository {

    override suspend fun login(request: LoginRequest) = handleRequest{ api.login(request) }
}