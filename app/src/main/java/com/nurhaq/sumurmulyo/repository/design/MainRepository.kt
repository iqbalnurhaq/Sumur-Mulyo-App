package com.nurhaq.sumurmulyo.repository.design

import com.nurhaq.sumurmulyo.model.response.ProductResponse
import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import com.nurhaq.sumurmulyo.network.entities.TransactionEntity
import com.nurhaq.sumurmulyo.network.utils.DataState
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun getRecentTransaction(): Flow<DataState<List<TransactionEntity>>>

    suspend fun gerListProduct(): Flow<DataState<List<ProductResponse>>>
}