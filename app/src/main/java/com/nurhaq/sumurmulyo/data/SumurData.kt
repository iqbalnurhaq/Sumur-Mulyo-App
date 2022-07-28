package com.nurhaq.sumurmulyo.data

import android.content.Context
import com.nurhaq.sumurmulyo.data.remote.DataSource
import com.nurhaq.sumurmulyo.data.remote.DataSourceImpl
import com.nurhaq.sumurmulyo.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SumurData() {
    companion object {
        private val REQUEST_TIMEOUT = 5
        private val httpLoggingInterceptor = HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        fun getDataSource(
            context: Context,
            baseUrl: String
        ): DataSource{
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor { chain ->
                    val origin = chain.request()
                    val request = origin.newBuilder()
                        .method(origin.method, origin.body)
                        .build()
                    chain.proceed(request)
                }
                .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            val service = retrofit.create(ApiService::class.java)

            return DataSourceImpl(service)
        }

    }
}