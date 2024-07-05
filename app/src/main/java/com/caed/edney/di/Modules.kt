package com.caed.edney.di

import com.caed.domain.useCaseModule
import com.caed.network.networkModule
import com.caed.repository.repositoryModule

val modules = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)