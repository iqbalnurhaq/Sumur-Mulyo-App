package com.nurhaq.sumurmulyo.data.remote

import com.nurhaq.sumurmulyo.data.utils.safeApiCall
import com.nurhaq.sumurmulyo.model.request.LoginRequest
import com.nurhaq.sumurmulyo.model.request.RegisterRequest
import com.nurhaq.sumurmulyo.network.ApiService

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

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        phone: String
    ) = safeApiCall {
        apiService.register(
            RegisterRequest(
                name = name,
                email = email,
                password = password,
                phone = phone
            )
        )
    }

    override suspend fun getTransaction(
        user_id: Int
    ) = safeApiCall {
        apiService.getTransaction(
            user_id = user_id
        )
    }
}