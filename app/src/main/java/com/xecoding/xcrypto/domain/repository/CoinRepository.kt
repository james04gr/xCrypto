package com.xecoding.xcrypto.domain.repository

import com.xecoding.xcrypto.data.remote.dto.coin.CoinDto
import com.xecoding.xcrypto.data.remote.dto.coin.info.CoinInfoDto
import com.xecoding.xcrypto.data.remote.dto.person.PersonInfoDto

interface CoinRepository {

    suspend fun getCoinList(): List<CoinDto>

    suspend fun getCoinInfo(coinId: String): CoinInfoDto

    suspend fun getPersonInfo(personId: String): PersonInfoDto

}