package com.road.rating.rest.dto

data class RateTagStatsResponseDTO(
    val tag: String,
    val licenseCount: List<RateTagCountStatDto>
)

data class RateTagCountStatDto(
    val license: String,
    val count: Int,
)

