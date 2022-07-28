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
            Log.e("assasa",json.toString())
            val error = gson.fromJson(json, ErrorBody::class.java)
            Log.e("err",error.toString())
            return DataState.onFailure(error.data.message)
        }
        return  DataState.onFailure(response.message())
    } catch (e: Exception) {
        return DataState.onFailure(e.message ?: "")
    }
}

data class ErrorBody(
    var meta: meta,
    var data : data
)

data class meta(
    var code : Int,
    var status : String,
    var message: String
)

data class data(
    var message: String
)