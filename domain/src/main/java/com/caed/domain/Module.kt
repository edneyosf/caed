package com.caed.domain

import org.koin.dsl.module

val useCaseModule = module {
    single<LoginUseCase> { LoginUseCaseImpl(get()) }
}