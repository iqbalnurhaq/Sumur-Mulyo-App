package com.nurhaq.sumurmulyo.repository

import android.util.Log
import com.google.gson.Gson
import com.nurhaq.sumurmulyo.data.DataStoreRepository
import com.nurhaq.sumurmulyo.data.coroutines.DispatcherProvider
import com.nurhaq.sumurmulyo.data.remote.DataSource
import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import com.nurhaq.sumurmulyo.network.utils.DataState
import com.nurhaq.sumurmulyo.repository.design.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepositoryImpl constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val dataSource: DataSource,
    private val dataStoreRepository: DataStoreRepository,
    private val gson: Gson
): MainRepository {
    override suspend fun getRecentTransaction(): Flow<DataState<List<TransactionResponse>>> = flow {
        emit(DataState.onLoading)
        val userId = dataStoreRepository.getUserId()
        if (userId != null) {
            when (val result = dataSource.getTransaction(userId)) {
                is DataState.onData -> {
                    val transaction = result.data.data
                    emit(DataState.onData(transaction))

                }
                is DataState.onFailure -> {
                    Log.e("err", result.toString())
                }
                DataState.onLoading -> emit(DataState.onLoading)
            }
        }

    }.flowOn(dispatcherProvider.io())

}