package com.xecoding.xcrypto.data.remote.dto.person

data class PersonInfoDto(
    val id: String,
    val name: String,
    val description: String,
    val teams_count: Int,
    val links: Links,
    val positions: List<Position>
)