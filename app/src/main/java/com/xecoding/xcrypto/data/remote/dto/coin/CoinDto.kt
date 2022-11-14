package com.xecoding.xcrypto.data.remote.dto.coin

data class CoinDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val is_new: Boolean,
    val is_active: Boolean,
    val type: String
)