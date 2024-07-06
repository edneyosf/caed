package com.caed.domain.usecase.impl

import com.caed.domain.usecase.LoginUseCase
import com.caed.network.model.Data
import com.caed.network.model.request.LoginRequest
import com.caed.network.model.response.LoginResponse
import com.caed.repository.UserRepository

internal class LoginUseCaseImpl(private val repository: UserRepository) : LoginUseCase {
    override suspend operator fun invoke(userName: String, password: String): Data<LoginResponse> {
        val request = LoginRequest(userName, password)

        return repository.login(request)
    }
}