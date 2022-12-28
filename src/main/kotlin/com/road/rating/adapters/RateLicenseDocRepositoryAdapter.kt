package com.road.rating.adapters

import com.road.rating.adapters.repository.RateLicenseMongoDBRepository
import com.road.rating.adapters.repository.mappers.toDoc
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.port.RateLicenseRepositoryPort
import javax.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class RateLicenseDocRepositoryAdapter(
    private val rateLicenseMongoDBRepository: RateLicenseMongoDBRepository
) : RateLicenseRepositoryPort {

    @Transactional
    override fun save(rateLicenseModel: RateLicenseModel) {
        rateLicenseMongoDBRepository.save(rateLicenseModel.toDoc())
    }
}