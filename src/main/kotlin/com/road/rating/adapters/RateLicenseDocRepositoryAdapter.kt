package com.road.rating.adapters

import com.road.rating.adapters.repository.RateLicenseMongoDBRepository
import com.road.rating.adapters.repository.doc.RateLicenseDoc
import com.road.rating.adapters.repository.doc.RateLicenseStatDoc
import com.road.rating.adapters.repository.doc.RateLicenseStatsDoc
import com.road.rating.adapters.repository.doc.RateTagStatDoc
import com.road.rating.adapters.repository.doc.RateTagStatsDoc
import com.road.rating.adapters.repository.mappers.toDoc
import com.road.rating.adapters.repository.mappers.toModel
import com.road.rating.domain.constants.Constants.ASSESSMENT
import com.road.rating.domain.constants.Constants.COUNT
import com.road.rating.domain.constants.Constants.LICENSE
import com.road.rating.domain.constants.Constants.TAGS
import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.model.RateLicenseStatsModel
import com.road.rating.domain.model.RateTagStatsModel
import com.road.rating.domain.port.RateLicenseRepositoryPort
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

    override fun save(rateLicenseModel: RateLicenseModel) {
        rateLicenseMongoDBRepository.save(rateLicenseModel.toDoc())
    }

    override fun getLicenseStats(limit: Long): RateLicenseStatsModel = runBlocking {
        val positiveStatsFuture = async { getStats(limit, Assessment.POSITIVE) }
        val negativeStatsFuture = async { getStats(limit, Assessment.NEGATIVE) }
        return@runBlocking RateLicenseStatsDoc(positiveStatsFuture.await(), negativeStatsFuture.await()).toModel()
    }

    private fun getStats(limit: Long, assessment: Assessment): List<RateLicenseStatDoc> {
        val aggregation = Aggregation.newAggregation(
            RateLicenseDoc::class.java,
            Aggregation.match(Criteria.where(ASSESSMENT).`is`(assessment.name)),
            Aggregation.group(LICENSE, ASSESSMENT).count().`as`(COUNT),
            Aggregation.sort(Sort.by(Sort.Direction.DESC, COUNT)),
            Aggregation.limit(limit)
        )
        return mongoOperations.aggregate(aggregation, RateLicenseStatDoc::class.java).mappedResults
    }

    override fun getStatsByTag(tag: String, limit: Long): RateTagStatsModel {
        val aggregation = Aggregation.newAggregation(
            RateLicenseDoc::class.java,
            Aggregation.match(Criteria.where(TAGS).`is`(tag)),
            Aggregation.group(LICENSE).count().`as`(COUNT),
            Aggregation.sort(Sort.by(Sort.Direction.DESC, COUNT)),
            Aggregation.limit(limit)
        )
        val rateTagStatsDoc = RateTagStatsDoc(tag, mongoOperations.aggregate(aggregation, RateTagStatDoc::class.java).mappedResults.toSet())

        return rateTagStatsDoc.toModel()
    }
}