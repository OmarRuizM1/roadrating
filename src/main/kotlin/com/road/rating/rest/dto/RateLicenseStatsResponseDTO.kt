package com.road.rating.rest.dto

data class RateLicenseStatsResponseDTO(
    val positiveStats: List<RateLicenseStatDto>,
    val negativeStats: List<RateLicenseStatDto>,
)

data class RateLicenseStatDto(
    val license: String,
    val assessment: String,
    val count: Int,
)

