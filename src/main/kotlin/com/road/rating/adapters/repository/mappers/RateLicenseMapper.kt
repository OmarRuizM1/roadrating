package com.road.rating.adapters.repository.mappers

import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.adapters.repository.doc.RateLicenseDoc

fun RateLicenseModel.toDoc() = RateLicenseDoc(
    id = id,
    license = license,
    reviews = reviews,
    assessment = assessment.name
)