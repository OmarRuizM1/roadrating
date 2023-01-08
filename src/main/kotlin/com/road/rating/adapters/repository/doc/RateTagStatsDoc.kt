package com.road.rating.adapters.repository.doc

data class RateTagStatsDoc(
    val tag: String,
    val licenseCount: Set<RateTagStatDoc>
)

data class RateTagStatDoc(
    val id: RateTagStatId,
    val count: Int,
)

data class RateTagStatId(
    val license: String
)