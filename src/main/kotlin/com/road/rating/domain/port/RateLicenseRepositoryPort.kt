package com.road.rating.domain.port

import com.road.rating.domain.model.RateLicenseModel

interface RateLicenseRepositoryPort {

    fun save(rateLicenseModel: RateLicenseModel)
}