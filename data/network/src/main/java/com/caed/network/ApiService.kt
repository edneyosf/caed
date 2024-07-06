package com.caed.network

import com.caed.network.model.request.LoginRequest
import com.caed.network.model.response.LoginResponse
import com.caed.network.model.response.PackagesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body body: LoginRequest): Response<LoginResponse>
    @GET("packages")
    suspend fun packages(): Response<PackagesResponse>
}