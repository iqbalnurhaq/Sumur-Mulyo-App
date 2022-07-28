package com.nurhaq.sumurmulyo.repository.design

import com.nurhaq.sumurmulyo.model.response.UserResponse
import com.nurhaq.sumurmulyo.network.utils.DataState
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun login(
        email : String,
        password: String
    ): Flow<DataState<UserResponse>>
}