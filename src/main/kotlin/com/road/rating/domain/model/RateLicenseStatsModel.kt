package com.road.rating.domain.model

import com.road.rating.domain.enums.Assessment

data class RateLicenseStatsModel(
    val positiveStats: List<RateLicenseStatModel>,
    val negativeStats: List<RateLicenseStatModel>,
)

data class RateLicenseStatModel(
    val license: String,
    val assessment: Assessment,
    val count: Int,
)
