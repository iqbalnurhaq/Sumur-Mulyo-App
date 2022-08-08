package com.nurhaq.sumurmulyo.data


import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.nurhaq.sumurmulyo.model.response.User
import com.nurhaq.sumurmulyo.model.response.UserResponse
import kotlinx.coroutines.flow.*
import java.io.IOException

val Context.boardingDataStore: DataStore<Preferences> by preferencesDataStore(name = "boarding_pref")
val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name = "user_pref")

class DataStoreRepository(context: Context) {

    private object BoardingPreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = "boarding_completed")
    }

    private object UserPreferencesKey {
        val userIdKey = intPreferencesKey(name = "user_id")
        val nameKey = stringPreferencesKey(name = "name")
        val accessToken = stringPreferencesKey(name = "access_token")
    }

    private val boardingDataStore = context.boardingDataStore
    private val userDataStore = context.userDataStore

    suspend fun saveOnBoardingState(completed: Boolean) {
        boardingDataStore.edit { preferences ->
            preferences[BoardingPreferencesKey.onBoardingKey] = completed
        }
    }

    suspend fun setUser(user: UserResponse){
        val gson = Gson()
        val json =  gson.toJson(user)
        userDataStore.edit { preferences ->
            preferences[UserPreferencesKey.userIdKey] = user.user.id
            preferences[UserPreferencesKey.nameKey] = gson.toJson(user.user)
            preferences[UserPreferencesKey.accessToken] = user.access_token
        }
    }


    fun readOnBoardingState(): Flow<Boolean> {
        return boardingDataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }
            .map { preferences ->
                val onBoardingState = preferences[BoardingPreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }

//    suspend fun getUserId(): Flow<Int> {
//         return userDataStore.data
//            .catch { exception ->
//                if (exception is IOException)
//                    emit(emptyPreferences())
//                else
//                    throw exception
//            }
//            .map { preferences ->
//                val userId = preferences[UserPreferencesKey.userIdKey] ?: 0
//                userId
//            }
//    }

    fun getUser(): Flow<User> {
        val gson = Gson()
        return userDataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }
            .map {  preferences ->
                val name = preferences[UserPreferencesKey.nameKey] ?: ""
                gson.fromJson(name, User::class.java)
            }
    }

    suspend fun getUserId(): Int? {
        val id = userDataStore.data.first()
        return id[UserPreferencesKey.userIdKey]
    }

    suspend fun getAccessToken(): String? {
        val tokenPreferences =  userDataStore.data.first()
        return tokenPreferences[UserPreferencesKey.accessToken]
    }
}
