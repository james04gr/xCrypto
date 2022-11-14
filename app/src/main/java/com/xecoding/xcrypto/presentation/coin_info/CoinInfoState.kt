package com.xecoding.xcrypto.presentation.coin_info

import com.xecoding.xcrypto.domain.model.CoinInfo

data class CoinInfoState(
    val isLoading: Boolean = false,
    val coinInfo: CoinInfo? = null,
    val message: String? = null
)
