package com.road.rating.rest

import com.road.rating.domain.RateLicenseHandler
import com.road.rating.rest.dto.RateLicenseDTO
import com.road.rating.rest.mappers.toModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/license")
class RateLicenseController(private val rateLicenseHandler: RateLicenseHandler) {

    @PostMapping("/rate")
    fun rate(@RequestBody rateLicenseDto: RateLicenseDTO) = rateLicenseHandler.rate(rateLicenseDto.toModel())

    @GetMapping("/tagOptions")
    fun tagOptions() = rateLicenseHandler.tagOptions()

    @GetMapping("/assessmentOptions")
    fun assessmentOptions() = rateLicenseHandler.assessmentOptions()

}