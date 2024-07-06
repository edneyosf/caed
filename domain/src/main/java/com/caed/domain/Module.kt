package com.caed.domain

import com.caed.domain.usecase.GetPackagesUseCase
import com.caed.domain.usecase.LoginUseCase
import com.caed.domain.usecase.impl.GetPackagesUseCaseImpl
import com.caed.domain.usecase.impl.LoginUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<LoginUseCase> { LoginUseCaseImpl(get()) }
    single<GetPackagesUseCase> { GetPackagesUseCaseImpl(get()) }
}