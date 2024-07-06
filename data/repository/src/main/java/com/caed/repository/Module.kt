package com.caed.repository

import com.caed.repository.impl.PackageRepositoryImpl
import com.caed.repository.impl.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<PackageRepository> { PackageRepositoryImpl(get()) }
}