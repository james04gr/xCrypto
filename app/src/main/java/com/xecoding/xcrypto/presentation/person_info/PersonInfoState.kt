package com.xecoding.xcrypto.presentation.person_info

import com.xecoding.xcrypto.domain.model.person.PersonInfo

data class PersonInfoState(
    val isLoading: Boolean = false,
    val personInfo: PersonInfo? = null,
    val message: String? = null
)