package com.nurhaq.sumurmulyo.repository

import android.util.Log
import com.google.gson.Gson
import com.nurhaq.sumurmulyo.data.remote.DataSource
import com.nurhaq.sumurmulyo.data.coroutines.DispatcherProvider
import com.nurhaq.sumurmulyo.data.local.room.UserDao
import com.nurhaq.sumurmulyo.model.response.UserResponse
import com.nurhaq.sumurmulyo.model.response.toEntity
import com.nurhaq.sumurmulyo.network.entities.UserEntity
import com.nurhaq.sumurmulyo.network.utils.DataState
import com.nurhaq.sumurmulyo.repository.design.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImpl constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val dataSource: DataSource,
    private val gson: Gson,
    private val userDao: UserDao
): UserRepository {
    override suspend fun login(email: String, password: String)
    : Flow<DataState<UserResponse>> = flow {
        emit(DataState.onLoading)
        when (val result = dataSource.login(email, password)) {
            is DataState.onData -> {
                if (result.data.meta.status == "success") {
                    val user = result.data.data
                    userDao.insert(user.user.toEntity())
                    emit(DataState.onData(user))
                } else {
//                    emit(DataState.onFailure(result.data.data.message))
                }
            }
            is DataState.onFailure -> emit(result)
            DataState.onLoading -> emit(DataState.onLoading)
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        phone: String
    ): Flow<DataState<UserResponse>> = flow {
        emit(DataState.onLoading)
        when (val result = dataSource.register(name, email, password, phone)) {
            is DataState.onData -> {
                if (result.data.meta.status == "success") {
                    val user = result.data.data
                    emit(DataState.onData(user))
                }else{

                }
            }
            is DataState.onFailure -> {
                emit(result)
            }
            DataState.onLoading -> emit(DataState.onLoading)
        }
    }.flowOn(dispatcherProvider.io())
}
