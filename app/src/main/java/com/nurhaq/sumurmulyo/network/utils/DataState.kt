package com.nurhaq.sumurmulyo.network.utils

sealed class DataState<out T>{
    object onLoading: DataState<Nothing>()
    data class onData<out Result>(val data:Result): DataState<Result>()
    data class onFailure(val message: String=""): DataState<Nothing>()
}