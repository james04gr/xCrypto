package com.xecoding.xcrypto.presentation.coin_list

import com.xecoding.xcrypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String? = null
)
