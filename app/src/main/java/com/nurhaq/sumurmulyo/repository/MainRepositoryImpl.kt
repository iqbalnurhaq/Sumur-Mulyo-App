package com.nurhaq.sumurmulyo.repository

import android.util.Log
import com.google.gson.Gson
import com.nurhaq.sumurmulyo.data.DataStoreRepository
import com.nurhaq.sumurmulyo.data.coroutines.DispatcherProvider
import com.nurhaq.sumurmulyo.data.local.room.TransactionDao
import com.nurhaq.sumurmulyo.data.local.room.UserDao
import com.nurhaq.sumurmulyo.data.remote.DataSource
import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import com.nurhaq.sumurmulyo.model.response.toEntity
import com.nurhaq.sumurmulyo.network.entities.TransactionEntity
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
    private val gson: Gson,
    private val transactionDao: TransactionDao,
    private val userDao: UserDao
): MainRepository {
    override suspend fun getRecentTransaction(): Flow<DataState<List<TransactionEntity>>> = flow {
        emit(DataState.onLoading)
        val userId = dataStoreRepository.getUserId()
        if (userId != null) {
            when (val result = dataSource.getTransaction(userId)) {
                is DataState.onData -> {
                    val transaction = result.data.data
                    val transactionEntity = transaction.map {
                        it.toEntity()
                    }.toMutableList()
                    transactionDao.saveBatch(transactionEntity)
                    emit(DataState.onData(transactionDao.getListTransaction()))
                }
                is DataState.onFailure -> {
                    Log.e("errr", result.message)
//                    emit(DataState.onData(transactionDao.getListTransaction()))
                }
                DataState.onLoading -> emit(DataState.onLoading)
            }
        }
    }.flowOn(dispatcherProvider.io())

}