package com.road.rating.domain.validation

import com.road.rating.domain.constants.Tags
import com.road.rating.domain.model.RateLicenseModel
import org.springframework.stereotype.Component

@Component
class TagValidation : RateLicenseValidator {
    override fun validate(rateLicenseModel: RateLicenseModel) {
        if (!Tags.spanishTags.containsAll(rateLicenseModel.tags)) {
            throw ValidationException("At least one of the tags does not exist")
        }
    }
}