package com.caed.edney.di

import com.caed.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VIEW_MODEL_MODULE = module {
    viewModel { LoginViewModel() }
}