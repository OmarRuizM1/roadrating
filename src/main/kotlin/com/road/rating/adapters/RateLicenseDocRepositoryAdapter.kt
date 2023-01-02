package com.road.rating.adapters

import com.road.rating.adapters.repository.RateLicenseMongoDBRepository
import com.road.rating.adapters.repository.doc.RateLicenseDoc
import com.road.rating.adapters.repository.doc.RateLicenseStats
import com.road.rating.adapters.repository.mappers.toDoc
import com.road.rating.domain.constants.Constants.ASSESSMENT
import com.road.rating.domain.constants.Constants.COUNT
import com.road.rating.domain.constants.Constants.LICENSE
import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.port.RateLicenseRepositoryPort
import com.road.rating.rest.dto.RateLicenseStatsDTO
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Repository


@Repository
class RateLicenseDocRepositoryAdapter(
    private val rateLicenseMongoDBRepository: RateLicenseMongoDBRepository,
    private val mongoOperations: MongoOperations
) : RateLicenseRepositoryPort {

    private val defaultLimit: Long = 5

    override fun save(rateLicenseModel: RateLicenseModel) {
        rateLicenseMongoDBRepository.save(rateLicenseModel.toDoc())
    }

    override fun getLicenseStats(inputLimit: Long?): RateLicenseStatsDTO = runBlocking {
        val limit = inputLimit ?: defaultLimit
        val positiveStats = async { getStats(limit, Assessment.POSITIVE) }
        val negativeStats = async { getStats(limit, Assessment.NEGATIVE) }
        RateLicenseStatsDTO(positiveStats.await(), negativeStats.await())
    }

    private fun getStats(limit: Long, assessment: Assessment): List<RateLicenseStats> {
        val newAggregation = Aggregation.newAggregation(
            RateLicenseDoc::class.java,
            Aggregation.match(Criteria.where(ASSESSMENT).`is`(assessment.name)),
            Aggregation.group(LICENSE, ASSESSMENT).count().`as`(COUNT),
            Aggregation.sort(Sort.by(Sort.Direction.DESC, COUNT)),
            Aggregation.limit(limit)
        )
        return mongoOperations.aggregate(newAggregation, RateLicenseStats::class.java).mappedResults
    }
}