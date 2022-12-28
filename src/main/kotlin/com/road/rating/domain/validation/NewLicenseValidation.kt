package com.road.rating.domain.validation

import com.road.rating.domain.model.RateLicenseModel
import java.util.regex.Pattern
import org.springframework.stereotype.Component

@Component
class NewLicenseValidation : RateLicenseValidator {

    private val newLicense = Pattern.compile("(?i)^\\d{4}?[ -]*([A-Z]{3})\$")
    private val oldLicense = Pattern.compile("(?i)^([A-Z]{1,2})?[ -]*\\d{4}?[ -]*([A-Z]{1,2})\$")

    override fun validate(rateLicenseModel: RateLicenseModel) {
        val newLicenseFind = newLicense.matcher(rateLicenseModel.license).find()
        val oldLicenseFind = oldLicense.matcher(rateLicenseModel.license).find()
        if (!newLicenseFind && !oldLicenseFind) throw ValidationException("Invalid License")
    }
}