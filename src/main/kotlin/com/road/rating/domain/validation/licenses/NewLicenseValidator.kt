package com.road.rating.domain.validation.licenses

import com.road.rating.domain.model.RateLicenseModel
import java.util.regex.Pattern
import org.springframework.stereotype.Component

@Component
class NewLicenseValidator : LicenseValidator {

    private val newLicense = Pattern.compile("(?i)^\\d{4}?[ -]*([A-Z]{3})\$")

    override fun isCorrectLicense(rateLicenseModel: RateLicenseModel) = newLicense.matcher(rateLicenseModel.license).find()

}