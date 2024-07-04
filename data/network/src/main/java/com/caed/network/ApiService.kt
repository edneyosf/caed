package com.caed.network

import okhttp3.Call
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(): Call
}