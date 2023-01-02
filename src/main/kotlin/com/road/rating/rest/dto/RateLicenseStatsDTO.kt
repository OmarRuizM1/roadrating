package com.road.rating.rest.dto

import com.road.rating.adapters.repository.doc.RateLicenseStats

data class RateLicenseStatsDTO(
    val positiveStats: List<RateLicenseStats>,
    val negativeStats: List<RateLicenseStats>
)
