package com.road.rating.adapters.repository

import com.road.rating.adapters.repository.doc.RateLicenseDoc
import org.springframework.data.mongodb.repository.MongoRepository

interface RateLicenseMongoDBRepository: MongoRepository<RateLicenseDoc,Long>
