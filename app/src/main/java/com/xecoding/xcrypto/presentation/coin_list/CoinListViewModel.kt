package com.xecoding.xcrypto.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xecoding.xcrypto.common.NetworkResource
import com.xecoding.xcrypto.domain.use_cases.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinListUseCase: GetCoinListUseCase
): ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getAllCoins()
    }

    private fun getAllCoins() {
        getCoinListUseCase().onEach {
            when (it) {
                is NetworkResource.Loading ->
                    _state.value = CoinListState(isLoading = true)
                is NetworkResource.Success ->
                    _state.value = CoinListState(coins = it.data ?: emptyList())
                is NetworkResource.Error ->
                    _state.value = CoinListState(error = it.message ?: "Unexpected error occurred")
            }
        }.launchIn(viewModelScope)
    }

}