package com.caed.pacote

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val packageModule = module {
    viewModel { PackageViewModel(get()) }
}