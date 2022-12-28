package com.road.rating.rest.dto

data class RateLicenseDTO(
    val license: String,
    val reviews: Set<String>,
    val assessment: String?
)
