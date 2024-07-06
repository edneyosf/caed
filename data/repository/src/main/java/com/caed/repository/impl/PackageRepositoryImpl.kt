package com.caed.repository.impl

import com.caed.network.ApiService
import com.caed.network.handleRequest
import com.caed.network.model.Data
import com.caed.network.model.response.PackagesResponse
import com.caed.repository.BaseRepository
import com.caed.repository.PackageRepository

internal class PackageRepositoryImpl(private val api: ApiService) : BaseRepository(api), PackageRepository {

    override suspend fun all(): Data<PackagesResponse> = handleRequest{ api.packages() }
}