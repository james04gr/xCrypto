package com.xecoding.xcrypto.common

import com.xecoding.xcrypto.data.remote.dto.coin.CoinDto
import com.xecoding.xcrypto.data.remote.dto.coin.info.CoinInfoDto
import com.xecoding.xcrypto.domain.model.Coin
import com.xecoding.xcrypto.domain.model.CoinInfo

object Helpers {

    fun CoinDto.toCoin() = Coin(
        id = id,
        isActive = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )

    fun CoinInfoDto.toCoinInfo() = CoinInfo(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        is_new = is_new,
        is_active = is_active,
        logo = logo,
        tags = tags,
        team = team,
        description = description,
        message = message,
        links = links
    )

}