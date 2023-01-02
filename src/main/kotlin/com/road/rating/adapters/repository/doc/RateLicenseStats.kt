package com.road.rating.adapters.repository.doc

data class RateLicenseStats(
    val id: Id,
    val count: Int,
)

data class Id(
    val license: String,
    val assessment: String,
)