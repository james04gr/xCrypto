package com.xecoding.xcrypto.data.repository

import com.xecoding.xcrypto.data.remote.api.XCryptoApi
import com.xecoding.xcrypto.data.remote.dto.coin.CoinDto
import com.xecoding.xcrypto.data.remote.dto.coin.info.CoinInfoDto
import com.xecoding.xcrypto.domain.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val api: XCryptoApi
) : CoinRepository {

    override suspend fun getCoinList(): List<CoinDto> = api.getAllCoins()

    override suspend fun getCoinInfo(coinId: String): CoinInfoDto = api.getCoinInfo(coinId)
}