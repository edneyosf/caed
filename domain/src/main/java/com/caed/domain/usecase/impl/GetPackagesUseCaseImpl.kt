package com.caed.domain.usecase.impl

import com.caed.domain.usecase.GetPackagesUseCase
import com.caed.repository.PackageRepository

internal class GetPackagesUseCaseImpl(private val repository: PackageRepository) : GetPackagesUseCase {

    override suspend operator fun invoke() = repository.all()
}