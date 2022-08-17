package com.nurhaq.sumurmulyo.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.google.gson.Gson
import com.nurhaq.sumurmulyo.data.DataStoreRepository
import com.nurhaq.sumurmulyo.data.SumurData
import com.nurhaq.sumurmulyo.data.coroutines.DefaultDispatcherProvider
import com.nurhaq.sumurmulyo.data.coroutines.DispatcherProvider
import com.nurhaq.sumurmulyo.data.local.room.SumurDatabase
import com.nurhaq.sumurmulyo.data.local.room.TransactionDao
import com.nurhaq.sumurmulyo.data.local.room.UserDao
import com.nurhaq.sumurmulyo.data.remote.DataSource
import com.nurhaq.sumurmulyo.network.ApiService
import com.nurhaq.sumurmulyo.repository.MainRepositoryImpl
import com.nurhaq.sumurmulyo.repository.UserRepositoryImpl
import com.nurhaq.sumurmulyo.repository.design.MainRepository
import com.nurhaq.sumurmulyo.repository.design.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    private const val REQUEST_TIMEOUT = 5

    @Provides
    internal fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }


    @Provides
    internal fun provideDataSource(
        @ApplicationContext context: Context,
    ): DataSource = SumurData.getDataSource(
        context,
        "http://192.168.100.159:8000/api/"
    )

    @Provides
    fun provideUserRepository(
        dispatcherProvider: DispatcherProvider,
        dataSource: DataSource,
        gson: Gson,
        userDao: UserDao
    ): UserRepository {
        return UserRepositoryImpl(
            dispatcherProvider,
            dataSource,
            gson,
            userDao
        )
    }

    @Provides
    fun provideMainRepository(
        dispatcherProvider: DispatcherProvider,
        dataSource: DataSource,
        dataStoreRepository: DataStoreRepository,
        gson: Gson,
        transactionDao: TransactionDao,
        userDao: UserDao
    ): MainRepository {
        return MainRepositoryImpl(
            dispatcherProvider,
            dataSource,
            dataStoreRepository,
            gson,
            transactionDao,
            userDao
        )
    }

    @Provides
    internal fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) = DataStoreRepository(context =  context)

    @Provides
    @Singleton
    internal fun localDatabase(
        @ApplicationContext appContext: Context
    ): SumurDatabase = SumurData.initializeDatabase(appContext)

    @Provides
    internal fun provideTransactionDao(appDb: SumurDatabase): TransactionDao = appDb.transactionDao()

    @Provides
    internal fun provideUserDao(appDb: SumurDatabase): UserDao = appDb.userDao()




//    @Provides
//    @Singleton
//    fun provideApiService(
//        httpLoggingInterceptor: HttpLoggingInterceptor,
//        @ApplicationContext context: Context
//    ): ApiService {
//        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .addNetworkInterceptor { chain ->
//                val origin = chain.request()
//                val host = origin.url.host
//                val request = origin.newBuilder()
//                    .method(origin.method, origin.body)
//                    .build()
//                chain.proceed(request)
//            }
//            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
//            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
//            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://192.168.100.165:8000/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//        return retrofit.create(ApiService::class.java)
//    }
}