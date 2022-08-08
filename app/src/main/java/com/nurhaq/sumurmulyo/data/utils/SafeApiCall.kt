package com.nurhaq.sumurmulyo.data.utils

import android.util.Log
import com.google.gson.Gson
import com.nurhaq.sumurmulyo.network.utils.DataState
import retrofit2.Response

suspend fun <T> safeApiCall(a: Boolean = false, call: suspend () -> Response<T>): DataState<T> {
    try {
        val response = call.invoke()
        if(response.isSuccessful){
            return DataState.onData((response.body()) as T)
        }else if(response.code() in 400..500){
            val gson = Gson()
            val json = response.errorBody()?.string()
            if(json.isNullOrBlank()){
                return DataState.onFailure("Failed to authenticate")
            }
            val error = gson.fromJson(json, ErrorBody::class.java)
            return DataState.onFailure(error.meta.message)
        }
        return  DataState.onFailure(response.message())
    } catch (e: Exception) {
        return DataState.onFailure(e.message ?: "")
    }
}

data class ErrorBody(
    var meta: Meta,
    var data : Any
)

data class Meta(
    var code : Int,
    var status : String,
    var message: String
)
