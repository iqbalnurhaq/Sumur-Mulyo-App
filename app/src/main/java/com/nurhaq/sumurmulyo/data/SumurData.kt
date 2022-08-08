package com.nurhaq.sumurmulyo.data

import android.content.Context
import androidx.datastore.core.DataStore
import com.nurhaq.sumurmulyo.data.remote.DataSource
import com.nurhaq.sumurmulyo.data.remote.DataSourceImpl
import com.nurhaq.sumurmulyo.network.ApiService
import okhttp3.Authenticator
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
            baseUrl: String,
        ): DataSource{
            val authenticator = TokenAuthenticator(context)
            val okHttpClient = OkHttpClient.Builder()
//                .addNetworkInterceptor { chain ->
//                    val origin = chain.request()
//                    val request = origin.newBuilder()
//                        .method(origin.method, origin.body)
//                        .build()
//                    chain.proceed(request)
//                }
                .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getRetrofitClient(authenticator))
                .build()

            val service = retrofit.create(ApiService::class.java)

            return DataSourceImpl(service)
        }

        private fun getRetrofitClient(authenticator: Authenticator): OkHttpClient {
            return OkHttpClient.Builder()
                .addNetworkInterceptor { chain ->
                    val origin = chain.request()
                    val request = origin.newBuilder()
                        .method(origin.method, origin.body)
                        .header("Accept", "application/json").build()
                    chain.proceed(request)
                }.also { client ->
                    authenticator?.let { client.authenticator(it) }
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }.build()
        }



    }
}