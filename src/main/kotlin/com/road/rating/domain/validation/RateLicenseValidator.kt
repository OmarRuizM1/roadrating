package com.road.rating.domain.validation

import com.road.rating.domain.model.RateLicenseModel

interface RateLicenseValidator {
    fun validate(rateLicenseModel: RateLicenseModel)
}