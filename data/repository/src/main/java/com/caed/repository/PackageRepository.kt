package com.caed.repository

import com.caed.network.model.Data
import com.caed.network.model.response.PackagesResponse

interface PackageRepository {
    suspend fun all() : Data<PackagesResponse>
}