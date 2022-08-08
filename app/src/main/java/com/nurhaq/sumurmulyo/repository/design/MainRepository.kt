package com.nurhaq.sumurmulyo.repository.design

import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import com.nurhaq.sumurmulyo.network.utils.DataState
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun getRecentTransaction(): Flow<DataState<List<TransactionResponse>>>
}