package com.road.rating.domain.validation

import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.validation.exception.ValidationException
import com.road.rating.domain.validation.licenses.LicenseValidator
import com.road.rating.domain.validation.tags.TagValidator
import org.springframework.stereotype.Component

@Component
class RateLicenseValidator(
    private val licenseValidator: List<LicenseValidator>,
    private val tagValidator: TagValidator,
) {
    fun validate(rateLicenseModel: RateLicenseModel) {
        if (licenseValidator.parallelStream().noneMatch { it.isCorrectLicense(rateLicenseModel) }) throw ValidationException(INVALID_LICENSE)
        if (!tagValidator.areCorrectTags(rateLicenseModel)) throw ValidationException(INVALID_TAGS)
    }

    companion object {
        const val INVALID_LICENSE = "Incorrect License"
        const val INVALID_TAGS = "Invalid Tags"
    }
}