package com.xecoding.xcrypto.data.remote.api

import com.xecoding.xcrypto.data.remote.dto.coin.CoinDto
import com.xecoding.xcrypto.data.remote.dto.coin.info.CoinInfoDto
import com.xecoding.xcrypto.data.remote.dto.person.PersonInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface XCryptoApi {

    @GET("/v1/coins")
    suspend fun getAllCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinInfo(@Path("coinId") coinId: String): CoinInfoDto

    @GET("/v1/person/{personId}")
    suspend fun getPersonInfo(@Path("personId") personId: String): PersonInfoDto

}