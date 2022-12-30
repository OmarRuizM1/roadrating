package com.road.rating.adapters.repository.doc


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class RateLicenseDoc(
    @Id
    val id: String,
    val license: String,
    val tags: Set<String>,
    val assessment: String
)
