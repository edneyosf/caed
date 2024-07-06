package com.caed.domain.usecase

import com.caed.network.model.Data
import com.caed.network.model.response.PackagesResponse

interface GetPackagesUseCase : BaseUseCase {

    suspend operator fun invoke() : Data<PackagesResponse>
}