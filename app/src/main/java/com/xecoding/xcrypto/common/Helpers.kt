package com.xecoding.xcrypto.common

import com.xecoding.xcrypto.data.remote.dto.coin.CoinDto
import com.xecoding.xcrypto.data.remote.dto.coin.info.CoinInfoDto
import com.xecoding.xcrypto.data.remote.dto.person.Links
import com.xecoding.xcrypto.data.remote.dto.person.PersonInfoDto
import com.xecoding.xcrypto.domain.model.Coin
import com.xecoding.xcrypto.domain.model.CoinInfo
import com.xecoding.xcrypto.domain.model.person.PersonInfo
import com.xecoding.xcrypto.domain.model.person.PersonLink
import com.xecoding.xcrypto.domain.model.person.PersonPosition

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

    fun PersonInfoDto.toPersonInfo() = PersonInfo(
        id = id,
        name = name,
        description = description ?: "No description",
        teams_count = teams_count,
        links = links.toPersonLinks(),
        positions = positions.map { PersonPosition(it.coin_name, it.position) }
    )

    private fun Links.toPersonLinks(): List<PersonLink> {
        val result = mutableListOf<PersonLink>()
        result.add(
            PersonLink("Github",
                buildList {
                    github?.map { it.url }
                }
            )
        )
        result.add(
            PersonLink("LinkedIn",
                buildList {
                    linkedin?.map { it.url }
                }
            )
        )
        result.add(
            PersonLink("Medium",
                buildList {
                    medium?.map { it.url }
                }
            )
        )
        result.add(
            PersonLink("Twitter",
                buildList {
                    twitter?.map { it.url }
                }
            )
        )
        result.add(
            PersonLink("Additional",
                buildList {
                    additional?.map { it.url }
                }
            )
        )
        return result
    }

}