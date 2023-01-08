package com.road.rating.adapters.repository.mappers

import com.road.rating.adapters.repository.doc.RateTagStatDoc
import com.road.rating.adapters.repository.doc.RateTagStatsDoc
import com.road.rating.domain.model.RateTagCountStatModel
import com.road.rating.domain.model.RateTagStatsModel

fun RateTagStatsDoc.toModel() = RateTagStatsModel(
    tag = tag,
    licenseCount = licenseCount.map { it.toModel() }
)

fun RateTagStatDoc.toModel() = RateTagCountStatModel(
    license = id.license,
    count = count,
)
