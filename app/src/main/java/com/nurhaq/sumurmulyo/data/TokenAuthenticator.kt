package com.nurhaq.sumurmulyo.data

import android.content.Context
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    context: Context
): Authenticator {

    private val appContext = context.applicationContext
    private val userPreferences = DataStoreRepository(appContext)
    override fun authenticate(route: Route?, response: Response): Request? {
        return runBlocking {
            val token = userPreferences.getAccessToken()
            response.request.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        }
    }
}