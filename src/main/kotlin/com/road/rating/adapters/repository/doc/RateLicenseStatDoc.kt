package com.road.rating.adapters.repository.doc

data class RateLicenseStatsDoc(
    val positiveStats: List<RateLicenseStatDoc>,
    val negativeStats: List<RateLicenseStatDoc>
)

data class RateLicenseStatDoc(
    val id: RateLicenseStatId,
    val count: Int,
)

data class RateLicenseStatId(
    val license: String,
    val assessment: String,
)