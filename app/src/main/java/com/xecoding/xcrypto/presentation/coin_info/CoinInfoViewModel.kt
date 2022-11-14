package com.xecoding.xcrypto.presentation.coin_info

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xecoding.xcrypto.common.NetworkResource
import com.xecoding.xcrypto.domain.use_cases.GetCoinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinInfoViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinInfoState())
    val state = _state

    init {
        savedStateHandle.get<String>("coinId")?.let {
            getCoinInfo(it)
        }
    }

    private fun getCoinInfo(coinId: String) {
        getCoinInfoUseCase(coinId).onEach {
            when (it) {
                is NetworkResource.Loading ->
                    _state.value = CoinInfoState(isLoading = true)
                is NetworkResource.Success ->
                    _state.value = CoinInfoState(coinInfo = it.data)
                is NetworkResource.Error ->
                    _state.value = CoinInfoState(message = it.message ?: "An unexpected error occurred")
            }
        }.launchIn(viewModelScope)
    }
}