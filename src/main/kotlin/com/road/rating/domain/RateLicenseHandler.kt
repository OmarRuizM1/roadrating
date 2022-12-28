package com.road.rating.domain

import com.road.rating.adapters.RateLicenseDocRepositoryAdapter
import com.road.rating.domain.constants.Tags
import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.util.PrepareLicenseUtil
import com.road.rating.domain.validation.RateLicenseValidator
import org.springframework.stereotype.Component

@Component
class RateLicenseHandler(
    private val rateLicenseRepositoryPort: RateLicenseDocRepositoryAdapter,
    private val rateLicenseValidator: List<RateLicenseValidator>,
    private val prepareLicenseUtil: PrepareLicenseUtil
) {

    fun rate(rateLicenseModel: RateLicenseModel) {
        rateLicenseModel.license = prepareLicenseUtil.prepare(rateLicenseModel.license)
        rateLicenseValidator.parallelStream().forEach { it.validate(rateLicenseModel) }
        rateLicenseRepositoryPort.save(rateLicenseModel)
    }

    fun tagOptions() = Tags.spanishTags
    fun assessmentOptions() = Assessment.values().toSet()
}