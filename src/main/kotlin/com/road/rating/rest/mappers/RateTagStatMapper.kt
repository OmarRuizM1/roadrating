package com.road.rating.rest.mappers

import com.road.rating.domain.model.RateTagCountStatModel
import com.road.rating.domain.model.RateTagStatsModel
import com.road.rating.rest.dto.RateTagCountStatDto
import com.road.rating.rest.dto.RateTagStatsResponseDTO

fun RateTagStatsModel.toDto() = RateTagStatsResponseDTO(
    tag = tag,
    licenseCount = licenseCount.map { it.toDto() }
)

fun RateTagCountStatModel.toDto() = RateTagCountStatDto(
    license = license,
    count = count,
)
