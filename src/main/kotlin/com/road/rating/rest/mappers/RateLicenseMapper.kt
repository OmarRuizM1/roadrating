package com.road.rating.rest.mappers

import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.rest.dto.RateLicenseDTO
import java.util.*

fun RateLicenseDTO.toModel() = RateLicenseModel(
    id = UUID.randomUUID().toString(),
    license = license,
    tags = tags,
    assessment = Assessment.returnValue(assessment)
)