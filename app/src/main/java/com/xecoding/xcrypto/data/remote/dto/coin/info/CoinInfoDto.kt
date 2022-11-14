package com.xecoding.xcrypto.data.remote.dto.coin.info

data class CoinInfoDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val is_new: Boolean,
    val is_active: Boolean,
    val type: String,
    val logo: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val description: String,
    val message: String,
    val open_source: Boolean,
    val started_at: String,
    val development_status: String,
    val hardware_wallet: Boolean,
    val proof_type: String,
    val org_structure: String,
    val hash_algorithm: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val whitepaper: Whitepaper,
    val first_data_at: String,
    val last_data_at: String
)