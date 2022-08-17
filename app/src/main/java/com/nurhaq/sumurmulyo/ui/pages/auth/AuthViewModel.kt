package com.nurhaq.sumurmulyo.ui.pages.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurhaq.sumurmulyo.data.DataStoreRepository
import com.nurhaq.sumurmulyo.model.response.UserResponse
import com.nurhaq.sumurmulyo.network.utils.DataState
import com.nurhaq.sumurmulyo.repository.design.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val dataStoreRepository: DataStoreRepository
):ViewModel() {

    data class LoginUIState(
        var loading: Boolean = false,
        var error: Boolean = false,
        var errorMessage: String = "",
        var data : UserResponse? = null
    )

    private var _loginState = MutableLiveData<LoginUIState>()
    val loginState get() =  _loginState

    fun login(
        email: String,
        password: String,
        callback: (success: Boolean, userHasComplete: Boolean, message: String) -> Unit
    ) = viewModelScope.launch{
        userRepository.login(email, password)
            .onEach {
                _loginState.postValue(
                    when (it) {
                        is DataState.onData -> {
                            dataStoreRepository.setUser(it.data)
                            callback(true, true, "success login")
                            LoginUIState(
                                loading = false,
                                error = false,
                                errorMessage =  "",
                                data = it.data
                            )
                        }
                        is DataState.onFailure -> {
                            Log.e("errrr", it.message)
                            callback(false, false, it.message)
                            LoginUIState(
                                loading = false,
                                error = true,
                                errorMessage =  it.message,
                                data = null
                            )
                        }
                        DataState.onLoading -> LoginUIState(
                            loading = true,
                            error = false,
                            errorMessage =  "",
                            data = null
                        )
                    }
                )

            }.collect()
    }

    fun register(
        name: String,
        email: String,
        password: String,
        phone: String,
        callback: (success: Boolean, userHasComplete: Boolean, message: String) -> Unit
    ) = viewModelScope.launch {
        userRepository.register(name, email, password, phone)
            .onEach {
                when (it) {
                    is DataState.onData -> {
                        callback(true, true, "success register")
                    }
                    is DataState.onFailure -> {
                        callback(false, false, it.message)
                    }
                    DataState.onLoading -> {}
                }
            }.collect()
    }

//    fun toStringUser(user: User){
//        val gson = Gson()
//        val json =  gson.toJson(user)
//        Log.e("tagg", gson.toJson(user))
//    }
//    fun saveOnBoardingState(completed: Boolean) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.saveOnBoardingState(completed = completed)
//        }
//    }
}