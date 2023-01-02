package com.road.rating.domain.port

import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.rest.dto.RateLicenseStatsDTO

interface RateLicenseRepositoryPort {

    fun save(rateLicenseModel: RateLicenseModel)

    fun getLicenseStats(inputLimit: Long?): RateLicenseStatsDTO
}