package com.road.rating.rest

import com.road.rating.domain.RateLicenseHandler
import com.road.rating.rest.dto.RateLicenseRequestDTO
import com.road.rating.rest.mappers.toDto
import com.road.rating.rest.mappers.toModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/license")
class RateLicenseController(private val rateLicenseHandler: RateLicenseHandler) {

    @PostMapping("/rate")
    fun rate(@RequestBody rateLicenseRequestDto: RateLicenseRequestDTO) = rateLicenseHandler.rate(rateLicenseRequestDto.toModel())

    @GetMapping("/tagOptions")
    fun tagOptions() = rateLicenseHandler.tagOptions()

    @GetMapping("/assessmentOptions")
    fun assessmentOptions() = rateLicenseHandler.assessmentOptions()

    @GetMapping("/getLicenseStats")
    fun getLicenseStats(@RequestParam limit: Long?) = rateLicenseHandler.getLicenseStats(limit).toDto()

}