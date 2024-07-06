package com.caed.domain.usecase

import com.caed.network.model.Data
import com.caed.network.model.response.LoginResponse

interface LoginUseCase : BaseUseCase {

    suspend operator fun invoke(userName: String, password: String) : Data<LoginResponse>
}