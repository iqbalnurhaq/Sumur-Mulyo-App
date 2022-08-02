package com.nurhaq.sumurmulyo.ui.pages.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val userRepository: UserRepository
):ViewModel() {
    fun login(
        email: String,
        password: String,
        callback: (success: Boolean, userHasComplete: Boolean, message: String) -> Unit
    ) = viewModelScope.launch{
        userRepository.login(email, password)
            .onEach {
                when (it) {
                    is DataState.onData -> {
                        callback(true, true, "success login")
                    }
                    is DataState.onFailure -> {
                        callback(false, false, it.message)
                    }
                    DataState.onLoading -> {}
                }
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

//    fun saveOnBoardingState(completed: Boolean) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.saveOnBoardingState(completed = completed)
//        }
//    }
}