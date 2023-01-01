package com.road.rating.domain

import com.road.rating.adapters.RateLicenseDocRepositoryAdapter
import com.road.rating.domain.constants.Tags
import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.util.PrepareLicenseUtil
import com.road.rating.domain.validation.RateLicenseValidator
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Component

@Component
class RateLicenseHandler(
    private val rateLicenseRepositoryPort: RateLicenseDocRepositoryAdapter,
    private val rateLicenseValidator: RateLicenseValidator,
    private val prepareLicenseUtil: PrepareLicenseUtil
) {
    fun rate(rateLicenseModel: RateLicenseModel) {
        rateLicenseModel.license = prepareLicenseUtil.prepare(rateLicenseModel.license)
        rateLicenseValidator.validate(rateLicenseModel)

        runBlocking {
            launch {
                saveLicense(rateLicenseModel)
            }
        }
    }

    suspend fun saveLicense(rateLicenseModel: RateLicenseModel) {
        rateLicenseRepositoryPort.save(rateLicenseModel)
    }

    fun tagOptions() = Tags.spanishTags
    fun assessmentOptions() = Assessment.values().toSet()
}