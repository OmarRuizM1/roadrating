package com.road.rating.domain.model

data class RateTagStatsModel(
    val tag: String,
    val licenseCount: List<RateTagCountStatModel>
)

data class RateTagCountStatModel(
    val license: String,
    val count: Int,
)
