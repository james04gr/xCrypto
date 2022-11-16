package com.xecoding.xcrypto.domain.model.person

data class PersonInfo(
    val id: String,
    val name: String,
    val description: String,
    val teams_count: Int,
    val links: List<PersonLink>,
    val positions: List<PersonPosition>
)
