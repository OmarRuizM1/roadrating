package com.road.rating.domain.port

import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.model.RateLicenseStatsModel
import com.road.rating.rest.dto.RateLicenseStatsResponseDTO

interface RateLicenseRepositoryPort {

    fun save(rateLicenseModel: RateLicenseModel)

    fun getLicenseStats(limit: Long): RateLicenseStatsModel
}