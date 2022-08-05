package com.nurhaq.sumurmulyo.data


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.nurhaq.sumurmulyo.model.response.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.boardingDataStore: DataStore<Preferences> by preferencesDataStore(name = "boarding_pref")
val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name = "user_pref")

class DataStoreRepository(context: Context) {

    private object BoardingPreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = "boarding_completed")
    }

    private object UserPreferencesKey {
        val userIdKey = intPreferencesKey(name = "user_id")
        val userKey = stringPreferencesKey(name = "user")
    }

    private val boardingDataStore = context.boardingDataStore
    private val userDataStore = context.userDataStore

    suspend fun saveOnBoardingState(completed: Boolean) {
        boardingDataStore.edit { preferences ->
            preferences[BoardingPreferencesKey.onBoardingKey] = completed
        }
    }

    suspend fun setUser(user: User){
        userDataStore.edit { preferences ->
            preferences[UserPreferencesKey.userIdKey] = user.id
            preferences[UserPreferencesKey.userKey] = user.toString()
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

    fun getUserId(): Flow<Int> {
        return userDataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }
            .map { preferences ->
                val userId = preferences[UserPreferencesKey.userIdKey] ?: 0
                userId
            }
    }

    fun getUser(): Flow<String> {
        return userDataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }
            .map {  preferences ->
                val user = preferences[UserPreferencesKey.userKey] ?: ""
                user
            }
    }
}
