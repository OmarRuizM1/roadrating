package com.road.rating.rest.mappers

import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.rest.dto.RateLicenseRequestDTO
import java.util.*

fun RateLicenseRequestDTO.toModel() = RateLicenseModel(
    id = UUID.randomUUID().toString(),
    license = license,
    tags = tags,
    assessment = Assessment.returnValue(assessment)
)
