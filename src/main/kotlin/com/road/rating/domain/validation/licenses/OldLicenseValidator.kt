package com.road.rating.domain.validation.licenses

import com.road.rating.domain.model.RateLicenseModel
import java.util.regex.Pattern
import org.springframework.stereotype.Component

@Component
class OldLicenseValidator : LicenseValidator {

    private val oldLicense = Pattern.compile("(?i)^([A-Z]{1,2})?[ -]*\\d{4}?[ -]*([A-Z]{1,2})\$")

    override fun isCorrectLicense(rateLicenseModel: RateLicenseModel) = oldLicense.matcher(rateLicenseModel.license).find()
}