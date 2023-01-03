package com.road.rating.adapters.repository.mappers

import com.road.rating.adapters.repository.doc.RateLicenseStatDoc
import com.road.rating.adapters.repository.doc.RateLicenseStatsDoc
import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseStatModel
import com.road.rating.domain.model.RateLicenseStatsModel

fun RateLicenseStatDoc.toModel() = RateLicenseStatModel(
    license = id.license,
    assessment = Assessment.returnValue(id.assessment),
    count = count
)

fun RateLicenseStatsDoc.toModel() = RateLicenseStatsModel(
    positiveStats = positiveStats.map { it.toModel() },
    negativeStats = negativeStats.map { it.toModel() }
)