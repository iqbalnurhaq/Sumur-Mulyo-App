package com.nurhaq.sumurmulyo.network

import com.nurhaq.sumurmulyo.model.request.LoginRequest
import com.nurhaq.sumurmulyo.model.request.RegisterRequest
import com.nurhaq.sumurmulyo.model.response.UserResponse
import com.nurhaq.sumurmulyo.model.response.base.ApiBaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("register")
    suspend fun register(
        @Body registerRequest: RegisterRequest,
    ): Response<ApiBaseResponse<UserResponse>>


    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<ApiBaseResponse<UserResponse>>
}