package com.nurhaq.sumurmulyo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurhaq.sumurmulyo.network.utils.DataState
import com.nurhaq.sumurmulyo.repository.design.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

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
}