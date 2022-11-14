package com.xecoding.xcrypto.domain.repository

import com.xecoding.xcrypto.data.remote.dto.coin.CoinDto
import com.xecoding.xcrypto.data.remote.dto.coin.info.CoinInfoDto

interface CoinRepository {

    suspend fun getCoinList(): List<CoinDto>

    suspend fun getCoinInfo(coinId: String): CoinInfoDto

}