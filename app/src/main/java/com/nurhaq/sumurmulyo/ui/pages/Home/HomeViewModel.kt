package com.nurhaq.sumurmulyo.ui.pages.Home

import android.util.Log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurhaq.sumurmulyo.data.DataStoreRepository
import com.nurhaq.sumurmulyo.model.response.ProductResponse
import com.nurhaq.sumurmulyo.model.response.TransactionResponse
import com.nurhaq.sumurmulyo.network.entities.TransactionEntity
import com.nurhaq.sumurmulyo.network.utils.DataState
import com.nurhaq.sumurmulyo.repository.design.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
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
        var data: List<TransactionEntity>? = listOf()
    )

    data class ProductUIState(
        var loading: Boolean = true,
        var error: Boolean = false,
        var errorMessage: String = "",
        var data: List<ProductResponse>? = listOf()
    )



    private var _homeState = MutableLiveData<TransactionUIState>()
    val homeState get() = _homeState

    private var _productState = MutableLiveData<ProductUIState>()
    val productState get() = _productState

    init {
        getTransaction()
        getListProduct()
    }


    fun getTransaction() = viewModelScope.launch {
        mainRepository.getRecentTransaction()
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

    fun getListProduct() = viewModelScope.launch {
        mainRepository.gerListProduct()
            .onEach {
                _productState.postValue(
                    when(it) {
                        is DataState.onData -> {
                            ProductUIState(
                                loading = false,
                                error = false,
                                errorMessage = "",
                                data = it.data
                            )
                        }
                        is DataState.onFailure -> {
                            ProductUIState(
                                loading = false,
                                error = true,
                                errorMessage = "",
                                data = listOf()
                            )
                        }
                        DataState.onLoading -> {
                            ProductUIState(
                                loading = false,
                                error = false,
                                errorMessage = "",
                                data = listOf()
                            )
                        }
                    }

                )
            }.collect()
    }

//    fun getUser() = viewModelScope.launch {
//        dataStoreRepository.getUser().collect{
//            Log.e("name", it.name)
//            _userState.postValue(
//                UserUIState(
//                    id = it.id,
//                    name = it.name,
//                    email = it.email,
//                    phone= it.phone,
//                    email_verified_at= it.email_verified_at,
//                    profile_photo_path= it.profile_photo_path,
//                )
//            )
//        }
//    }
}