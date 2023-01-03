package com.road.rating.rest.mappers

import com.road.rating.domain.model.RateLicenseStatModel
import com.road.rating.domain.model.RateLicenseStatsModel
import com.road.rating.rest.dto.RateLicenseStatDto
import com.road.rating.rest.dto.RateLicenseStatsResponseDTO

fun RateLicenseStatModel.toDto() = RateLicenseStatDto(
    license = license,
    assessment = assessment.name,
    count = count
)

fun RateLicenseStatsModel.toDto() = RateLicenseStatsResponseDTO(
    positiveStats = positiveStats.map { it.toDto() },
    negativeStats = negativeStats.map { it.toDto() }
)
