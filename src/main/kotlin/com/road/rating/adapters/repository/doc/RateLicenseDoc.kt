package com.road.rating.adapters.repository.doc


import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class RateLicenseDoc(
    @Id
    val id: String,
    val license: String,
    val reviews: Set<String>,
    val assessment: String,
    @Version val version: Int = 0
)
