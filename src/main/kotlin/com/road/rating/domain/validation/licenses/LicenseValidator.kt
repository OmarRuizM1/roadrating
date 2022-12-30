package com.road.rating.domain.validation.licenses

import com.road.rating.domain.model.RateLicenseModel

interface LicenseValidator {
    fun isCorrectLicense(rateLicenseModel: RateLicenseModel) : Boolean
}