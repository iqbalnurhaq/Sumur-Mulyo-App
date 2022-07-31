package com.nurhaq.sumurmulyo.data.remote

import com.nurhaq.sumurmulyo.model.response.UserResponse
import com.nurhaq.sumurmulyo.model.response.base.ApiBaseResponse
import com.nurhaq.sumurmulyo.network.utils.DataState

interface DataSource {

    suspend fun login(
        email: String,
        password: String
    ): DataState<ApiBaseResponse<UserResponse>>

    suspend fun register(
        name: String,
        email: String,
        password: String,
        phone: String
    ): DataState<ApiBaseResponse<UserResponse>>
}