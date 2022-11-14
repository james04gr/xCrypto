package com.xecoding.xcrypto.domain.model

import com.xecoding.xcrypto.data.remote.dto.coin.info.Links
import com.xecoding.xcrypto.data.remote.dto.coin.info.Tag
import com.xecoding.xcrypto.data.remote.dto.coin.info.Team

data class CoinInfo(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val is_new: Boolean,
    val is_active: Boolean,
    val logo: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val description: String,
    val message: String,
    val links: Links
)
