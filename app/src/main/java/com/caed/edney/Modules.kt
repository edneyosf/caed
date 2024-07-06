package com.caed.edney

import com.caed.domain.useCaseModule
import com.caed.login.loginModule
import com.caed.pacote.packageModule
import com.caed.network.networkModule
import com.caed.repository.repositoryModule

val appModules = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    loginModule,
    packageModule
)