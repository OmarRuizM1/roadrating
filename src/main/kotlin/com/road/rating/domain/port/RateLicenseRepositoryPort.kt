package com.road.rating.domain.port

import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.model.RateLicenseStatsModel
import com.road.rating.domain.model.RateTagStatsModel

interface RateLicenseRepositoryPort {

    fun save(rateLicenseModel: RateLicenseModel)

    fun getLicenseStats(limit: Long): RateLicenseStatsModel
    fun getStatsByTag(tag: String, limit: Long): RateTagStatsModel
}