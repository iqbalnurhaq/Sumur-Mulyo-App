package com.nurhaq.sumurmulyo.ui.pages.Home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nurhaq.sumurmulyo.data.DataStoreRepository
import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import com.nurhaq.sumurmulyo.model.response.User
import com.nurhaq.sumurmulyo.network.utils.DataState
import com.nurhaq.sumurmulyo.repository.design.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {


    data class TransactionUIState(
        var loading: Boolean = true,
        var error: Boolean = false,
        var errorMessage: String = "",
        var data: List<TransactionResponse>? = listOf()
    )

    data class UserUIState(
        var id: Int? = null,
        var name: String = "",
        var email: String = "",
        var phone: String = "",
        var email_verified_at: Any? = null,
        var profile_photo_path: Any? = null
    )

    private var _userState = MutableLiveData<UserUIState>()
    val userState = _userState

    private var _homeState = MutableLiveData<TransactionUIState>()
    val homeState get() = _homeState

    init {
        viewModelScope.launch {
            val token = dataStoreRepository.getAccessToken()
            Log.e("token", token.toString())

        }
        getUser()
        getTransaction()
    }


    fun getTransaction() = viewModelScope.launch {
        mainRepository.getRecentTransaction()
            .onEach {
                _homeState.postValue(
                    when (it){
                        is DataState.onData -> {
                            Log.e("transaction", it.toString())
                            TransactionUIState(
                                loading = false,
                                error = false,
                                errorMessage = "",
                                data = it.data
                            )
                        }
                        is DataState.onFailure -> {
                            Log.e("failed", it.toString())
                            TransactionUIState(
                                loading = false,
                                error = true,
                                errorMessage = "",
                                data = listOf()
                            )
                        }
                        DataState.onLoading -> TransactionUIState(
                            loading = false,
                            error = false,
                            errorMessage = "",
                            data = listOf()
                        )
                    }
                )

            }.collect()
    }

    fun getUser() = viewModelScope.launch {
        dataStoreRepository.getUser().collect{
            Log.e("name", it.name)
            _userState.postValue(
                UserUIState(
                    id = it.id,
                    name = it.name,
                    email = it.email,
                    phone= it.phone,
                    email_verified_at= it.email_verified_at,
                    profile_photo_path= it.profile_photo_path,
                )
            )
        }
    }
}