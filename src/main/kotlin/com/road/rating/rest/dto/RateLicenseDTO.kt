package com.road.rating.rest.dto

data class RateLicenseDTO(
    val license: String,
    val tags: Set<String>,
    val assessment: String?
)
