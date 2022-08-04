package com.nurhaq.sumurmulyo.ui.pages.Home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import com.nurhaq.sumurmulyo.network.utils.DataState
import com.nurhaq.sumurmulyo.repository.design.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    data class TransactionUIState(
        var loading: Boolean = true,
        var error: Boolean = false,
        var errorMessage: String = "",
        var data: List<TransactionResponse> = listOf()
    )

    private var _homeState = MutableLiveData<TransactionUIState>()
    val homeState get() = _homeState

    init {
        getRecentTransaction(1)
    }

    fun getRecentTransaction(
        user_id: Int
    ) = viewModelScope.launch {
        mainRepository.getRecentTransaction(user_id)
            .onEach {

                _homeState.postValue(
                    when (it){
                        is DataState.onData -> {
                            TransactionUIState(
                                loading = false,
                                error = false,
                                errorMessage = "",
                                data = it.data
                            )
                        }
                        is DataState.onFailure -> {
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
}