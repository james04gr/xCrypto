package com.xecoding.xcrypto.data.remote.dto.person

data class Links(
    val github: List<Github>?,
    val linkedin: List<Linkedin>?,
    val medium: List<Medium>?,
    val twitter: List<Twitter>?,
    val additional: List<Additional>?
)