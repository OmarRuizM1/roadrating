package com.road.rating.rest.dto

data class RateLicenseRequestDTO(
    val license: String,
    val tags: Set<String>,
    val assessment: String?
)
