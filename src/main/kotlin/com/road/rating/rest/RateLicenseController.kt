package com.road.rating.rest

import com.road.rating.domain.RateLicenseHandler
import com.road.rating.rest.dto.RateLicenseDTO
import com.road.rating.rest.mappers.toModel
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rate")
class RateLicenseController(private val rateLicenseHandler: RateLicenseHandler) {

    @PostMapping()
    fun rate(@RequestBody rateLicenseDto: RateLicenseDTO) = rateLicenseHandler.rate(rateLicenseDto.toModel())
}