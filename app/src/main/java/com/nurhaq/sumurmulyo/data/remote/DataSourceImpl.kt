package com.nurhaq.sumurmulyo.data.remote

import com.nurhaq.sumurmulyo.data.utils.safeApiCall
import com.nurhaq.sumurmulyo.model.request.LoginRequest
import com.nurhaq.sumurmulyo.network.ApiService
import com.nurhaq.sumurmulyo.network.utils.DataState

class DataSourceImpl(
    private val apiService: ApiService
): DataSource {
    override suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        apiService.login(
            LoginRequest(
                email = email,
                password = password
            )
        )
    }
}