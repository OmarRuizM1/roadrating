package com.road.rating.adapters.repository.doc


import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class RateLicenseDoc(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val license: String,
    val reviews: Set<String>,
    val assessment: String
)
