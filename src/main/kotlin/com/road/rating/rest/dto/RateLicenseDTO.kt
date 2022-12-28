package com.road.rating.rest.dto

import com.road.rating.domain.enums.Assessment

data class RateLicenseDTO(
    val license: String,
    val reviews: Set<String>,
    val assessment: Assessment
)
