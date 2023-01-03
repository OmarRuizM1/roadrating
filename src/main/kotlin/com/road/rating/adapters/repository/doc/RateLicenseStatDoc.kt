package com.road.rating.adapters.repository.doc

data class RateLicenseStatsDoc(
    val positiveStats: List<RateLicenseStatDoc>,
    val negativeStats: List<RateLicenseStatDoc>
)

data class RateLicenseStatDoc(
    val id: Id,
    val count: Int,
)

data class Id(
    val license: String,
    val assessment: String,
)