package com.nurhaq.sumurmulyo.network

import com.nurhaq.sumurmulyo.model.request.LoginRequest
import com.nurhaq.sumurmulyo.model.request.RegisterRequest
import com.nurhaq.sumurmulyo.model.response.UserResponse
import com.nurhaq.sumurmulyo.model.response.base.ApiBaseResponse
import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("register")
    suspend fun register(
        @Body registerRequest: RegisterRequest,
    ): Response<ApiBaseResponse<UserResponse>>


    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<ApiBaseResponse<UserResponse>>


    @GET("transaction/{user_id}")
    suspend fun getTransaction(
        @Path ("user_id") user_id: Int
    ): Response<ApiBaseResponse<List<TransactionResponse>>>
}