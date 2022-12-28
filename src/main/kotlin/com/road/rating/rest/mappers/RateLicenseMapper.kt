package com.road.rating.rest.mappers

import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.rest.dto.RateLicenseDTO

fun RateLicenseDTO.toModel() = RateLicenseModel(
    license = license,
    reviews = reviews,
    assessment = assessment
)