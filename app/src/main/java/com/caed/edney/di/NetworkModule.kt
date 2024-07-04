package com.caed.edney.di

import com.caed.login.BuildConfig
import com.caed.network.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideApiService() }
}

fun provideApiService(){
    val client = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(ApiService::class.java)
}