package com.road.rating.domain.model

import com.road.rating.domain.enums.Assessment

data class RateLicenseModel(
    var license: String,
    val reviews: Set<String>,
    val assessment: Assessment
)