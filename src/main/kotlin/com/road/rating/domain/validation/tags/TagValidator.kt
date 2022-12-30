package com.road.rating.domain.validation.tags

import com.road.rating.domain.constants.Tags
import com.road.rating.domain.model.RateLicenseModel
import org.springframework.stereotype.Component

@Component
class TagValidator {
    fun areCorrectTags(rateLicenseModel: RateLicenseModel) = Tags.spanishTags.containsAll(rateLicenseModel.tags)
}